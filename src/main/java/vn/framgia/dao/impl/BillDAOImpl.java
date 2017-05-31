package vn.framgia.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IBillDAO;
import vn.framgia.model.Bill;

public class BillDAOImpl extends GenericDAO<Bill, Integer> implements IBillDAO {

	@Override
	public List<Bill> findBillByBooKing(String bookingId) {
		Criteria criterion = getSession().createCriteria(Bill.class);
		criterion.add(Restrictions.eq("booking.id", Integer.valueOf(bookingId)));
		return criterion.list();
	}

	@Override
	public List<Bill> findBillLatestBybookingId(Integer bookingId) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Bill.class);
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	@Override
	public Bill findBillById(Integer id) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Bill.class);
		criteria.add(Restrictions.eq("id", id));
		return (Bill)criteria.uniqueResult();
	}

}
