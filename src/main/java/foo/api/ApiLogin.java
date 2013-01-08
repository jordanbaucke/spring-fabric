package foo.api;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/login.json")
public class ApiLogin {

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  //public LoginStatus login(@RequestParam("j_username") String username,
  public Token login(@RequestParam("j_username") String username,
                           @RequestParam("j_password") String password) {
	  
	Date d = new Date();
	String append = username+password+d.toString();
	Token token = new Token(append);

    return token;
  }
}
