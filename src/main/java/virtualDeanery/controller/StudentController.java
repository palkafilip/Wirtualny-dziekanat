package virtualDeanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import virtualDeanery.model.Student;
import virtualDeanery.service.StudentService;

@RequestMapping("/students")
@Controller
public class StudentController
{
	@Autowired
	StudentService studentService;
	
	@RequestMapping()
	public String list(Model model)
	{
		model.addAttribute("students", studentService.getAllStudents());
		
		return "students";
	}
	
	@RequestMapping(value = "/logIn", method = RequestMethod.GET)
	public String getLogInForm(Model model)
	{
		Student activeStudent = new Student();
		model.addAttribute("activeStudent", activeStudent);
		
		return "logIn";
	}
	
	@RequestMapping(value = "/logIn", method = RequestMethod.POST)
	public String logInForm(@ModelAttribute("activeStudent") Student activeStudent, Model model)
	{
		activeStudent = studentService.getStudentByPesel(activeStudent.getPesel());
		System.out.println(activeStudent);
		model.addAttribute("activeStudent", activeStudent);
		return "mainStudentPage";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewStudentForm(Model model)
	{
		Student newStudent = new Student();
		model.addAttribute("newStudent", newStudent);
		return "addStudent";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String processAddNewStudentForm(@ModelAttribute("newStudent") Student newStudent)
	{
		studentService.addStudent(newStudent);
		System.out.println(newStudent);
		return "redirect:/students";
	}

}
