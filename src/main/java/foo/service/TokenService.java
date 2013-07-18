package foo.service;

import java.util.Collections;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import foo.api.Token;
import foo.api.TokenUtils;
import foo.user.User;
import foo.user.UserRepository;

@Service
public class TokenService implements TokenUtils {

	Gson gson;

	@Autowired
	private UserRepository userRepository;

	public TokenService() {
		this.gson = new Gson();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * foo.api.TokenUtils#getToken(org.springframework.security.core.userdetails
	 * .UserDetails) Returns a token that expires in 24 hours
	 */
	@Override
	public String getToken(UserDetails userDetails) {
		Date currentDate = new Date();
		Date expiration = DateUtils.addHours(currentDate, 24);
		Token token = new Token(userDetails.getUsername(), expiration);
		StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
		strongTextEncryptor.setPassword("password");

		return strongTextEncryptor.encrypt(gson.toJson(token));
	}

	@Override
	public boolean validate(String token) {
		StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
		strongTextEncryptor.setPassword("password");

		// decrypt json string
		String decryptedToken = strongTextEncryptor.decrypt(token);

		// demarshal json back to pojo
		Token tokenToValidate = gson.fromJson(decryptedToken, Token.class);

		// simple check if token is valid
		Date currentTime = new Date();
		if (currentTime.before(tokenToValidate.expiration)
				&& tokenToValidate.username != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getUserFromToken(String tokenString) {
		StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
		strongTextEncryptor.setPassword("password");

		// decrypt json string
		String decryptedToken = strongTextEncryptor.decrypt(tokenString);

		// demarshal json back to pojo
		Token token = gson.fromJson(decryptedToken, Token.class);

		User user = userRepository.findByUsername(token.username);
//		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
//		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
//				user.getUsername(), user.getPassword(),
//				Collections.singleton(authority));

		return user;
	}

	@Override
	public String getToken(UserDetails userDetails, Long expiration) {
		// TODO Auto-generated method stub
		return null;
	}
}
