package vn.framgia.dao;

import java.util.List;

import vn.framgia.model.Booking;

public interface IBookingDAO extends IGenericDAO<Booking, Integer>{
	public List<Booking> findAllOrderClientId();
	public List<Booking> findBillByNameClient(String nameClient);
}
