package vn.framgia.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import vn.framgia.bean.BookingBean;
import vn.framgia.bean.ClientBean;
import vn.framgia.bean.ItemBean;
import vn.framgia.bean.RoomBean;
import vn.framgia.bean.ShowBookingBean;
import vn.framgia.bean.Statistical;
import vn.framgia.model.Bill;
import vn.framgia.model.Booking;
import vn.framgia.model.Item;
import vn.framgia.model.Room;
import vn.framgia.model.UsedItem;
import vn.framgia.service.IBookingService;
import vn.framgia.util.Helpers;
/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */
public class BookingServiceImpl extends BaseserviceImpl implements IBookingService {
	private static final Logger logger = Logger.getLogger(BookingServiceImpl.class);

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
					bookingBean.setPriceRoom((int)(float)book.getTotalPrice());
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
			List<Booking> listBooking = null;
			if (nameClient.isEmpty()) {
				listBooking = bookingDAO.findAllOrderClientId();
			} else {
				listBooking = bookingDAO.findBillByNameClient(nameClient);
			}
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
				//float totalServiceFollow = getTotalPriceService(booking.getId()); 
				if(booking.getTotalPrice() <= payment){
					return ShowBookingBean.STATUS_OK;
				}
				if(payment < booking.getTotalPrice() && payment != 0f){
					return ShowBookingBean.STATUS_NOT;
				}
			}
		}catch(Exception e){
			logger.error(e);
		}
		return ShowBookingBean.STATUS_NO;
	}
	
	public int getTotalPriceService(int bookingId) {
		try {
			List<UsedItem> lstUserService = userServiceDAO.findServiceByBookingId(bookingId);
			if (!Helpers.isEmpty(lstUserService)) {
				int totalPrice = 0;
				for (UsedItem userService : lstUserService) {
					totalPrice += userService.getItem().getPrice();
				}
				return totalPrice;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public Float calculateTotalPrice(Long days, Float priceOfRoom, List items) {
		Float totalPriceOfRoom = days*priceOfRoom;
		if(items.size() < 0) {
			return totalPriceOfRoom;
		}
		Float totalPriceOfItem = 0f;
		for(int i =0; i<items.size(); ++i) {
			ItemBean itemBean = itemDAO.getItemBeanById(Integer.parseInt(items.get(i).toString()));
			totalPriceOfItem += itemBean.getPrice();
		}
		return (totalPriceOfRoom+totalPriceOfRoom);
	}

	@Override
	public boolean addBooking(BookingBean bookingBean, ClientBean clientBean, RoomBean roomBean) {
		try {
			Booking booking = new Booking();
			Date checkin = Helpers.convertStringtoDate(roomBean.getStart());
			Date checkout  = Helpers.convertStringtoDate(roomBean.getEnd());
			long days = Helpers.getDayBetweenTwoDates(checkin, checkout);
			List listItems = bookingBean.getItems();
			Float price = roomBean.getPrice();
			booking.setCheckIn(checkin);
			booking.setCheckOut(checkout);
			booking.setTotalPrice(calculateTotalPrice(days, price, listItems));
			booking.setNote("");
			booking.setClient(clientDAO.findById(clientBean.getId()));
			booking.setRoom(roomDAO.findById(roomBean.getId()));
			booking.setIsCheckIn(bookingBean.getIsCheckin());
			for(int i =0; i<bookingBean.getItems().size(); ++i) {
				Item item = itemDAO.getItemById(Integer.parseInt(bookingBean.getItems().get(i).toString()));
				booking.addItem(item);
			}
			bookingDAO.save(booking);
			return true;
		} catch (Exception e) {
			logger.info("Exception at function addBooking in class BookingServiceImpl : ", e);
		}
		return false;
	}

	@Override
	public List<RoomBean> listRooms(Integer offset, Integer maxResults) {
		try {
			List<Room> listRooms = roomDAO.list(offset, maxResults);
			if(!Helpers.isEmpty(listRooms)) {
				List<RoomBean> listRoomsBean = new ArrayList<RoomBean>();
				for(Room room : listRooms) {
					RoomBean roomBean = new RoomBean();
					BeanUtils.copyProperties(room, roomBean);
					listRoomsBean.add(roomBean);
				}
				return listRoomsBean;
			}
		} catch (Exception e) {
			logger.error("Exception at function list in BookingServiceImpl : ", e);
		}
		return null;
	}

	@Override
	public Integer countRoom() {
		return roomDAO.count();
	}

	public List<Statistical> statisticRevenue(Date startDate, Date endDate) {
		try {
			return bookingDAO.statisticRevenue(startDate, endDate);
		} catch (Exception e) {
			logger.info("Exception at function statisticRevenue in class BookingServiceImpl : ", e);
		}
		return null;
	}
}
