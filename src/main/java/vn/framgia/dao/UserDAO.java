package vn.framgia.dao;

import vn.framgia.model.User;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserDAO extends GenericDAO<User, Long> implements IUserDAO{
    public UserDAO() {
        super.setPersistentClass(User.class);
    }
}
