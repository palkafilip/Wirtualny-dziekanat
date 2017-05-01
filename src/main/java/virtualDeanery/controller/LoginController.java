package virtualDeanery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import virtualDeanery.model.User;
import virtualDeanery.service.UserService;

@Controller
public class LoginController
{

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm()
	{
		return "loginPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam int niu, @RequestParam String password, HttpSession session, Model model)
	{
		User user = userService.loginUser(niu, password);

		if (user == null)
		{
			model.addAttribute("loginError", "Wyst¹pi³ b³ad przy logowaniu, spróbuj ponownie");
			return "loginPage";
		}
		
		session.setAttribute("loggedInUser", user);
		System.out.println("Pierwszy " + session.getId());
		return "mainStudentPage";

	}
	
	@RequestMapping("/logout")
	public String testMethod(Model model, HttpSession session)
	{
		System.out.println("Drugi "+session.getId());
		
		session.invalidate();
		return "logoutPage";
	}

}
