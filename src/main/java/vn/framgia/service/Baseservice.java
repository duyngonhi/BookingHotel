package vn.framgia.service;

import vn.framgia.dao.IUserDAO;
import vn.framgia.dao.UserDAO;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class Baseservice {

    protected IUserDAO userDAO;

    public IUserDAO getUserDAO() {
        return null;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
