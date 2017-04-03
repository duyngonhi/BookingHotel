package vn.framgia.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import vn.framgia.bean.ActivityBean;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IActivityDAO;
import vn.framgia.model.Activity;

public class ActivityDAOImpl extends GenericDAO<Activity, Integer> implements IActivityDAO {

	@Override
	public List<Activity> finfAllActivityOrder(Integer pageNumber) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Activity.class);
		criteria.addOrder(Order.desc("id"));
		criteria.setFirstResult((pageNumber -1) * ActivityBean.PAGE_SIZE);
		criteria.setMaxResults(ActivityBean.PAGE_SIZE);
		return criteria.list();
	}

}
