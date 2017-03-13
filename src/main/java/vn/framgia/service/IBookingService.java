package vn.framgia.service;

import java.io.Serializable;
import java.util.List;

import vn.framgia.bean.ShowBookingBean;

public interface IBookingService extends Serializable{
	public List<List<ShowBookingBean>> findAllBookingOrderByDesc();
	public List<List<ShowBookingBean>> searchBookingByNameClient(String nameClient);
}
