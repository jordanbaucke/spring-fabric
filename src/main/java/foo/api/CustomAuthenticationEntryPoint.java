package foo.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@SuppressWarnings("null")
	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Authentication token was either missing or invalid." );
	}
}