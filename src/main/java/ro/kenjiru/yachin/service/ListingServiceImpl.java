package ro.kenjiru.yachin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.kenjiru.yachin.domain.Listing;
import ro.kenjiru.yachin.persistence.ListingDao;

@Service
public class ListingServiceImpl implements ListingService {
	@Autowired(required=true)
	private ListingDao listingDao;
	
	@Override
	@Transactional(readOnly=false)
	public void createListing(Listing listing) {
		listingDao.addListing(listing);
	}

	@Override
	@Transactional
	public List<Listing> getAll() {
		return listingDao.getAll();
	}
}
