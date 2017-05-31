package vn.framgia.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.framgia.service.IUserService;

public class CustomUserDetailService implements UserDetailsService {
	private static final Logger logger = Logger.getLogger(CustomUserDetailService.class);
	@Autowired
    public IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String acount)throws UsernameNotFoundException {
		CustomUserDetail beanAuthent = userService.getUserByAcount(acount);
		if(beanAuthent != null) {
			String username = beanAuthent.getUsername();
			String password = beanAuthent.getPassword();
			logger.info("username: "+username +" , password: "+ password);
			return new CustomUserDetail(beanAuthent.getUserId(), username, password, beanAuthent.getAuthorities());
		}
		return null;
	}

}
