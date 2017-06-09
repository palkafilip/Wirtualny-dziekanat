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
public class AdminController {
	@Autowired
	UserService userService;

	@RequestMapping("/addUser")
	public String adminController(Model model) {
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String pesel,
			@RequestParam String address, @RequestParam String city, @RequestParam String post_code, 
			@RequestParam String email, @RequestParam String phone, @RequestParam String type, 
			@RequestParam String password1, @RequestParam String password2, HttpSession session, Model model) {
		
		if(password1.equals(password2)){
			userService.addUser(firstName, lastName, pesel, address, city, post_code, email, phone, type, password1, password2);
			
			model.addAttribute("message", "Uda³o siê ziomeczku");
			return "addUser";
		}
		
		model.addAttribute("message", "B³êdne has³o");
		return "addUser";

	}
	
	@RequestMapping("/editUser")
	public String editUser(Model model) {
		return "editUser";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(Model model) {
		return "deleteUser";
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam int niu,HttpSession session, Model model) {
		
		if(userService.deleteUser(niu)==false){
			model.addAttribute("message", "Brak konta o podanym niu");
			return "deleteUser";
		}
		
		model.addAttribute("message", "Konto usuniêto");
		return "deleteUser";
	}
}
