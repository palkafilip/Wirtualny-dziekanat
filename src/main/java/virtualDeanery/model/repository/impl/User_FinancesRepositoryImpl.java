package virtualDeanery.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User_Finances> getUser_FinancesByNiu(int niu)
	{
		System.out.println("Niu u¿ytkownika w repozytorium : " + niu);
		List<User_Finances> userFinancesList = new ArrayList<User_Finances>();
		Session session = sessionFactory.getCurrentSession();
		userFinancesList = session.createCriteria(User_Finances.class).add(Restrictions.like("niu", niu)).list();
		return userFinancesList;
	}

}
