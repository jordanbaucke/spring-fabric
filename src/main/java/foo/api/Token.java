package foo.api;

import org.jasypt.util.text.StrongTextEncryptor;

public class Token {
	
	public String token;
	  
	  public Token(String key){
		  StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
		  strongTextEncryptor.setPassword("password");
		  // this is the authentication token user will send in order to use the web service
		  token = strongTextEncryptor.encrypt(key);
	  }
}
