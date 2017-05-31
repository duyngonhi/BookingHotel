package vn.framgia.service.impl;

import vn.framgia.dao.IActivityDAO;
import vn.framgia.dao.IBillDAO;
import vn.framgia.dao.IBookingDAO;
import vn.framgia.dao.IHotelDAO;
import vn.framgia.dao.IRoomDAO;
import vn.framgia.dao.IUserDAO;
import vn.framgia.dao.IItemDAO;
import vn.framgia.dao.IUserServiceDAO;
import vn.framgia.dao.IClientDAO;
import java.io.Serializable;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class BaseserviceImpl implements Serializable {

    protected IUserDAO userDAO;
    protected IRoomDAO roomDAO;
    protected IHotelDAO hotelDAO;
    protected IBookingDAO bookingDAO;
    protected IItemDAO itemDAO;
    protected IBillDAO billDAO;
    protected IUserServiceDAO userServiceDAO;
    protected IClientDAO clientDAO;
    protected IActivityDAO activityDAO;

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public IRoomDAO getRoomDAO() {
        return roomDAO;
    }

    public void setRoomDAO(IRoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public IHotelDAO getHotelDAO() {
        return hotelDAO;
    }

    public void setHotelDAO(IHotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

	public IBookingDAO getBookingDAO() {
		return bookingDAO;
	}

	public void setBookingDAO(IBookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}

    public IItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(IItemDAO itemDAO) {
        this.itemDAO = itemDAO;
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

	public IActivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(IActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}
    
    public IClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
}
