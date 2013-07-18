package foo.api.endpoint;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import foo.api.ApiMethod;
import foo.persistence.ApiRepository;

@Controller
@RequestMapping(value = "/api")
@Secured("ROLE_USER")
public class ApiController {
	
	@Autowired
	private ApiRepository apiRepository;
	
	@PostConstruct	
	protected void initialize() {
		apiRepository.save(new ApiMethod("newMethod1"));
		apiRepository.save(new ApiMethod("newMethod2"));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(UserDetails userDetails, Model model) {
		model.addAttribute("methods",apiRepository.findAllMethods());
		return "api/index";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String createMapping(@RequestParam(value="title") String title, Model model){
		ApiMethod method = new ApiMethod(title);
		apiRepository.save(method);
		return "redirect:/api";
	}
	
	@RequestMapping(value = "methods.json", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Collection<ApiMethod> jsonGetMethods(HttpServletResponse response) {
		return apiRepository.findAllMethods();
	}
}
