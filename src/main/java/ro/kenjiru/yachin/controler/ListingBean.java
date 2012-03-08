package ro.kenjiru.yachin.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ro.kenjiru.yachin.domain.Listing;
import ro.kenjiru.yachin.service.ListingService;

@Component
@Scope("session")
public class ListingBean {
	@Autowired
	private ListingService listingService;
	private Listing listing;

	public ListingService getListingService() {
		return listingService;
	}

	public void setListingService(ListingService listingService) {
		this.listingService = listingService;
	}
	
	public void addListing() {
		listingService.createListing(listing);
	}
}