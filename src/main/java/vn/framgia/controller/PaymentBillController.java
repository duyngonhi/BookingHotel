package vn.framgia.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.BillBeanClient;
import vn.framgia.service.IPaymentBillService;

@Controller
public class PaymentBillController {
	private static final Logger logger = Logger.getLogger(PaymentBillController.class);
	@Autowired
	private IPaymentBillService payBillService;
	
	@RequestMapping(value="/detailbill")
	public ModelAndView redirectDetailBill(){
		int booking = 1;
		BillBeanClient beanClient = payBillService.getBeanClient(booking);
		if(beanClient != null){
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("beanClient", beanClient);
			return new ModelAndView("detailbill", model);
		}
		return new ModelAndView("detailbill");
	}
	
	@RequestMapping(value="/forward_payment")
	public ModelAndView redirectPayment(){
		return new ModelAndView("payment");
	}
}
