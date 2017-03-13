package vn.framgia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import vn.framgia.model.Bill;

public class BillDAOImpl extends GenericDAO<Bill, Long> implements IBillDAO{

	@Override
	public List<Bill> findBillByBooKing(String bookingId) {
		Criteria criterion = getSession().createCriteria(Bill.class);
		criterion.add(Restrictions.eq("bookingId.id", Integer.valueOf(bookingId)));
		return criterion.list();
	}

}
