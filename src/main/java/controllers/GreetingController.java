package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	@RequestMapping("/home")
	public String loadHomePage(Model m) {
		m.addAttribute("name", "CodeTudftr");
		return "home";
	}
}