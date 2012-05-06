package ro.kenjiru.yachin.service;

import java.util.List;

import ro.kenjiru.yachin.domain.Listing;

public interface ListingService {
	public void createListing(Listing listing);
	public List<Listing> getAll();
}
