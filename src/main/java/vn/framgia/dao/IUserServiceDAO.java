package vn.framgia.dao;

import java.util.List;

import vn.framgia.model.UserService;

public interface IUserServiceDAO extends IGenericDAO<UserService, Long>{
	public List<UserService> findServiceByBookingId(String bookingId);
}
