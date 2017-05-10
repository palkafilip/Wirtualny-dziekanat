package virtualDeanery.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import virtualDeanery.model.User;
import virtualDeanery.model.User_Finances;
import virtualDeanery.service.UserService;

@Controller
public class FinancesController
{
	@Autowired
	UserService userService;
	
	@RequestMapping("/finances")
	public String financesController(Model model, HttpSession session)
	{
		User user = (User) session.getAttribute("loggedInUser");
		
		List<User_Finances> userFinancesList = null;
		
		userFinancesList = userService.getUser_FinancesByNiu(user.getId());
		
		if(userFinancesList == null)
			System.out.println("Pusta lista");
		
		else
			System.out.println("Hej hej tam w oddali" + userFinancesList.get(0));
		
		
		return "finances";
	}
}
