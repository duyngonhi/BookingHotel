package vn.framgia.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Activity implements Serializable {
	private Integer id;
	private User user;
	private Integer targetId;
	private String actionType;
	private String noteAction;
	private Date createDate;
	
	public Activity() {
		super();
	}

	public Activity(Integer id, User user, Integer targetId, String actionType,
			String noteAction) {
		super();
		this.id = id;
		this.user = user;
		this.targetId = targetId;
		this.actionType = actionType;
		this.noteAction = noteAction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getNoteAction() {
		return noteAction;
	}

	public void setNoteAction(String noteAction) {
		this.noteAction = noteAction;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
