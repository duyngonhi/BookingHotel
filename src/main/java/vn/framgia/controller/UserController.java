package vn.framgia.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.UserBean;
import vn.framgia.security.CustomUserDetail;
import vn.framgia.service.IUserService;
import vn.framgia.util.Helpers;
import vn.framgia.util.InputCondition;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
	private IUserService userService;

	@RequestMapping(value = "admin_newUser", method = RequestMethod.GET)
	public String createUser(Model model, @ModelAttribute(value = "userForm") UserBean userForm) {
		UserBean user = new UserBean();
		model.addAttribute("userForm", user);
		return "newUser";
	}
	@RequestMapping(value = "/admin_newUser", method = RequestMethod.POST)
	public ModelAndView createUser(Model model, @ModelAttribute(value = "userForm") UserBean userForm,
			BindingResult result, HttpServletRequest request) {
		boolean check = true;
		String phone = userForm.getPhone();
		String email = userForm.getEmail();
		String role = request.getParameter("role").toUpperCase();
		if (Helpers.isEmpty(userForm.getFullname())) {
			result.reject("fullname", "Please enter Full Name!");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getUsername())) {
			result.reject("username", "Please enter Username!");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getPassword())) {
			result.reject("password", "Please enter Password!");
			check = false;
		}
		if (Helpers.isEmpty(email)) {
			result.reject("email", "Please enter your Email!");
			check = false;
		} else {
			if (!InputCondition.isEmailValid(email)) {
				result.reject("email", "Format email invalid!");
				check = false;
			}
		}
		if (Helpers.isEmpty(phone)) {
			result.reject("phone", "Please enter your phone!");
			check = false;
		} else {
			if (!InputCondition.isPhoneNumberValid(phone)) {
				result.reject("phone", "Phone number input invalid!");
				check = false;
			}
		}
		if (!check) {
			return new ModelAndView("newUser");
		}
		userForm.setRole(role);
		userService.createUser(userForm);
		logger.info("add userr success............");
		return new ModelAndView("redirect:admin_listUser");
	}
	
	@RequestMapping(value = "/admin_listUser", method = RequestMethod.GET)
	public ModelAndView showListUsers() {
		ModelAndView model = new ModelAndView("listUser");
		List<UserBean> listUser = userService.findAll();
		if (listUser == null)
			model.addObject("listUsersIsEmpty", "List users is empty");
		else
			model.addObject("listUser", listUser);
		return model;
	}
    
	@RequestMapping("/admin_deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		boolean check = true;
		check = userService.deleteUser(id);
		ModelAndView model = new ModelAndView();
		if (!check) {
			model.setViewName("listUser");
			model.addObject("errDeleteUser", "delete user has error");
			return model;
		}
		return new ModelAndView("redirect:admin_listUser");

	}
	@RequestMapping("/admin_editUser")
    public ModelAndView editUser(@RequestParam int id){
    	UserBean userBean = userService.getUserById(id);
    	ModelAndView model = new ModelAndView();
    	if(userBean == null){
    		model.addObject("errEditUser", "edit user has error");
    		model.setViewName("editUser");
    		return model;
    	}
    	return new ModelAndView("editUser","userForm", userBean);
    }
	
	@RequestMapping("/admin_updateUser")
    public ModelAndView updateUser(@ModelAttribute(value = "userForm") UserBean userBean, HttpServletRequest request){
    	boolean check = true;
    	String role = request.getParameter("role").toUpperCase();
    	userBean.setRole(role);
    	check = userService.updateUser(userBean);
    	ModelAndView model = new ModelAndView();
    	if(!check){
    		model.setViewName("editUser");
    		model.addObject("errUpdateUser", "Update user has error");
    		return model;
    	}
    	return new ModelAndView("redirect:admin_listUser");
    }
	
	@RequestMapping(value = "/showProfile", method = RequestMethod.GET)
	public ModelAndView showpProfile() {
		if(Helpers.getIdUser() == 0){
			return new ModelAndView("login");
		}
		UserBean userBean = userService.getIdProfile(Helpers.getIdUser());
		ModelAndView modelAndView = new ModelAndView("showProfile");
		if (userBean == null)
			modelAndView.addObject("errShowProfile", "show profile has error");
		else 
			modelAndView.addObject("userBean", userBean);
		return modelAndView;
	}
	
	@RequestMapping(value = "/editProfile")
    public ModelAndView editProfile(@RequestParam int id){
    	UserBean userBean = userService.getIdProfile(id);
    	ModelAndView model = new ModelAndView();
    	if(userBean == null){
    		model.addObject("errEditProfile", "edit proflie has error");
    		model.setViewName("editProfile");
    		return model;
    	}
    	return new ModelAndView("editProfile","profileForm", userBean);
    }
	
	@RequestMapping(value = "/updateProfile")
	public ModelAndView updateProfile(@ModelAttribute(value = "profileForm") UserBean userBean, HttpServletRequest request){
    	ModelAndView model = new ModelAndView();
    	if(!(userService.updateProfile(userBean))){
    		model.setViewName("editProfile");
    		model.addObject("errUpdateProfile", "Update profile has error");
    		return model;
    	}
    	return new ModelAndView("redirect:showProfile");
    }
}
