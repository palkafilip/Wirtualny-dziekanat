package test;

import virtualDeanery.model.Msg_recipient;
import virtualDeanery.model.User_Account;
import virtualDeanery.model.repository.impl.MessageRepositoryImpl;
import virtualDeanery.model.repository.impl.MsgRecipientRepositoryImpl;
import virtualDeanery.model.repository.impl.TransactionRepositoryImpl;
import virtualDeanery.model.repository.impl.User_AccountRepositoryImpl;
import virtualDeanery.model.repository.impl.User_FinancesRepositoryImpl;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogingTest {
	
	
	
	private SessionFactory sessionFactory;

	
	//private Session session = null;
	
	@Before
	public void setup(){

		
		// setup the session factory

		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(User_Account.class);
		configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/deanery");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.current_session_context_class", "thread");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "");
		configuration.addResource("virtualDeanery/model/User_Account.hbm.xml");
	

		ServiceRegistry srb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(srb);

		
		
		
		
		
		
		
		
	}
	
	@Test
	public void user_account_test_for_loging(){
		User_Account usc= new User_Account();
		usc.setNiu(1002);
		usc.setPassword("marian");
		User_AccountRepositoryImpl user_accRepository= new User_AccountRepositoryImpl(sessionFactory);
		
		Assert.assertNotNull(user_accRepository.getUser_AccountByNiu(1002));
		Assert.assertEquals(user_accRepository.getUser_AccountByNiu(1002), usc);
		
	}
	
	
	
	
	@Test
	public void message_test(){
		MessageRepositoryImpl message = new MessageRepositoryImpl(sessionFactory);
		MsgRecipientRepositoryImpl msgrec = new MsgRecipientRepositoryImpl(sessionFactory);
		

		
		Assert.assertTrue(msgrec.getMessagesByNiu(0).isEmpty());
		Assert.assertNotNull(message.getAllMessagesByNiu(1234, msgrec.getMessagesByNiu(1234)));
	}
	
	@Test
	public void tarnsaction_test(){
		TransactionRepositoryImpl transrepo= new TransactionRepositoryImpl(sessionFactory);
		Assert.assertTrue(transrepo.getTransactionsByIdFinance(0).isEmpty());
		Assert.assertNotNull(transrepo.getTransactionsByIdFinance(2));
		
	}
	
	
	@Test
	public void user_Finances_test(){
		User_FinancesRepositoryImpl finances= new User_FinancesRepositoryImpl(sessionFactory);
		Assert.assertNull(finances.getUser_FinancesByNiu(0));
		//System.out.println(finances.getUser_FinancesByNiu(0));
	}
	
	@After

	public void after() {

		//session.close();

		sessionFactory.close();

	}
}
