package virtualDeanery.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.User_Account;
import virtualDeanery.model.User_Finances;
import virtualDeanery.model.repository.User_FinancesRepository;

@Repository
public class User_FinancesRepositoryImpl implements User_FinancesRepository
{
	
	@Autowired
	DataSource datasource;
	
	private SessionFactory sessionFactory;

	@Autowired
	public User_FinancesRepositoryImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public User_Finances getUser_FinancesByNiu(int niu)
	{
		System.out.println("Niu u¿ytkownika w repozytorium : " + niu);
		User_Finances userFinances = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		List<User_Finances> finances=session.createCriteria(User_Finances.class).add(Restrictions.like("niu", niu)).list();
		if(finances.isEmpty()) return null;
		userFinances = (User_Finances) finances.get(0);
//		userFinances = (User_Finances) session.get(User_Finances.class, niu);
		trans.commit();
		return userFinances;
	}

}
