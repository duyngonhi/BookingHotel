package vn.framgia.dao;

import java.util.List;

import vn.framgia.model.Booking;

public interface IBookingDAO extends IGenericDAO<Booking, Long>{
	public List<Booking> findAllOrderClientId();
}
