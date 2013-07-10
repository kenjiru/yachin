package ro.kenjiru.yachin.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.kenjiru.yachin.domain.Listing;
import ro.kenjiru.yachin.domain.Role;
import ro.kenjiru.yachin.domain.User;

@Repository
public class HibernateUserDao implements UserDao {

	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User getByUsername(String username) {
		User ret = (User)currentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		System.out.println("User " + ret.getUsername() +  " has roles: ");
		for (Role role : ret.getRoles()) {
			System.out.println(role.getAuthority());
		}
		return ret;
	}
	
	public User getById(long id) {
		return (User)currentSession().get(User.class, new Long(id));
	}
}
