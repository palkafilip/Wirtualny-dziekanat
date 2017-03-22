package virtualDeanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import virtualDeanery.service.StudentService;

@Controller
public class StudentController
{
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/students")
	public String list(Model model)
	{
		model.addAttribute("students", studentService.getAllStudents());
		
		return "students";
	}

}
