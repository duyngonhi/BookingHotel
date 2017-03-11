package vn.framgia.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import vn.framgia.model.User;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserDAOImpl extends GenericDAO<User, Long> implements IUserDAO{
    public UserDAOImpl() {
        super.setPersistentClass(User.class);
    }
    
    @Override
	public User getUserByUserPass(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User obj = (User)criteria.uniqueResult();
		if (obj == null) {
			return null;
		}
		return obj;
	}
}
