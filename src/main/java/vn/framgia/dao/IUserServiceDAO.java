package vn.framgia.dao;

import java.util.List;

import vn.framgia.model.UsedItem;

public interface IUserServiceDAO extends IGenericDAO<UsedItem, Integer>{
	public List<UsedItem> findServiceByBookingId(int bookingId);
}
