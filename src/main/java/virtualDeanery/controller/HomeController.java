package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
	@RequestMapping("/")
	public String welcome(Model model)
	{
		return "redirect:/login";
	}
	
	
	@RequestMapping("/test")
	public String test(Model model)
	{
		return "test";
	}
}
