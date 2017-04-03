package vn.framgia.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import vn.framgia.bean.ActivityBean;
import vn.framgia.model.Activity;
import vn.framgia.model.Booking;
import vn.framgia.model.User;
import vn.framgia.service.IActivityService;
import vn.framgia.util.Helpers;

public class ActivityServiceImpl extends BaseserviceImpl implements IActivityService {
	private static final Logger logger = Logger.getLogger(ActivityServiceImpl.class);
	
	@Override
	public List<ActivityBean> getAllInforActivity(Integer pageNumber) {
		List<ActivityBean> lstActivityBeans = new ArrayList<ActivityBean>();
		try{
			List<Activity> lstActivities = activityDAO.finfAllActivityOrder(pageNumber);
			if(Helpers.isEmpty(lstActivities)){
				return lstActivityBeans;
			}
			for(Activity activity : lstActivities){
				lstActivityBeans.add( new ActivityBean().setProperties(activity));
			}
			return lstActivityBeans;
		}catch(Exception e){
			logger.info("ERROR GET ALL ACTIVITY: ", e);
		}
		return lstActivityBeans;
	}

	@Override
	public boolean saveActivity(ActivityBean activityBean) {
		try{
			Activity activity = new Activity();
			Booking booking = bookingDAO.findById(activityBean.getTargetId());
			if(booking != null){
				if(ActivityBean.BOOKING.equals(activityBean.getActionType())){
					activity.setNoteAction(activityBean.getAction()+booking.getClient().getFullName());
				}else if(ActivityBean.PAYMENT.equals(activityBean.getActionType())){
					activity.setNoteAction(activityBean.getAction()+booking.getClient().getFullName());
				}
			}
			activity.setActionType(activityBean.getActionType());
			activity.setTargetId(activityBean.getTargetId());
			activity.setUser(new User(activityBean.getUserId()));
			activity.setCreateDate(new Date());
			activityDAO.save(activity);
			return true;
		}catch(Exception e){
			logger.info("ERROR SAVE ACTIVITY: ", e);
		}
		return false;
	}

}
