package foo.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Secured("ROLE_USER")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String index(UserDetails userDetails, Model model) {
		return "user/index";
	}
	
	@RequestMapping(value = "user.json", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public User jsonGetUser(UserDetails userDetails) {
		return userRepository.findByUsername(userDetails.getUsername());
	}
}
