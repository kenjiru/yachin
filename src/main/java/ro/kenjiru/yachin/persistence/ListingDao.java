package ro.kenjiru.yachin.persistence;

import org.hibernate.Session;

import ro.kenjiru.yachin.domain.Listing;

public interface ListingDao {
	public Session currentSession();
	public void addListing(Listing listing);
}
