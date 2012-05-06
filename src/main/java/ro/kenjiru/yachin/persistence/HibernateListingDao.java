package ro.kenjiru.yachin.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.kenjiru.yachin.domain.Listing;

@Repository
public class HibernateListingDao implements ListingDao {
	@Autowired(required=true)
	private SessionFactory sessionFactory;

	public HibernateListingDao() { }

	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addListing(Listing listing) {
		currentSession().saveOrUpdate(listing);
		currentSession().flush();
	}

	@Override
	public List<Listing> getAll() {
		// Create a Hibernate query (HQL)
		Query query = currentSession().createQuery("from Listing");
		   
		// Retrieve all
		return query.list();
	}
}
