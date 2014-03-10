package controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String loadHomePage(Model m) {
		m.addAttribute("name", "ivan");
		return "jsp_hello";
	}
}
