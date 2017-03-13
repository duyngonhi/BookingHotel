package vn.framgia.dao;

import java.util.List;

import vn.framgia.model.Bill;

public interface IBillDAO extends IGenericDAO<Bill, Long>{
	public List<Bill> findBillByBooKing(String bookingId);
}
