package vn.framgia.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IUserDAO;
import vn.framgia.model.User;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserDAOImpl extends GenericDAO<User, Integer> implements IUserDAO {
    public UserDAOImpl() {
        super.setPersistentClass(User.class);
    }

	@Override
	public User getUserByAcount(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User obj = (User)criteria.uniqueResult();
		if (obj == null) {
			return null;
		}
		return obj;
	}

	@Override
	public User getUserById(int id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		User obj = (User)criteria.uniqueResult();
		if (obj == null) {
			return null;
		}
		return obj;
	}
	
}
