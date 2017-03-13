package vn.framgia.bean;

import java.util.List;

public class BillDetailBean {
	private String room;
	private Integer priceRoom;
	private List<ServiceFollowBean> serviceFollow;
	private Integer totalRoom;

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Integer getPriceRoom() {
		return priceRoom;
	}

	public void setPriceRoom(Integer priceRoom) {
		this.priceRoom = priceRoom;
	}

	public List<ServiceFollowBean> getServiceFollow() {
		return serviceFollow;
	}

	public void setServiceFollow(List<ServiceFollowBean> serviceFollow) {
		this.serviceFollow = serviceFollow;
	}

	public Integer getTotalRoom() {
		return totalRoom;
	}

	public void setTotalRoom(Integer totalRoom) {
		this.totalRoom = totalRoom;
	}

}
