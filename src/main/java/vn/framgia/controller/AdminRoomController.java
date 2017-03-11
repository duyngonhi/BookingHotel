package vn.framgia.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminRoomController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value="/admin_room")
	public ModelAndView redirectAdminRoom(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			System.out.println("Acount: "+request.getUserPrincipal().getName());
		}
		return new ModelAndView("admin_room");
	}
}
