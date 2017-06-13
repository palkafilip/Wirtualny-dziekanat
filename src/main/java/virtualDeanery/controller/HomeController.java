package virtualDeanery.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import virtualDeanery.model.Message;
import virtualDeanery.model.User;
import virtualDeanery.service.MessageService;
import virtualDeanery.service.UserService;

@Controller
public class HomeController
{
	
	@Autowired
	MessageService messageService;
	@Autowired
	UserService userService;
	
	@RequestMapping("/home")
	public String homeController(Model model, HttpSession session)
	{
		User currentUser = (User) session.getAttribute("loggedInUser");
		List<Message> listMessage = messageService.getAllMessages(currentUser.getId());
		
		List<String> sendersNames = new ArrayList<String>();
	
		if(listMessage.isEmpty()){
			model.addAttribute("errorMessage", "Brak nowych wiadomoœci");
			return "home";
		}
		
		for(int i=0; i<listMessage.size(); i++)
		{
			sendersNames.add(userService.getUserNameByNiu(listMessage.get(i).getNiu_sender()));
		}
		
		model.addAttribute("sendersNames", sendersNames);
		model.addAttribute("messageResult", listMessage);
		return "home";
	}
	
}
