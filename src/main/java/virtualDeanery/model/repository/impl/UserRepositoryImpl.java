package virtualDeanery.model.repository.impl;

import java.util.List;
import javax.sql.DataSource;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUsersByLastName(String lastname) {
		List<User> listUser = null;
	
		//Pobieramy u¿ytkowników o danym nazwisku
		listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("lastname", lastname)).list();

		return listUser;
	}

}
