package vn.framgia.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IUserServiceDAO;
import vn.framgia.model.UsedItem;

public class UserServiceDAOImpl extends GenericDAO<UsedItem, Integer> implements IUserServiceDAO {

	@Override
	public List<UsedItem> findServiceByBookingId(int bookingId) {
		Criteria criteria = getSession().createCriteria(UsedItem.class);
		criteria.add(Restrictions.eq("booking.id", bookingId));
		return criteria.list();
	}

}
