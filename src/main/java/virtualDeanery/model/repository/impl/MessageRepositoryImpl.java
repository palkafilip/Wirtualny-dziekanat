package virtualDeanery.model.repository.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.Group_User;
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

		//Lista przechowuj�ca msg_id wiadomo�ci dla zalogowanego u�ytkownika
		ArrayList<Integer> msgRecipientList = new ArrayList<Integer>();

		/**
		 * Pobieramy tylko msg_id z klasy Msg_recipient
		 */
		for (int i = 0; i < msgGetRecipientList.size(); i++) {
			msgRecipientList.add(msgGetRecipientList.get(i).getMsg_id());
		}

	
		//Lista przechowuj�ca wiadomo�ci u�ytkownika
		List<Message> listMessage = new ArrayList<Message>();
		
		/**
		 * Pobieramy wszystkie wiadomo�ci dla zalogowanego u�ytkownika
		 */
		for (int i = 0; i < msgRecipientList.size(); i++) {
			listMessage.add((Message) sessionFactory.getCurrentSession().get(Message.class,msgRecipientList.get(i)));
		}
		
		
		return listMessage;
	}

	@Transactional
	public void sendMessage(int senderNiu, int receiverNiu, String messageText) {
		
		Message lastMessage = new Message();

		//Pobieramy akrualna dat� i konwertujemy j� do Stringa
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("Data: "+date);
		
		Message message = new Message();
		message.setNiu_sender(senderNiu);
		message.setContent(messageText);
		message.setTitle("Wiadomo�� prywatna");
		message.setSend_date(date);
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(message);
		
		//Zatwierdzamy zmiany (commit)
		session.flush();
		
		//Kryterium do pobrania max msg_id
		DetachedCriteria maxId = DetachedCriteria.forClass(Message.class).setProjection( Projections.max("msg_id") );
		
		//Ostatnia dodana wiadomo��
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
	
	@Transactional
	public void sendMsgToMany(int senderNiu, List<Group_User> niuRecevierList, String messageText, Session session, String title) {
		
		Message lastMessage = new Message();
		Msg_recipient lastrec;

		//Pobieramy akrualna dat� i konwertujemy j� do Stringa
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("Data: "+date);
		
		Message message = new Message();
		message.setNiu_sender(senderNiu);
		message.setContent(messageText);
		message.setTitle(title);
		message.setSend_date(date);
		
		//Session session = sessionFactory.getCurrentSession();
		
		session.save(message);
		
		//Zatwierdzamy zmiany (commit)
		session.flush();
		
		//Kryterium do pobrania max msg_id
		DetachedCriteria maxId = DetachedCriteria.forClass(Message.class).setProjection( Projections.max("msg_id") );
		DetachedCriteria mrd = DetachedCriteria.forClass(Msg_recipient.class).setProjection( Projections.max("mr_id") );
		
		//Ostatnia dodana wiadomo��
		lastMessage = (Message) session.createCriteria(Message.class).add( Property.forName("msg_id").eq(maxId) ).uniqueResult();
		//ostatnie id z msg_rec
		lastrec=(Msg_recipient) session.createCriteria(Msg_recipient.class).add( Property.forName("mr_id").eq(mrd) ).uniqueResult();
		int i=lastrec.getMr_id();
		i++;
		
		for( Group_User gu : niuRecevierList){
			
			//Tworzenie obiektu msg_recipient
			
			Msg_recipient msg_recipient = new Msg_recipient();
			msg_recipient.setIs_read(0);
			msg_recipient.setMsg_id(lastMessage.getMsg_id());
			msg_recipient.setNiu_recipient(gu.getNiu());
			msg_recipient.setMr_id(i);
			i++;
			
			System.out.println("GU niu: " + gu.getNiu());
			//zapis do bazy danych
			
			session.save(msg_recipient);

			
		}
		
		//session.flush();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void sendAnnon(int senderNiu, String idGroup, String annonText, String title){
		
		Session session = sessionFactory.getCurrentSession();
		List<Group_User> niuRecevierList;
		
		niuRecevierList = (List<Group_User>) session.createCriteria(Group_User.class).add(Restrictions.like("group_id", idGroup)).list();
		
		sendMsgToMany(senderNiu,niuRecevierList , annonText, session, title);
		
	}

}
