package vn.framgia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import vn.framgia.bean.ShowBookingBean;
import vn.framgia.model.Bill;
import vn.framgia.model.Booking;
import vn.framgia.model.UserService;
import vn.framgia.util.Helpers;

public class BookingServiceImpl extends Baseservice implements IBookingService {
	private static final Logger logger = Logger.getLogger(Booking.class);

	public List<List<ShowBookingBean>> showBooking(List<Booking> lstBoonkings) {
		try {
			List<List<ShowBookingBean>> results = new ArrayList<List<ShowBookingBean>>();
			if (!Helpers.isEmpty(lstBoonkings)) {
				List<ShowBookingBean> listObj = null;
				ShowBookingBean bookingBean = null;
				int buffer = 0;
				for (Booking book : lstBoonkings) {
					if(buffer != book.getClientId().getId() && buffer != 0) {
						results.add(listObj);
					}
					if(buffer != book.getClientId().getId()){
						listObj = new ArrayList<ShowBookingBean>();
					}
					bookingBean = new ShowBookingBean();
					bookingBean.setBookingId(book.getId());
					bookingBean.setNameClient(book.getClientId().getFullName());
					bookingBean.setNameRoom(book.getRoomId().getName());
					bookingBean.setCheckIn(Helpers.convertDatetoString(book.getCheckIn()));
					bookingBean.setCheckOut(Helpers.convertDatetoString(book.getCheckOut()));
					bookingBean.setPriceRoom(book.getTotalPrice());
					bookingBean.setStatus(checkStatusBooking(book));
					
					listObj.add(bookingBean);
					buffer = book.getClientId().getId();
				}
				results.add(listObj);
				return results;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List<List<ShowBookingBean>> findAllBookingOrderByDesc() {
		try{
			List<Booking> listBooking = bookingDAO.findAllOrderClientId();
			if(!Helpers.isEmpty(listBooking)){
				return showBooking(listBooking);
			}
		}catch(Exception e){
			logger.error(e);
		}
		return null;
	}
	
	@Override
	public List<List<ShowBookingBean>> searchBookingByNameClient(String nameClient) {
		try {
			List<Booking> listBooking = bookingDAO.findBillByNameClient(nameClient);
			if (!Helpers.isEmpty(listBooking)) {
				return showBooking(listBooking);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	public String checkStatusBooking(Booking booking){
		try{
			List<Bill> lstBill = billDAO.findBillByBooKing(String.valueOf(booking.getId()));
			if(!Helpers.isEmpty(lstBill)){
				float payment = 0f;
				for (Bill bill : lstBill) {
					payment += bill.getPaymentAmount();
				}
				float totalServiceFollow = getTotalPriceServiceByBookingId(String.valueOf(booking.getId())); 
				if((booking.getTotalPrice() + totalServiceFollow) <= payment){
					return Helpers.STATUS_OK;
				}
				if(payment < (booking.getTotalPrice() + totalServiceFollow) && payment != 0f){
					return Helpers.STATUS_NOT;
				}
			}
		}catch(Exception e){
			logger.error(e);
		}
		return Helpers.STATUS_NO;
	}
	
	public float getTotalPriceServiceByBookingId(String bookingId){
		try{
			List<UserService> lstUserService = userServiceDAO.findServiceByBookingId(bookingId);
			if(!Helpers.isEmpty(lstUserService)){
				float totalPrice = 0f;
				for(UserService userService : lstUserService){
					totalPrice += userService.getServiceId().getPrice();
				}
				return totalPrice;
			}
		}catch(Exception e){
			logger.error(e);
		}
		return 0f;
	}
	
}
