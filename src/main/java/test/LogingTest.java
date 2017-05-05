package test;

import virtualDeanery.model.User_Account;
import virtualDeanery.model.repository.impl.User_AccountRepositoryImpl;

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

	User_Account usc= new User_Account();
	
	User_AccountRepositoryImpl user_accRepository;
	
	private SessionFactory sessionFactory;

	//private Session session = null;
	
	@Before
	public void setup(){
		usc.setNiu(1234);
		usc.setPassword("haslo");
		
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

		user_accRepository= new User_AccountRepositoryImpl(sessionFactory);
		
	}
	
	@Test
	public void user_account_test_for_loging(){
		Assert.assertNotNull(user_accRepository.getUser_AccountByNiu(1234));
		Assert.assertEquals(user_accRepository.getUser_AccountByNiu(1234), usc);

	}
	
	@After

	public void after() {

		//session.close();

		sessionFactory.close();

	}
}
