package ro.kenjiru.yachin.persistence;

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
		currentSession().save(listing);
	}
}
