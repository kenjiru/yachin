package ro.kenjiru.yachin.persistence;

import ro.kenjiru.yachin.domain.User;

public interface UserDao {

	public User getByUsername(String username);
	
	public User getById(long id);
}
