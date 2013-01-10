package foo.api;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class TokenService implements TokenUtils {
	
	Gson gson;
	
	public TokenService() {
		this.gson = new Gson();
	}

	/*
	 * (non-Javadoc)
	 * @see foo.api.TokenUtils#getToken(org.springframework.security.core.userdetails.UserDetails)
	 * Returns a token that expires in 24 hours
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
		if(currentTime.before(tokenToValidate.expiration) && tokenToValidate.username != null){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserDetails getUserFromToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToken(UserDetails userDetails, Long expiration) {
		// TODO Auto-generated method stub
		return null;
	}
}
