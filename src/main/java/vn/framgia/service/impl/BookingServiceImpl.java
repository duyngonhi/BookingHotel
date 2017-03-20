package vn.framgia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import vn.framgia.bean.ShowBookingBean;
import vn.framgia.model.Bill;
import vn.framgia.model.Booking;
import vn.framgia.model.UsedItem;
import vn.framgia.service.IBookingService;
import vn.framgia.util.Helpers;

public class BookingServiceImpl extends BaseserviceImpl implements IBookingService {
	private static final Logger logger = Logger.getLogger(Booking.class);

	public List<List<ShowBookingBean>> showBooking(List<Booking> listBooking) {
		try {
			List<List<ShowBookingBean>> results = new ArrayList<List<ShowBookingBean>>();
			if (!Helpers.isEmpty(listBooking)) {
				List<ShowBookingBean> listObj = null;
				ShowBookingBean bookingBean = null;
				int buffer = 0;
				for (Booking book : listBooking) {
					if(buffer != book.getClient().getId() && buffer != 0) {
						results.add(listObj);
					}
					if(buffer != book.getClient().getId()){
						listObj = new ArrayList<ShowBookingBean>();
					}
					bookingBean = new ShowBookingBean();
					bookingBean.setBookingId(book.getId());
					bookingBean.setNameClient(book.getClient().getFullName());
					bookingBean.setNameRoom(book.getRoom().getName());
					bookingBean.setCheckIn(Helpers.convertDatetoString(book.getCheckIn()));
					bookingBean.setCheckOut(Helpers.convertDatetoString(book.getCheckOut()));
					bookingBean.setPriceRoom((int)(book.getTotalPrice() + getTotalPriceService(book.getId())));
					bookingBean.setStatus(checkStatusBooking(book));
					
					listObj.add(bookingBean);
					buffer = book.getClient().getId();
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
				float totalServiceFollow = getTotalPriceService(booking.getId()); 
				if((booking.getTotalPrice() + totalServiceFollow) <= payment){
					return ShowBookingBean.STATUS_OK;
				}
				if(payment < (booking.getTotalPrice() + totalServiceFollow) && payment != 0f){
					return ShowBookingBean.STATUS_NOT;
				}
			}
		}catch(Exception e){
			logger.error(e);
		}
		return ShowBookingBean.STATUS_NO;
	}
	
	public int getTotalPriceService(int bookingId){
		try{
			List<UsedItem> lstUserService = userServiceDAO.findServiceByBookingId(bookingId);
			if(!Helpers.isEmpty(lstUserService)){
				int totalPrice = 0;
				for(UsedItem userService : lstUserService){
					totalPrice += userService.getItem().getPrice();
				}
				return totalPrice;
			}
		}catch(Exception e){
			logger.error(e);
		}
		return 0;
	}
}
