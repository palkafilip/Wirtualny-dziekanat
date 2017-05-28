package virtualDeanery.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import virtualDeanery.model.Message;
import virtualDeanery.model.Msg_recipient;
import virtualDeanery.model.repository.MessageRepository;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

	@Autowired
	DataSource datasource;

	private SessionFactory sessionFactory;

	@Autowired
	public MessageRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Message> getAllMessagesByNiu(int niu, List<Msg_recipient> msgGetRecipientList) {

		//Lista przechowująca msg_id wiadomości dla zalogowanego użytkownika
		ArrayList<Integer> msgRecipientList = new ArrayList<Integer>();

		/**
		 * Pobieramy tylko msg_id z klasy Msg_recipient
		 */
		for (int i = 0; i < msgGetRecipientList.size(); i++) {
			msgRecipientList.add(msgGetRecipientList.get(i).getMsg_id());
		}

	
		//Lista przechowująca wiadomości użytkownika
		List<Message> listMessage = new ArrayList<Message>();
		
		/**
		 * Pobieramy wszystkie wiadomości dla zalogowanego użytkownika
		 */
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		for (int i = 0; i < msgRecipientList.size(); i++) {
			listMessage.add((Message) session.get(Message.class,msgRecipientList.get(i)));
		}
		trans.commit();
		
		return listMessage;
	}

}
