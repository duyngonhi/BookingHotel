package vn.framgia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import vn.framgia.bean.PaymentBean;
import vn.framgia.bean.PaymentDetail;
import vn.framgia.model.Bill;
import vn.framgia.model.Booking;
import vn.framgia.model.UsedItem;
import vn.framgia.service.IPaymentService;
import vn.framgia.util.Helpers;

public class PaymentServiceImpl extends BaseserviceImpl implements IPaymentService{

	private static final Logger logger = Logger.getLogger(Booking.class);
	
	public int getTotalPriceService(Integer bookingId){
		int totalPrice = 0;
		try{
			List<UsedItem> lstUserService = userServiceDAO.findServiceByBookingId(bookingId);
			if(Helpers.isEmpty(lstUserService)){
				return totalPrice;
			}
			for(UsedItem userService : lstUserService){
				totalPrice += userService.getItem().getPrice();
			}
		}catch(Exception e){
			logger.error("ERROR GET TOTAL PRICE: ",e);
		}
		return totalPrice;
	}

	@Override
	public PaymentBean getinfoPayment(Integer bookingId) {
		PaymentBean paymentBean = new PaymentBean();
		try{
			Booking booking = bookingDAO.findById(bookingId);
			if(booking == null){
				return paymentBean;
			}
			paymentBean.setBookingId(bookingId);
			paymentBean.setNameClient(booking.getClient().getFullName());
			int total = (int)(booking.getTotalPrice() + getTotalPriceService(bookingId));
			int refunded = getTotalPaymentAmountByBooking(bookingId);
			paymentBean.setRefunded(refunded);
			paymentBean.setRemain(total - refunded);
			paymentBean.setRoom(booking.getRoom().getName());
			paymentBean.setTotal(total);
			paymentBean.setPaymentDetails(getpaymentDetail(bookingId, booking.getTotalPrice()));
		}catch(Exception e){
			logger.error("ERROR GET INFO PAYMENT: ", e);
		}
		return paymentBean;
	}

	@Override
	public boolean savePayment() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<PaymentDetail> getpaymentDetail(Integer bookingId, Float priceRoom) {
		List<PaymentDetail> lstPaymentDetail = new ArrayList<PaymentDetail>();
		try {
			List<UsedItem> lstUserItems = userServiceDAO.findServiceByBookingId(bookingId);
			if (Helpers.isEmpty(lstUserItems)) {
				return lstPaymentDetail;
			}
			lstPaymentDetail.add(new PaymentDetail("Room", (int)(float)priceRoom));
			for (UsedItem userItem : lstUserItems) {
				lstPaymentDetail.add(new PaymentDetail(userItem.getItem()
						.getName(), (int) (float) userItem.getItem().getPrice()));
			}
		} catch (Exception e) {
			logger.error("ERROR GET PAYMENT DETAIL: ", e);
		}
		return lstPaymentDetail;
	}
	
	public int getTotalPaymentAmountByBooking(Integer bookingId){
		int result = 0;
		try{
			List<Bill> lstbill = billDAO.findBillByBooKing(String.valueOf(bookingId));
			if(Helpers.isEmpty(lstbill)){
				return result;
			}
			for(Bill bill : lstbill){
				result += bill.getPaymentAmount();
			}
		}catch(Exception e){
			logger.error("ERROR GET PAYMENT AMOUNT: ", e);
		}
		return result;
	}
}
