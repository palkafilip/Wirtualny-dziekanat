package virtualDeanery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FinancesController
{
	@RequestMapping("/finances")
	public String financesController(Model model)
	{
		return "finances";
	}
}
