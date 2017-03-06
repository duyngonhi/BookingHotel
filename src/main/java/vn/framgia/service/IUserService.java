package vn.framgia.service;

import vn.framgia.bean.UserBean;
import java.io.Serializable;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public interface IUserService extends Serializable{

    public List<UserBean> findAll();
}
