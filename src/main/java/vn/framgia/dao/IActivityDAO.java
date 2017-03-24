package vn.framgia.dao;

import java.util.List;

import vn.framgia.model.Activity;

public interface IActivityDAO extends IGenericDAO<Activity, Integer>{
	public List<Activity> finfAllActivityOrder(Integer pageNumber);
}
