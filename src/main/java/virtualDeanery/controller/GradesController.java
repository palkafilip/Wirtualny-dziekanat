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
public class GradesController {
	@Autowired
	UserService userService;

	@RequestMapping("/grades")
	public String gradesController(Model model) {
		return "grades";
	}

	@RequestMapping(value = "/showMarks", method = RequestMethod.POST)
	public String changePassword(@RequestParam String semesterCode, HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("loggedInUser");
		List<String> marksList = (userService).showMarksFromSemester(semesterCode, user.getId());
		
		if(marksList.isEmpty()){
			model.addAttribute("error","Brak ocen");
			return "grades";
		}
		
		model.addAttribute("grades",marksList);
		return "grades";

	}
}