package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.CarFactory;

@Controller
public class IndexController {
	
	@Autowired
	private CarFactory carFactory;
	
	@RequestMapping("/")
	@Secured("ROLE_TELLER")
	@PreAuthorize("@mySecurityService.hasPermission('special', #m)")
	public String loadHomePage(Model m) {
		m.addAttribute("car", carFactory.BuildCar());
		return "th_index";
	}
}