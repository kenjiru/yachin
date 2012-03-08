package ro.kenjiru.yachin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.kenjiru.yachin.domain.Listing;
import ro.kenjiru.yachin.persistence.ListingDao;

@Service
public class ListingServiceImpl implements ListingService {
	@Autowired
	private ListingDao listingDao;
	
	@Override
	public void createListing(Listing listing) {
		listingDao.addListing(listing);
	}
}
