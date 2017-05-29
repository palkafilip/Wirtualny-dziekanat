package virtualDeanery.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import virtualDeanery.model.User;
import virtualDeanery.service.MessageService;

@Controller
public class MessagesController
{
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/messages")
	public String messagesController(Model model)
	{
		return "messages";
	}
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public String sendMessage(@RequestParam int niu, @RequestParam String messageText, Model model, HttpSession session) {

		User currentUser = (User) session.getAttribute("loggedInUser");
		
		messageService.sendMessage(currentUser.getId(), niu, messageText);
		
		model.addAttribute("message", "Wiadomoœæ zosta³a wys³ana");
		return "messages";
	}
}
