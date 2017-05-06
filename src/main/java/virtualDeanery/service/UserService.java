package virtualDeanery.service;

import java.util.List;

import virtualDeanery.model.User;
import virtualDeanery.model.User_Account;

public interface UserService {
	List<User> getAllUsers();

	User getUserByNiu(int niu);

	User loginUser(int niu, String password);

	User loginUserTest(int niu, String imie);

	User_Account getUser_AccountByNiu(int niu);

	public void changeContactDetails(String newPhone, String newEmail, String newAddress, String newCity,
			String newPost_code, User user);

	public String changePassword(String currentPassword, String newPassword1, String newPassword2, User user);

}
