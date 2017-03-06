package vn.framgia.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import vn.framgia.util.Helpers;
import vn.framgia.bean.UserBean;
import vn.framgia.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserService extends Baseservice implements IUserService {
    private static final Logger logger = Logger.getLogger(UserService.class);

    public List<UserBean> findAll() {
        try {
            List<User> userList = userDAO.findAll();
            if (!Helpers.isEmpty(userList)) {
                List<UserBean> userInfoList = new ArrayList<UserBean>();
                for (User user : userList) {
                    UserBean userInfo = new UserBean();
                    BeanUtils.copyProperties(user, userInfo);
                    userInfoList.add(userInfo);
                }
                return userInfoList;
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }
}
