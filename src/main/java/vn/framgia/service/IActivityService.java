package vn.framgia.service;

import java.io.Serializable;
import java.util.List;

import vn.framgia.bean.ActivityBean;

public interface IActivityService extends Serializable {
	public List<ActivityBean> getAllInforActivity(Integer pageNumber);
	public boolean saveActivity(ActivityBean activityBean);
}
