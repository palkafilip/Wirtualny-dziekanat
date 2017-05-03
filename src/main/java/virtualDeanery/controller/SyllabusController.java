package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SyllabusController
{
	@RequestMapping("/syllabus")
	public String syllabusController(Model model)
	{
		return "syllabus";
	}
}
