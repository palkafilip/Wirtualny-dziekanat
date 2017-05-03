package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessagesController
{
	@RequestMapping("/messages")
	public String messagesController(Model model)
	{
		return "messages";
	}
}
