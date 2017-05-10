package virtualDeanery.service;

import java.util.List;

import virtualDeanery.model.User;
import virtualDeanery.model.User_Account;
import virtualDeanery.model.User_Finances;

public interface UserService
{
	List <User> getAllUsers();
	User getUserByNiu(int niu);
	User loginUser(int niu, String password);
	User loginUserTest(int niu, String imie);
	User_Account getUser_AccountByNiu(int niu);
	List <User_Finances> getUser_FinancesByNiu(int niu); 
	
}
