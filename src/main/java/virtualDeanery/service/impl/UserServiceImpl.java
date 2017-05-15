package virtualDeanery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import virtualDeanery.model.Transaction;
import virtualDeanery.model.User;
import virtualDeanery.model.User_Account;
import virtualDeanery.model.User_Finances;
import virtualDeanery.model.repository.TransactionRepository;
import virtualDeanery.model.repository.UserRepository;
import virtualDeanery.model.repository.User_AccountRepository;
import virtualDeanery.model.repository.User_FinancesRepository;
import virtualDeanery.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	User_AccountRepository user_accRepository;
	@Autowired
	User_FinancesRepository userFinancesRepository;
	@Autowired
	TransactionRepository transactionsRepository;

	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	public User getUserByNiu(int niu) {
		return userRepository.getUserByNiu(niu);
	}

	public User loginUserTest(int niu, String imie) {

		User user = userRepository.getUserByNiu(niu);
		System.out.println("Imie w parametrze " + imie);
		System.out.println("z bazy: " + user.getFirstname());
		if (user != null && user.getFirstname().equals(imie))
			return user;

		return null;
	}

	public User loginUser(int niu, String password) {
		System.out.println("Niu: " + niu + "\nPass: " + password);
		User_Account user_acc = user_accRepository.getUser_AccountByNiu(niu);

		System.out.println(user_acc);
		if (user_acc != null && user_acc.getPassword().equals(password)) {
			User user = userRepository.getUserByNiu(niu);

			return user;
		}

		return null;
	}

	public void changeContactDetails(String newPhone, String newEmail, String newAddress, String newCity,
			String newPost_code, User user) {
          
		if(!newPhone.equals("")){
			user.setPhone(newPhone);
		}
		if(!newEmail.equals("")){
			user.setEmail(newEmail);
		}
		if(!newAddress.equals("")){
			user.setAddress(newAddress);
		}
		if(!newCity.equals("")){
			user.setCity(newCity);
		}
		if(!newPost_code.equals("")){
			user.setPost_code(newPost_code);
		}       
	      userRepository.updateUser(user);
	}
	
	public String changePassword(String currentPassword, String newPassword1, String newPassword2, User user){
		
		User_Account user_acc = user_accRepository.getUser_AccountByNiu(user.getId());
		
		if(currentPassword.equals(user_acc.getPassword())){
			
			if(newPassword1.equals(newPassword2)){
				if(newPassword1.length()>5){
					
					user_acc.setPassword(newPassword1);
					user_accRepository.changePasssword(user_acc);
				}
				else{
					System.out.println("Has這 zakr鏒kie");
					return "Has這 za kr鏒kie";
				}
			}
			else{
				System.out.println("B貫dne powt鏎zenie nowego has豉");
				return "B貫dne powt鏎zenie nowego has豉";
			}
		}
		else{
			System.out.println("Obecne has這 jest nie prawid這we");
			return "Obecne has這 jest nie prawid這we";
		}
		System.out.println("Has這 zmienione");
		return "Has這 zosta這 zmienione";
	}

	public User_Account getUser_AccountByNiu(int niu) {
		return user_accRepository.getUser_AccountByNiu(niu);
	}

	public User_Finances getUser_FinancesByNiu(int niu)
	{
		
		return userFinancesRepository.getUser_FinancesByNiu(niu);
	}

	public List<Transaction> getUser_TransactionsByNiu(int niu)
	{
		User_Finances userFinances = userFinancesRepository.getUser_FinancesByNiu(niu);
		
		
		System.out.println("IdFinance: " + userFinances.getIdFinance());
		List<Transaction> list = transactionsRepository.getTransactionsByIdFinance(userFinances.getIdFinance());
		
		return list;
	}

}
