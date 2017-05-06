package virtualDeanery.service;

import java.util.List;

import virtualDeanery.model.User;
import virtualDeanery.model.User_Account;

public interface UserService
{
	List <User> getAllUsers();
	User getUserByNiu(int niu);
	List <User> getUsersByLastName(String lastname);
	User loginUser(int niu, String password);
	User loginUserTest(int niu, String imie);
	User_Account getUser_AccountByNiu(int niu);
	
}
