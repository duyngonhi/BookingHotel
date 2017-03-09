package vn.framgia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import vn.framgia.model.Booking;

public class BookingDAOImpl extends GenericDAO<Booking, Long> implements IBookingDAO{
	public BookingDAOImpl(){
		super.setPersistentClass(Booking.class);
	}

	@Override
	public List<Booking> findAllOrderClientId() {
		Criteria criteria = getSession().createCriteria(Booking.class);
		criteria.addOrder(Order.desc("clientId.id"));
		return criteria.list();
	}
	
}
