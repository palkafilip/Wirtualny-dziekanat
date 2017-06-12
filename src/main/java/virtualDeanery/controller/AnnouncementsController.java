package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnouncementsController
{
	@RequestMapping("/announcements")
	public String announcementsController(Model model)
	{
		return "announcements";
	}

}
