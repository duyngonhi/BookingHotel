package vn.framgia.dao;

import java.util.List;

import vn.framgia.model.Bill;

public interface IBillDAO extends IGenericDAO<Bill, Integer> {
	public List<Bill> findBillByBooKing(String bookingId);
	public List<Bill> findBillLatestBybookingId(Integer bookingId);
	public Bill findBillById(Integer id);
}
