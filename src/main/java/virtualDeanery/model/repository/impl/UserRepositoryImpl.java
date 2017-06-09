package virtualDeanery.model.repository.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.sql.DataSource;
import org.hibernate.Criteria;



import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.Mark;
import virtualDeanery.model.Subject;
import virtualDeanery.model.User;
import virtualDeanery.model.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	DataSource datasource;
	
	

	private SessionFactory sessionFactory;

	@Autowired
	public UserRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Transactional
	public User getUserByNiu(int niu) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		user = (User) session.get(User.class, niu);

		System.out.println(user);
		return user;
	}
	
	@Transactional
	public String getUserNameByNiu(int niu) {
		User user = null;
		String name = null;
		
		Session session = sessionFactory.getCurrentSession();
		user = (User) session.get(User.class, niu);
		name = user.getFirstname() + " " + user.getLastname();
		System.out.println(name);
		return name;
	}
	@Transactional
	public void updateUser(User user){
		
		System.out.println("nowy : " + user);
		//Transaction trans;
		Session session = sessionFactory.getCurrentSession();
		//trans = session.beginTransaction();
		session.update(user);
		//trans.commit();
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUsersByLastName(String lastname) {
		List<User> listUser = null;
	
		//Pobieramy u¿ytkowników o danym nazwisku
		listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("lastname", lastname)).add(Restrictions.like("account_type", "prowadzacy")).list();

		return listUser;
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	@Transactional
	public List<String> showMarksFromSemester(String semesterCode, int niu){
		List<String> marksList = new LinkedList<String>();
		List<Subject> subjects = null;
		List<Mark> marks = null;
		
		subjects = sessionFactory.getCurrentSession().createCriteria(Subject.class).add(Restrictions.like("semester_code", semesterCode)).list();
		marks = sessionFactory.getCurrentSession().createCriteria(Mark.class).add(Restrictions.like("niu", niu)).add(Restrictions.like("acronym_subject", "%")).addOrder(Order.asc("acronym_subject")).list();
	
		for(Subject s : subjects){
			for(Mark m : marks){
				if(m.getAcronym_subject().equals(s.getAcronym_subject())){
					marksList.add(s.getName()+" : "+m.getMark());
				}
			}
		}

		return marksList;
		
	}

}
