package virtualDeanery.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import virtualDeanery.model.Transaction;
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
		
		List<Transaction> transactionsList = userService.getUser_TransactionsByNiu(user.getId());
		
		if(transactionsList.isEmpty())
		{
			model.addAttribute("errorMessage", "Brak finansów");
			return "finances";
		}
		
		model.addAttribute("transactions", transactionsList);

		System.out.println(transactionsList);
		return "finances";
	}
}
