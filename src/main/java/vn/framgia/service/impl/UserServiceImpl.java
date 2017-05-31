package vn.framgia.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import vn.framgia.security.CustomUserDetail;
import vn.framgia.service.IUserService;
import vn.framgia.util.Helpers;
import vn.framgia.bean.UserBean;
import vn.framgia.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserServiceImpl extends BaseserviceImpl implements IUserService {
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
	public void createUser(UserBean userBean) {
		try {
			User user = new User();
			user.setId(userBean.getId());
			user.setUsername(userBean.getUsername());
			user.setPassword(userBean.getPassword());
			user.setFullname(userBean.getFullname());
			user.setEmail(userBean.getEmail());
			user.setPhone(userBean.getPhone());
			user.setRole(userBean.getRole());

			User result = userDAO.save(user);
			logger.info("save user success..........");
		} catch (Exception e) {
			logger.error("exception save user: " + e);
		}	
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			User user = userDAO.findById(id);
			if (user != null) {
				userDAO.delete(user);
				return true;
			} else
				return false;

		} catch (Exception e) {
			logger.debug("delete user excepton: " + e);
		}
		return false;
	}	
	
	@Override
	public CustomUserDetail getUserByAcount(String username) {
		try {
			User obj = userDAO.getUserByAcount(username);
			if (obj != null) {
				Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
				CustomUserDetail authenticateBean = new CustomUserDetail();
				authenticateBean.setUserId(String.valueOf(obj.getId()));
				authenticateBean.setUsername(obj.getUsername());
				authenticateBean.setPassword(obj.getPassword());
				authList.add(new SimpleGrantedAuthority(obj.getRole()));
				authenticateBean.setAuthorities(authList);
				return authenticateBean;
			}
		} catch (Exception e) {
			logger.error("error getRole: ", e);
		}
		return null;
	}

	@Override
	public UserBean getUserById(int id) {
		try {
			User user = userDAO.findById(id);
			if (user != null) {
				UserBean userBean = new UserBean();
				userBean.setId(user.getId());
				userBean.setFullname(user.getFullname());
				userBean.setUsername(user.getUsername());
				userBean.setPassword(user.getPassword());
				userBean.setEmail(user.getEmail());
				userBean.setPhone(user.getPhone());
				userBean.setRole(user.getRole());

				return userBean;

			} else
				return null;

		} catch (Exception e) {
			logger.debug(e);
		}
		return null;
	}

	@Override
	public boolean updateUser(UserBean userBean) {
		try {
			User user = userDAO.findById(userBean.getId());
			if (user != null) {
				user.setFullname(userBean.getFullname());
				user.setUsername(userBean.getUsername());
				user.setPassword(userBean.getPassword());
				user.setEmail(userBean.getEmail());
				user.setPhone(userBean.getPhone());
				user.setRole(userBean.getRole());
				userDAO.save(user);
				return true;
			} else
				return false;

		} catch (Exception e) {
			logger.debug("update user exception: " + e);
		}
		return false;
	}

	@Override
	public UserBean getIdProfile(int id) {
		try {
			User user = userDAO.getUserById(id);
			if(user != null){
				UserBean userBean = new UserBean();
				userBean.setId(user.getId());
				userBean.setFullname(user.getFullname());
				userBean.setUsername(user.getUsername());
				userBean.setPassword(user.getPassword());
				userBean.setEmail(user.getEmail());
				userBean.setPhone(user.getPhone());
				userBean.setRole(user.getRole());
				return userBean;
			}
			else
				return null;
		} catch (Exception e) {
			logger.error("error getRole: ", e);
		}
		return null;
	}

	@Override
	public boolean updateProfile(UserBean userBean) {
		try {
			User user = userDAO.findById(userBean.getId());
			if (user != null) {
				user.setFullname(userBean.getFullname());
				user.setUsername(userBean.getUsername());
				user.setPassword(userBean.getPassword());
				user.setEmail(userBean.getEmail());
				user.setPhone(userBean.getPhone());
				userDAO.save(user);
				return true;
			} else
				return false;

		} catch (Exception e) {
			logger.debug("update user exception: " + e);
		}
		return false;
	}
}
