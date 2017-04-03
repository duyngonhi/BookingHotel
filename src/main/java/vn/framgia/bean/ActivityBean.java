package vn.framgia.bean;

import vn.framgia.model.Activity;
import vn.framgia.util.Helpers;

public class ActivityBean {
	public static final Integer PAGE_SIZE = 10; 
	public static final String BOOKING = "BOOKING";
	public static final String PAYMENT = "PAYMENT";
	public static final String BOOKING_ACTION = "Booking for ";
	public static final String PAYMENT_ACTION = "Payment for ";
	private Integer userId;
	private String nameUser;
	private String email;
	private String actionType;
	private String action;
	private String createdate;
	private Integer targetId;
	
	public ActivityBean() {
		super();
	}
	
	public ActivityBean(Integer userId, String nameUser, String email,
			String action, String createdate) {
		this.userId = userId;
		this.nameUser = nameUser;
		this.email = email;
		this.action = action;
		this.createdate = createdate;
	}
	
	public ActivityBean(Integer userId, Integer targetId, String actionType, String action) {
		super();
		this.userId = userId;
		this.targetId = targetId;
		this.actionType = actionType;
		this.action = action;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public ActivityBean setProperties(Activity activity){
		this.userId = activity.getUser().getId();
		this.nameUser = activity.getUser().getFullname();
		this.email = activity.getUser().getEmail();
		this.actionType = activity.getActionType();
		this.action = activity.getNoteAction();
		this.createdate = Helpers.convertDateTimetoString(activity.getCreateDate());
		return this;
	}
	
}
