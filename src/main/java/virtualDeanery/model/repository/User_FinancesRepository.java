package virtualDeanery.model.repository;

import virtualDeanery.model.User_Finances;

public interface User_FinancesRepository
{
	User_Finances getUser_FinancesByNiu(int niu);	
}
