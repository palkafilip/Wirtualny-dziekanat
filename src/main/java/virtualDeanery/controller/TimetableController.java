package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimetableController
{
	@RequestMapping("/timetable")
	public String timetableController(Model model)
	{
		return "timetable";
	}
}
