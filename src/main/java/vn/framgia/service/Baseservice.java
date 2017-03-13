package vn.framgia.service;

import vn.framgia.dao.IBillDAO;
import vn.framgia.dao.IBookingDAO;
import vn.framgia.dao.IUserDAO;
import vn.framgia.dao.IUserServiceDAO;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class Baseservice {

	protected IUserDAO userDAO;
	protected IBookingDAO bookingDAO;
	protected IBillDAO billDAO;
	protected IUserServiceDAO userServiceDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IBookingDAO getBookingDAO() {
		return bookingDAO;
	}

	public void setBookingDAO(IBookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}

	public IBillDAO getBillDAO() {
		return billDAO;
	}

	public void setBillDAO(IBillDAO billDAO) {
		this.billDAO = billDAO;
	}

	public IUserServiceDAO getUserServiceDAO() {
		return userServiceDAO;
	}

	public void setUserServiceDAO(IUserServiceDAO userServiceDAO) {
		this.userServiceDAO = userServiceDAO;
	}
	
}
