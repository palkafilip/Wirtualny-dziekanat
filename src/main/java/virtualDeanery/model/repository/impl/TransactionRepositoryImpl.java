package virtualDeanery.model.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.Transaction;
import virtualDeanery.model.User_Finances;
import virtualDeanery.model.repository.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository
{
	
	@Autowired
	DataSource datasource;
	
	private SessionFactory sessionFactory;

	@Autowired
	public TransactionRepositoryImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Transaction> getTransactionsByIdFinance(int idFinance)
	{
		List<Transaction> transactionsList = null;
		
		Session session = sessionFactory.getCurrentSession();
		transactionsList = (List<Transaction>) session.createCriteria(Transaction.class).add(Restrictions.like("idFinance", idFinance)).list();
		
		return transactionsList;
	}

}
