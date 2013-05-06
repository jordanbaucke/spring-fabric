package foo.controller;

import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import foo.api.TokenService;
import foo.user.User;
import foo.user.UserRepository;

@Controller
@RequestMapping("/api/authenticate")
public class AuthenticateController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	TokenService tokenService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		// lookup the user in the database
		User user = userRepository.findByUsername(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(),
				Collections.singleton(authority));
		return tokenService.getToken(userDetails);
	}
}
