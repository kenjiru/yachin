package ro.kenjiru.yachin.service;

import ro.kenjiru.yachin.domain.User;

public interface UserService {

	public boolean login(String username, String password);
	
	public User getByUsername(String username);
}
