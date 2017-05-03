package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LecturersController
{
	@RequestMapping("/lecturers")
	public String lecturersController(Model model)
	{
		return "lecturers";
	}
}
