package foo.api;

import java.util.Date;

/*
 * Token
 * Data-structure for token
 */
public class Token {
	public String username;
	public Date expiration;
	
	public Token(String username, Date expiration){
		this.username = username;
		this.expiration = expiration;
	}
}
