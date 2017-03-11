package vn.framgia.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import vn.framgia.util.Helpers;
import vn.framgia.bean.AuthentUserBean;
import vn.framgia.bean.UserBean;
import vn.framgia.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserServiceImpl extends Baseservice implements IUserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

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
    
    @Override
	public AuthentUserBean getUserByAcount(String username) {
		try {
			User obj = userDAO.getUserByUserPass(username);
			if (obj != null) {
				Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
				AuthentUserBean authenticateBean = new AuthentUserBean();
				authenticateBean.setUserId(String.valueOf(obj.getId()));
				authenticateBean.setUsername(obj.getUsername());
				authenticateBean.setPassword(obj.getPassword());
				authList.add(new SimpleGrantedAuthority(obj.getRole()));
				authenticateBean.setRole(authList);
				return authenticateBean;
			}
		} catch (Exception e) {
			logger.error("error getRole: ", e);
		}
		return null;
	}
}
