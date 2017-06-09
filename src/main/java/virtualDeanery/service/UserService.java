
package virtualDeanery.service;

import java.util.List;
import java.util.Map;

import virtualDeanery.model.Transaction;
import virtualDeanery.model.User;
import virtualDeanery.model.User_Account;
import virtualDeanery.model.User_Finances;

public interface UserService {


	User getUserByNiu(int niu);
	
	String getUserNameByNiu(int niu);

	User loginUser(int niu, String password);

	User loginUserTest(int niu, String imie);

	User_Account getUser_AccountByNiu(int niu);

	User_Finances getUser_FinancesByNiu(int niu); 
	List<Transaction> getUser_TransactionsByNiu(int niu);
	List <User> getUsersByLastName(String lastname);



	public void changeContactDetails(String newPhone, String newEmail, String newAddress, String newCity,
			String newPost_code, User user);

	public String changePassword(String currentPassword, String newPassword1, String newPassword2, User user);

	public Map<String, String> showMarksFromSemester(String semesterCode, int niu);
}


