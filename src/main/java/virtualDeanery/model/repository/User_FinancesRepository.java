package virtualDeanery.model.repository;

import java.util.List;

import virtualDeanery.model.User_Finances;

public interface User_FinancesRepository
{
	List<User_Finances> getUser_FinancesByNiu(int niu);
	
}
