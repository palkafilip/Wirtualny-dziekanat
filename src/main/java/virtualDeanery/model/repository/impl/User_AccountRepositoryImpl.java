package virtualDeanery.model.repository.impl;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.User_Account;
import virtualDeanery.model.repository.User_AccountRepository;

@Repository
public class User_AccountRepositoryImpl implements User_AccountRepository
{

	@Autowired
	DataSource datasource;
	
	private SessionFactory sessionFactory;

	@Autowired
	public User_AccountRepositoryImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public User_Account getUser_AccountByNiu(int niu)
	{
		User_Account user_acc = null;
		Session session = sessionFactory.getCurrentSession();
		user_acc = (User_Account) session.get(User_Account.class, niu);

		System.out.println(user_acc);
		return user_acc;
	}
	@Transactional
	public void changePasssword(User_Account user_acc){
		
		System.out.println("nowy" + user_acc);
		//Transaction trans;
		Session session = sessionFactory.getCurrentSession();
		//trans = session.beginTransaction();
		
		session.merge(user_acc);
		
		//trans.commit();
		
	}
}
