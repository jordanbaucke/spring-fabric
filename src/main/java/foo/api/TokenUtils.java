package foo.api;

import org.springframework.security.core.userdetails.UserDetails;

import foo.user.User;

public interface TokenUtils {
	String getToken(UserDetails userDetails);
    String getToken(UserDetails userDetails, Long expiration);
    boolean validate(String token);
    User getUserFromToken(String token);
}
