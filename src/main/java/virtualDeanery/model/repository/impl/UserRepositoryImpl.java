package virtualDeanery.model.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.User;
import virtualDeanery.model.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository{
	private SessionFactory sessionFactory;
	 
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    @Transactional
	public List<User> getAllUsers() {
    	 @SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    	 
    	 System.out.println(listUser.get(0).getFirstname());
    	 System.out.println(listUser.get(0).getLastname());
    	 
        return listUser;
	}

}
