package ro.kenjiru.yachin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ro.kenjiru.yachin.domain.Listing;
import ro.kenjiru.yachin.service.ListingService;

@Component
@Scope("request")
public class ListingBean {
	@Autowired
	private ListingService listingService;
	@Autowired
	private Listing listing;

	public ListingService getListingService() {
		return listingService;
	}

	public void setListingService(ListingService listingService) {
		this.listingService = listingService;
	}
	
	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
	public String addListing() {
		listingService.createListing(listing);
		
		return null;
	}
	
	public List<Listing> getAllListings() {
		return listingService.getAll();
	}
}
