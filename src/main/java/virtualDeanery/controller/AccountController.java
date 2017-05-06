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
public class AccountController {

	@Autowired
	UserService userService;

	@RequestMapping("/account")
	public String accountController(Model model) {
		return "account";
	}

	@RequestMapping(value = "/changeContact", method = RequestMethod.POST)
	public String changeContactDetails(@RequestParam String phone, @RequestParam String email,
			@RequestParam String address, @RequestParam String city, @RequestParam String post_code,
			HttpSession session, Model model) {

		userService.changeContactDetails(phone, email, address, city, post_code,
				(User) session.getAttribute("loggedInUser"));
		return "account";

	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam String currentPassword, @RequestParam String newPassword1,
			@RequestParam String newPassword2, HttpSession session, Model model) {

		String msg = userService.changePassword(currentPassword, newPassword1, newPassword2,
				(User) session.getAttribute("loggedInUser"));
		
		model.addAttribute("ChangePasswordMsg",msg);
		return "account";

	}
}
