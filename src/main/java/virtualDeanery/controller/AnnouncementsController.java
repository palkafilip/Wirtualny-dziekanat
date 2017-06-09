package virtualDeanery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import virtualDeanery.model.User;
import virtualDeanery.service.MessageService;

@Controller
public class AnnouncementsController
{
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/announcements")
	public String announcementsController(Model model)
	{
		return "announcements";
	}
	
	@RequestMapping(value = "/sendAnnon", method = RequestMethod.POST)
	public String sendAnnon(@RequestParam String idGroup, @RequestParam String annonText, @RequestParam String title, Model model, HttpSession session) {

		User currentUser = (User) session.getAttribute("loggedInUser");
		
		messageService.sendAnnon(currentUser.getId(), idGroup, annonText,title);
		
		model.addAttribute("message", "Og³oszenie zosta³o dodane");
		return "announcements";
	}

}
