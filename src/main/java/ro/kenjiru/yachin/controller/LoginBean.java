package ro.kenjiru.yachin.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class LoginBean {
	private String username;
	private String password;
	
	/*@Autowired
	private UserService userService;*/
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//TODO: implement login method with custom authentication service
	/*public String login() {
		boolean loggedIn = userService.login(username, password);
		if(loggedIn) {
			return "addListing.xhtml";
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or password incorrect"));
			return "login.xhtml";
		}
	}*/
}
