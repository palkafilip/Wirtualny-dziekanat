package virtualDeanery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import virtualDeanery.model.User;
import virtualDeanery.model.repository.UserRepository;
import virtualDeanery.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.getAllUsers();
	}

}
