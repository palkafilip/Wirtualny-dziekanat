package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentsGradesController
{
	@RequestMapping("/studentsGrades")
	public String studentsGradesController(Model model)
	{
		return "studentsGrades";
	}

}
