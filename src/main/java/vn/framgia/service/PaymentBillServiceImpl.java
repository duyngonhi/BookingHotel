package vn.framgia.service;

import org.apache.log4j.Logger;

import vn.framgia.bean.BillBeanClient;
import vn.framgia.controller.PaymentBillController;
import vn.framgia.model.Booking;

public class PaymentBillServiceImpl extends Baseservice implements IPaymentBillService {
	private static final Logger logger = Logger.getLogger(PaymentBillController.class);

	@Override
	public BillBeanClient getBeanClient(int bookingId) {
		BillBeanClient beanClient = new BillBeanClient();
		try {
			Booking booking = bookingDAO.getbookingById(bookingId);
			if (booking == null) {
				return null;
			}
			beanClient.setAddress(booking.getClientId().getAddress());
			beanClient.setCustomer(booking.getClientId().getFullName());
			beanClient.setDay("");
			beanClient.setMonth("");
			beanClient.setYear("");
			beanClient.setPhone("");
			beanClient.setDetailBean(null);
			beanClient.setTotal(20000000);
			beanClient.setCreateBy("AAAAAAAA");

		} catch (Exception e) {
			logger.error("ERROR GET BRANCLIENT: ", e);
			return null;
		}
		return beanClient;
	}

}
