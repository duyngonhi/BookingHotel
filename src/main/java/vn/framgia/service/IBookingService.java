package vn.framgia.service;

import java.io.Serializable;
import java.util.List;

import vn.framgia.bean.ShowBookingBean;

public interface IBookingService extends Serializable{
	public List<List<ShowBookingBean>> showBooking();
	public List<List<ShowBookingBean>> searchBillByNameClient(String nameClient);
}
