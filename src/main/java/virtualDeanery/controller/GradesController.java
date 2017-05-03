package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GradesController
{
	@RequestMapping("/grades")
	public String gradesController(Model model)
	{
		return "grades";
	}
}