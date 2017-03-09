package vn.framgia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.ShowBookingBean;
import vn.framgia.service.IBookingService;

@Controller
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private IBookingService bookingService; 
	
	@RequestMapping("/showbooking")
	public ModelAndView show(){
		Map<String, Object> model = new HashMap<String, Object>();
		List<List<ShowBookingBean>> lstBookingBean = bookingService.showBooking();
		model.put("listbooks", lstBookingBean);
		return new ModelAndView("showbooking", model);
	}
}
