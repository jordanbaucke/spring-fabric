package foo.api;

import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements TokenUtils {

	public String token;

	public TokenService() {
//		StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
//		strongTextEncryptor.setPassword("password");
//		// this is the authentication token user will send in order to use the
//		// web service
//		token = strongTextEncryptor.encrypt(key);
	}

	@Override
	public String getToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToken(UserDetails userDetails, Long expiration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDetails getUserFromToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
