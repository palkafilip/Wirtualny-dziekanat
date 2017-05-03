package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController
{
	@RequestMapping("/application")
	public String applicationController(Model model)
	{
		return "application";
	}
}
