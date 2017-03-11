package vn.framgia.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.AuthentUserBean;
import vn.framgia.service.IUserService;

@Controller
public class LoginController implements UserDetailsService{
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/login")
	public ModelAndView redirectLogin() {
		return new ModelAndView("login");
	}
	
	@Override
	public UserDetails loadUserByUsername(String acount)throws UsernameNotFoundException {
		AuthentUserBean beanAuthent = userService.getUserByAcount(acount);
		if(beanAuthent != null) {
			String username = beanAuthent.getUsername();
			String password = beanAuthent.getPassword();
			logger.info("username: "+username +" , password: "+ password);
			System.out.println("username: " + username + " , password: " + password + " , " + beanAuthent.getRole());
			return new User(username, password, beanAuthent.getRole());
		}
		return null;
	}
}
