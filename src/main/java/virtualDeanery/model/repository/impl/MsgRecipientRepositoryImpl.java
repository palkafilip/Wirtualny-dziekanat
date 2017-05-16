package virtualDeanery.model.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.Msg_recipient;
import virtualDeanery.model.repository.Msg_recipientRepository;


@Repository
public class MsgRecipientRepositoryImpl implements Msg_recipientRepository {
	
	@Autowired
	DataSource datasource;

	private SessionFactory sessionFactory;
	
	@Autowired
	public MsgRecipientRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Msg_recipient> getMessagesByNiu(int niu) {

		List<Msg_recipient> msgRecipientList;
		
		//Pobieramy obiektu klasy Msg_recipient dla zalogowanego u¿ytkownika
		msgRecipientList = (List<Msg_recipient>) sessionFactory.getCurrentSession().createCriteria(Msg_recipient.class).add(Restrictions.like("niu_recipient", niu)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return msgRecipientList;
	}

}
