package vn.framgia.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.PaymentBean;
import vn.framgia.security.CustomUserDetail;
import vn.framgia.service.IPaymentService;

@Controller
public class PaymentBillController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private IPaymentService paymentService;
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public ModelAndView redirectPaymentPags(@RequestParam("id") Integer bookingId){
		logger.info("------show list booking by client");
		Map<String, Object> model = new HashMap<String, Object>();
		PaymentBean paymentBeans = paymentService.getinfoPayment(bookingId);
		model.put("paymentBean", paymentBeans);
		return new ModelAndView("payment", model);
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ModelAndView paymentBill(
			@RequestParam("payrefuned") String payrefuned,
			@RequestParam("bookingId") String bookingId) {
		logger.info("------submit payment");
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("id: "+ bookingId);
		System.out.println("refunded: "+ payrefuned);
		CustomUserDetail userDetail = (CustomUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetail.getUserId());
		
		return new ModelAndView("payment", model);
	}
}
