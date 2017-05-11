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
		
//		userFinances = userService.getUser_FinancesByNiu(user.getId());
//		
//		if(userFinances == null)
//			System.out.println("Pusta lista");
//		
//		else
//			System.out.println("Hej hej tam w oddali" + userFinances);
		
		
		System.out.println(transactionsList);
		return "finances";
	}
}
