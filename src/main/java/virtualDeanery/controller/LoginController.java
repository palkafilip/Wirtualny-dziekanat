package virtualDeanery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import virtualDeanery.model.Student;
import virtualDeanery.service.StudentService;

@Controller
public class LoginController
{
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping( value="/login", method = RequestMethod.GET)
	public String showLoginForm()
	{
		return "loginPage";
	}
	
	@RequestMapping( value="/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String pesel, @RequestParam String imie, HttpSession session, Model model)
	{
		
		Student student = studentService.loginStudent(pesel, imie);
		
		if(student == null)
		{
			model.addAttribute("loginError", "Wyst¹pi³ b³ad przy logowaniu, spróbuj ponownie");
			return "loginPage";
		}
			
		
		session.setAttribute("loggedInStudent", student);
		return "mainStudentPage";
		
	}

}
