package virtualDeanery.model.repository;

import virtualDeanery.model.User_Account;

public interface User_AccountRepository
{
	User_Account getUser_AccountByNiu(int niu);
	public void changePasssword(User_Account user_acc);
}
