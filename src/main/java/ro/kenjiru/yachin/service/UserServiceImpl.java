package ro.kenjiru.yachin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.kenjiru.yachin.domain.User;
import ro.kenjiru.yachin.persistence.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired private UserDao dao;

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getByUsername(String username) {
		return dao.getByUsername(username);
	}

}
