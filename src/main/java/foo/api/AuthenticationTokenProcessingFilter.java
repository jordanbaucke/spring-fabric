package foo.api;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import foo.user.UserService;

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

    @Autowired UserService userService;
    @Autowired TokenUtils tokenUtils;
    AuthenticationManager authManager;

    public AuthenticationTokenProcessingFilter(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // Get request url parameters 
        //java.util.Map<String, String[]> parms = request.getParameterMap(); 
        
        //if(((java.util.Map<String, String[]>) parms).containsKey("token")) {
        if(((HttpServletRequest) request).getHeader("token") != null){
        	//String token = ((java.util.Map<String, String[]>) parms).get("token")[0]; // grab the first "token" parameter
        	String token = ((HttpServletRequest) request).getHeader("token");
        	
            // validate the token
            if (tokenUtils.validate(token)) {
                // determine the user based on the (already validated) to/ken
                UserDetails userDetails = tokenUtils.getUserFromToken(token);
                // build an Authentication object with the user's info
                UsernamePasswordAuthenticationToken authentication = 
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
                // set the authentication into the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authManager.authenticate(authentication));         
            }
        }
        // continue thru the filter chain
        chain.doFilter(request, response);
    }
}