package virtualDeanery.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import virtualDeanery.model.Message;
import virtualDeanery.model.User;
import virtualDeanery.service.MessageService;

@Controller
public class HomeController
{
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/home")
	public String homeController(Model model, HttpSession session)
	{
		User currentUser = (User) session.getAttribute("loggedInUser");
		List<Message> listMessage = messageService.getAllMessages(currentUser.getId());
		
		if(listMessage.isEmpty()){
			model.addAttribute("errorMessage", "Brak nowych wiadomoœci");
			return "home";
		}
		
		model.addAttribute("messageResult", listMessage);
		return "home";
	}
	
}
