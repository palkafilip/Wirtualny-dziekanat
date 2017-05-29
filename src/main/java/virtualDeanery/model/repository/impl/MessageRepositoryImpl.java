package virtualDeanery.model.repository.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

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

		//Lista przechowuj¹ca msg_id wiadomoœci dla zalogowanego u¿ytkownika
		ArrayList<Integer> msgRecipientList = new ArrayList<Integer>();

		/**
		 * Pobieramy tylko msg_id z klasy Msg_recipient
		 */
		for (int i = 0; i < msgGetRecipientList.size(); i++) {
			msgRecipientList.add(msgGetRecipientList.get(i).getMsg_id());
		}

	
		//Lista przechowuj¹ca wiadomoœci u¿ytkownika
		List<Message> listMessage = new ArrayList<Message>();
		
		/**
		 * Pobieramy wszystkie wiadomoœci dla zalogowanego u¿ytkownika
		 */
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		for (int i = 0; i < msgRecipientList.size(); i++) {
			listMessage.add((Message) session.get(Message.class,msgRecipientList.get(i)));
		}
		trans.commit();
		
		return listMessage;
	}

	@Transactional
	public void sendMessage(int senderNiu, int receiverNiu, String messageText) {
		
		Message lastMessage = new Message();

		//Pobieramy akrualna datê i konwertujemy j¹ do Stringa
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("Data: "+date);
		
		Message message = new Message();
		message.setNiu_sender(senderNiu);
		message.setContent(messageText);
		message.setTitle("Wiadomoœæ prywatna");
		message.setSend_date(date);
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(message);
		
		//Zatwierdzamy zmiany (commit)
		session.flush();
		
		//Kryterium do pobrania max msg_id
		DetachedCriteria maxId = DetachedCriteria.forClass(Message.class).setProjection( Projections.max("msg_id") );
		
		//Ostatnia dodana wiadomoœæ
		lastMessage = (Message) session.createCriteria(Message.class).add( Property.forName("msg_id").eq(maxId) ).uniqueResult();
		
		//Tworzenie obiektu msg_recipient
		Msg_recipient msg_recipient = new Msg_recipient();
		msg_recipient.setIs_read(0);
		msg_recipient.setMsg_id(lastMessage.getMsg_id());
		msg_recipient.setNiu_recipient(receiverNiu);
		
		//zapis do bazy danych
		session.save(msg_recipient);
		session.flush();
	}

}
