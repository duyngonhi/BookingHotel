package vn.framgia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import vn.framgia.model.UserService;

public class UserServiceDAOImpl extends GenericDAO<UserService, Long> implements IUserServiceDAO{

	@Override
	public List<UserService> findServiceByBookingId(String bookingId) {
		Criteria criteria = getSession().createCriteria(UserService.class);
		criteria.add(Restrictions.eq("bookingId.id", Integer.valueOf(bookingId)));
		return criteria.list();
	}

}
