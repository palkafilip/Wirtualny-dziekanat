
package virtualDeanery.model.repository;

import java.util.List;

import virtualDeanery.model.User;

public interface UserRepository {
	List <User> getAllUsers();
	String getUserNameByNiu(int niu);
	User getUserByNiu(int niu);
	public void updateUser(User user);
	List <User> getUsersByLastName(String lastname);
	public List<String> showMarksFromSemester(String semesterCode, int niu);
	
	void createUser(String firstName, String lastName, String pesel, String address, String city, String post_code,
			String email, String phone, String account_type);
	
	void deleteUser(int niu);
}


