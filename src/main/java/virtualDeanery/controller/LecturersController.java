package virtualDeanery.controller;

import java.util.List;

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
public class LecturersController
{
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/lecturers")
	public String lecturersController(Model model)
	{
		return "lecturers";
	}
	
	@RequestMapping(value = "/lecturers", method = RequestMethod.POST)
	public String searchLecturers(@RequestParam String lastname, HttpSession session, Model model)
	{
		List<User> users = userService.getUsersByLastName(lastname);

		if (users.isEmpty())
		{
			model.addAttribute("errorMessage", "Brak prowadz¹cych o podanym nazwisku");
			return "lecturers";
		}
		
		model.addAttribute("lecturersResult", users);
		return "lecturers";
	}
}

