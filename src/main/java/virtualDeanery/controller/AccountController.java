package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController
{
	@RequestMapping("/account")
	public String accountController(Model model)
	{
		return "account";
	}
}
