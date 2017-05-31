package vn.framgia.dao;

import vn.framgia.model.User;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public interface IUserDAO extends IGenericDAO<User, Integer>{
	public User getUserByAcount(String username);
	public User getUserById(int id);
}
