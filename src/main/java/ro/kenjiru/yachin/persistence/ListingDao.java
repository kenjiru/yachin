package ro.kenjiru.yachin.persistence;

import java.util.List;

import org.hibernate.Session;

import ro.kenjiru.yachin.domain.Listing;

public interface ListingDao {
	public Session currentSession();
	public void saveListing(Listing listing);
	public void deleteListing(Listing listing);
	public List<Listing> getAll();
}
