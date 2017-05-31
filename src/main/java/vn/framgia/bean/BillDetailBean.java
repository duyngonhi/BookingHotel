package vn.framgia.bean;

import java.util.List;

public class BillDetailBean {
	private String room;
	private Integer priceRoom;
	private List<PaymentDetail> serviceFollow;
	private Integer totalRoom;
	private Integer refunded;
	private Integer remain;

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

	public List<PaymentDetail> getServiceFollow() {
		return serviceFollow;
	}

	public void setServiceFollow(List<PaymentDetail> serviceFollow) {
		this.serviceFollow = serviceFollow;
	}

	public Integer getTotalRoom() {
		return totalRoom;
	}

	public void setTotalRoom(Integer totalRoom) {
		this.totalRoom = totalRoom;
	}

	public Integer getRefunded() {
		return refunded;
	}

	public void setRefunded(Integer refunded) {
		this.refunded = refunded;
	}

	public Integer getRemain() {
		return remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}
	
}
