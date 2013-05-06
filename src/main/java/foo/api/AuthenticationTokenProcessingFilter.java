package foo.api;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import foo.user.User;
import foo.user.UserService;

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

	@Autowired
	UserService userService;
	@Autowired
	TokenUtils tokenUtils;
	@Autowired
	MonitorService monitorService;
	
	private AuthenticationManager authManager;
	private User user;
	
	public AuthenticationTokenProcessingFilter(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Get request url parameters
		// java.util.Map<String, String[]> parms = request.getParameterMap();

		// if(((java.util.Map<String, String[]>) parms).containsKey("token")) {
		if (((HttpServletRequest) request).getHeader("token") != null) {
			// String token = ((java.util.Map<String, String[]>)
			// parms).get("token")[0]; // grab the first "token" parameter
			String token = ((HttpServletRequest) request).getHeader("token");

			// servletResponse.setServletResponse(response);

			// validate the token
			if (tokenUtils.validate(token)) {
				// determine the user based on the (already validated) to/ken
				user = tokenUtils.getUserFromToken(token);

				GrantedAuthority authority = new SimpleGrantedAuthority(
						user.getRole());
				UserDetails userDetails = new org.springframework.security.core.userdetails.User(
						user.getUsername(), user.getPassword(),
						Collections.singleton(authority));

				// build an Authentication object with the user's info
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails.getUsername(), userDetails.getPassword(),
						userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource()
						.buildDetails((HttpServletRequest) request));

				// set the authentication into the SecurityContext
				SecurityContextHolder.getContext().setAuthentication(
						authManager.authenticate(authentication));
			}
		}

		long startTime = System.currentTimeMillis();

		// continue thru the filter chain
		chain.doFilter(request, response);

		long endTime = System.currentTimeMillis();
		long executionTime = (endTime - startTime);
		UsageMonitor usage = new UsageMonitor(user.getId(), request.getRemoteAddr(), ((HttpServletResponse) response).getStatus(), ((HttpServletRequest)request).getRequestURL().toString(), startTime, endTime, executionTime, "");
		monitorService.logUsage(usage);
	}
}