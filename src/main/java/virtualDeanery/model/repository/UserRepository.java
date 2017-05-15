package virtualDeanery.model.repository;

import java.util.List;

import virtualDeanery.model.User;

public interface UserRepository {
	List <User> getAllUsers();
	User getUserByNiu(int niu);
	public void updateUser(User user);
}
