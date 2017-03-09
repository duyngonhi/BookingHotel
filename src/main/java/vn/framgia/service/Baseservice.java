package vn.framgia.service;

import vn.framgia.dao.IBookingDAO;
import vn.framgia.dao.IUserDAO;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class Baseservice {

    protected IUserDAO userDAO;
    protected IBookingDAO bookingDAO;

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

}
