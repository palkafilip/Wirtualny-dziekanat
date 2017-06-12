package test;

import virtualDeanery.model.Mark;
import virtualDeanery.model.Message;
import virtualDeanery.model.Msg_recipient;
import virtualDeanery.model.User;
import virtualDeanery.model.User_Account;
import virtualDeanery.model.repository.impl.MessageRepositoryImpl;
import virtualDeanery.model.repository.impl.MsgRecipientRepositoryImpl;
import virtualDeanery.model.repository.impl.TransactionRepositoryImpl;
import virtualDeanery.model.repository.impl.UserRepositoryImpl;
import virtualDeanery.model.repository.impl.User_AccountRepositoryImpl;
import virtualDeanery.model.repository.impl.User_FinancesRepositoryImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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
		configuration.addResource("virtualDeanery/model/Mark.hbm.xml");
		configuration.addResource("virtualDeanery/model/Message.hbm.xml");
		configuration.addResource("virtualDeanery/model/Msg_recipient.hbm.xml");
		configuration.addResource("virtualDeanery/model/Subject.hbm.xml");
		configuration.addResource("virtualDeanery/model/Transaction.hbm.xml");
		configuration.addResource("virtualDeanery/model/User_Finances.hbm.xml");
		configuration.addResource("virtualDeanery/model/User.hbm.xml");
		
		
		
		ServiceRegistry srb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(srb);
		
	}
	
	@Test
	public void user_account_test_for_loging(){
		User_Account usc= new User_Account();
		usc.setNiu(1002);
		usc.setPassword("student");
		User_AccountRepositoryImpl user_accRepository= new User_AccountRepositoryImpl(sessionFactory);
		
		Assert.assertNotNull(user_accRepository.getUser_AccountByNiu(1002));
		Assert.assertEquals(user_accRepository.getUser_AccountByNiu(1002), usc);
		
	}
	
	
	
	
	@Test
	public void message_test(){
		MessageRepositoryImpl message = new MessageRepositoryImpl(sessionFactory);
		MsgRecipientRepositoryImpl msgrec = new MsgRecipientRepositoryImpl(sessionFactory);
		

		
		Assert.assertTrue(msgrec.getMessagesByNiu(0).isEmpty());
		Assert.assertNotNull(message.getAllMessagesByNiu(1002, msgrec.getMessagesByNiu(1002)));
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
	
	@Test
	public void send_messages_test() throws Exception{
		MessageRepositoryImpl message = new MessageRepositoryImpl(sessionFactory);
		MsgRecipientRepositoryImpl msgrec = new MsgRecipientRepositoryImpl(sessionFactory);
		List<Message> listaMSG;
		List<Msg_recipient> listaREC;
		boolean content=false;
		boolean title=false;
		boolean sender=false;
		boolean date=false;
		boolean id=false;
		int msgID=0;
		message.sendMessage(1004, 1002, "test");
		listaMSG= message.getAllMessagesByNiu(1002, msgrec.getMessagesByNiu(1002));
		for(Message m: listaMSG){
			if(m.getContent().equals("test")){
				content=true;
				msgID=m.getMsg_id();
				if(m.getTitle().equals("Wiadomo?? prywatna")) title=true;
				if(m.getNiu_sender()==1004) sender=true;
				if(m.getSend_date().equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))) date=true;
			}
		}
		Assert.assertTrue(content);
		Assert.assertTrue(title);
		Assert.assertTrue(sender);
		Assert.assertTrue(date);
		
		listaREC=msgrec.getMessagesByNiu(1002);
		for(Msg_recipient m: listaREC){
			if(m.getMsg_id()==msgID) id=true;
		}
		Assert.assertTrue(id);
	}
	
//	@Test
	public void null_msg_test() throws Exception{
		MessageRepositoryImpl message = new MessageRepositoryImpl(sessionFactory);
		MsgRecipientRepositoryImpl msgrec = new MsgRecipientRepositoryImpl(sessionFactory);
		List<Message> listaMSG;
		List<Msg_recipient> listaREC;
		
		try{
			message.sendMessage(0, 0, null);
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
		
		message.sendMessage(0, 0, "");
		listaMSG= message.getAllMessagesByNiu(0, msgrec.getMessagesByNiu(0));
		for(Message m: listaMSG){
			if(m.getNiu_sender()==0) Assert.fail("Niu_sedner = 0");
				
		}
		
		listaREC=msgrec.getMessagesByNiu(1002);
		for(Msg_recipient m: listaREC){
			if(m.getMsg_id()==0) Assert.fail("Niu_recipient = 0");
		}		
		
	}
	
	@Test
	public void User_test(){
		UserRepositoryImpl userRepo = new UserRepositoryImpl(sessionFactory);
		User user;
		Assert.assertNotNull(user=userRepo.getUserByNiu(1004));
		
		
		user.setAccount_type("prowadzacy");
		user.setAddress("ul. Wielka 5");
		user.setCity("Zakliczyn");
		user.setPost_code("76-098");
		user.setEmail("grzepcio0957@onet.pl");
		user.setFirstname("Marcjusz");
		user.setLastname("Grzebcio");
		user.setPesel("89678912654");
		user.setPhone("234098123");
		
		userRepo.updateUser(user);
		Assert.assertEquals(userRepo.getUserByNiu(1004), user);
		Assert.assertNotNull("Brak u¿ytkowników", userRepo.getAllUsers());
		Assert.assertFalse("Brak studenta o nazwisku Mostowiak", userRepo.getUsersByLastName("Grzebcio").isEmpty());	
	}
	
	
	@Test
	public void User_Marks_test(){
		UserRepositoryImpl userRepo = new UserRepositoryImpl(sessionFactory);
		List<String> lista=userRepo.showMarksFromSemester("2017_1", 1002);
		Assert.assertFalse("brak ocen dla niu 1002", lista.isEmpty());
		boolean ocena=false;
		
		for(String s: lista){
			if(s.equals("Matematyka : 4.0")) ocena=true;
			System.out.println(s);
		}
		
		
		Assert.assertTrue("Brak oceny w bazie dla niu 1002", ocena);
		
	}
	
	
	@Test
	public void createUser_and_deleteUser_test(){
		UserRepositoryImpl userRepo = new UserRepositoryImpl(sessionFactory);
		userRepo.createUser("Janusz", "Cebula", "78562309421", "Wokowice 1", "Brzesko", "34-123", "cebula@janusz.pl", "563123987", "prowadzacy");
		Assert.assertFalse(userRepo.getUsersByLastName("Cebula").isEmpty());
	//	userRepo.deleteUser(1005);
	//	Assert.assertTrue(userRepo.getUsersByLastName("Cebula").isEmpty());
	}
	
	
	@Test
	public void sendToMany_test(){
		MessageRepositoryImpl message = new MessageRepositoryImpl(sessionFactory);
		MsgRecipientRepositoryImpl msgrec = new MsgRecipientRepositoryImpl(sessionFactory);
		List<Message> listaMSG;
		List<Msg_recipient> listaREC;
		
		boolean content=false;
		boolean title=false;
		boolean sender=false;
		boolean date=false;
		boolean id=false;
		int msgID=0;
		message.sendAnnon(1004, "MT_G2_P", "test dla wszystkich", "test 1004");
		listaMSG= message.getAllMessagesByNiu(1002, msgrec.getMessagesByNiu(1002));
		for(Message m: listaMSG){
			System.out.println("wiadomosc: "+m.getContent());
			
			if(m.getContent().equals("test dla wszystkich")){
				content=true;
				msgID=m.getMsg_id();
				if(m.getTitle().equals("test 1004")) title=true;
				if(m.getNiu_sender()==1004) sender=true;
				if(m.getSend_date().equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))) date=true;
			}
		}
		Assert.assertTrue(content);
		Assert.assertTrue(title);
		Assert.assertTrue(sender);
		Assert.assertTrue(date);
		
		listaREC=msgrec.getMessagesByNiu(1002);
		for(Msg_recipient m: listaREC){
			if(m.getMsg_id()==msgID) id=true;
		}
		Assert.assertTrue(id);
	}
	
	
	@After

	public void after() {

		//session.close();

		sessionFactory.close();

	}
}
