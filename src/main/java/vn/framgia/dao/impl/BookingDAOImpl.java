package vn.framgia.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;

import org.hibernate.transform.AliasToBeanResultTransformer;
import vn.framgia.bean.Statistical;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IBookingDAO;
import vn.framgia.model.Booking;

public class BookingDAOImpl extends GenericDAO<Booking, Integer> implements IBookingDAO{
	public BookingDAOImpl(){
		super.setPersistentClass(Booking.class);
	}
	private static final Logger logger = Logger.getLogger(BookingDAOImpl.class);
	@Override
	public List<Booking> findAllOrderClientId() {
		Criteria criteria = getSession().createCriteria(Booking.class);
		criteria.addOrder(Order.desc("client.id"));
		return criteria.list();
	}
	
	@Override
	public List<Booking> findBillByNameClient(String stringSearch) {
		Criteria criteria = getSession().createCriteria(Booking.class);
		criteria.createAlias("client", "client");
		Criterion criterionName = Restrictions.like("client.fullName", "%"+stringSearch+"%");
		Criterion criterionCMT = Restrictions.eq("client.cardNumber", stringSearch);
		Criterion criterionPhone = Restrictions.eq("client.phone", stringSearch);
		Criterion criterionAddress = Restrictions.like("client.address", "%"+stringSearch+"%");
		
		criteria.add(Restrictions.or(
				Restrictions.or(criterionCMT, criterionPhone),
				Restrictions.or(criterionName, criterionAddress)));

		return criteria.list();
	}

	@Override
	public List<Statistical> statisticRevenue(Date startDate, Date endDate) {
		try {
			Criteria criteria = getSession().createCriteria(Booking.class, "book");
			criteria.createAlias("book.room","room");
			criteria.add(Restrictions.and(
				Restrictions.between("checkIn", startDate, endDate),
				Restrictions.between("checkOut", startDate, endDate)
			));
			criteria.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("room.id"), "id")
					.add(Projections.groupProperty("room.name"), "name")
					.add(Projections.sum("totalPrice"), "totalPrice"));
			criteria.setResultTransformer(new AliasToBeanResultTransformer(Statistical.class));

			List<Statistical> staticticalRevenueList = (List<Statistical>)criteria.list();
			return staticticalRevenueList;
		} catch (Exception e) {
			logger.error("Exception at function statisticRevenue in BookingDAOImpl :", e);
		}
		return  null;
	}
}
