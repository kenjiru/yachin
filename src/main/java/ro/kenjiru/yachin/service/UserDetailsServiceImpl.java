package ro.kenjiru.yachin.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ro.kenjiru.yachin.domain.Role;
import ro.kenjiru.yachin.domain.User;
import ro.kenjiru.yachin.persistence.UserDao;
/**
 * A custom service for retrieving users from a custom datasource, such as a database.
* This custom service must implement Spring's {@link UserDetailsService}
 */
@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired private UserDao dao;
	
	/*
	 * whatever UserDetailsService returns can always be obtained from the SecurityContextHolder
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails userDetails = null;
		
		User userEntity = dao.getByUsername(username);
		
		if(userEntity == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		// Populate the Spring User object with details from the dbUser
		   // Here we just pass the username, password, and access level
		   // getAuthorities() will translate the access level to the correct role type
		userDetails = new org.springframework.security.core.userdetails.User(userEntity.getUsername(), 
				userEntity.getPassword(), userEntity.isEnabled(), userEntity.isEnabled(), 
				userEntity.isEnabled(), userEntity.isEnabled(), authorities);
		return userDetails;
	}

	// Login code instead of j_security_check 
/*
	@Resource(name="authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Override
	public boolean login(String username, String password) {
		try {
			Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			if(auth.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(auth);
				return true;
			}
		} catch(AuthenticationException ex) {
			//throw a service exception
		}
		return false;
	}
*/
	
}
