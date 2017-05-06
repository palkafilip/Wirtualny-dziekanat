package virtualDeanery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import virtualDeanery.model.User;
import virtualDeanery.model.User_Account;
import virtualDeanery.model.repository.UserRepository;
import virtualDeanery.model.repository.User_AccountRepository;
import virtualDeanery.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserRepository userRepository;
	@Autowired
	User_AccountRepository user_accRepository;

	public List<User> getAllUsers()
	{
		return userRepository.getAllUsers();
	}

	public User getUserByNiu(int niu)
	{
		return userRepository.getUserByNiu(niu);
	}

	public User loginUserTest(int niu, String imie)
	{

		User user = userRepository.getUserByNiu(niu);
		System.out.println("Imie w parametrze " + imie);
		System.out.println("z bazy: " + user.getFirstname());
		if (user != null && user.getFirstname().equals(imie))
			return user;

		return null;
	}

	public User loginUser(int niu, String password)
	{
		System.out.println("Niu: "+niu+"\nPass: "+password);
		User_Account user_acc = user_accRepository.getUser_AccountByNiu(niu);
		
		System.out.println(user_acc);
		if (user_acc != null && user_acc.getPassword().equals(password))
		{
			User user = userRepository.getUserByNiu(niu);

			return user;
		}

		return null;
	}

	public User_Account getUser_AccountByNiu(int niu)
	{
		return user_accRepository.getUser_AccountByNiu(niu);
	}

	public List<User> getUsersByLastName(String lastname) {
		
		return userRepository.getUsersByLastName(lastname);
	}

}
