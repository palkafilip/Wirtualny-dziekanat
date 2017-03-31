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
//		model.addAttribute("witaj", "witaj na naszej stronie");
		
		return "redirect:/login";
	}

}
