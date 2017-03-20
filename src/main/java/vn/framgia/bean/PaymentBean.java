package vn.framgia.bean;

import java.util.List;

public class PaymentBean {
	private Integer bookingId;
	private String nameClient;
	private String room;
	private Integer total;
	private Integer refunded;
	private Integer remain;
	private Integer inputMoney;
	private List<PaymentDetail> paymentDetails;
	
	public PaymentBean() {
		super();
	}

	public PaymentBean(Integer bookingId, String nameClient, String room,
			Integer total, Integer refunded, Integer remain,
			List<PaymentDetail> paymentDetails) {
		super();
		this.bookingId = bookingId;
		this.nameClient = nameClient;
		this.room = room;
		this.total = total;
		this.refunded = refunded;
		this.remain = remain;
		this.paymentDetails = paymentDetails;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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
	
	public Integer getInputMoney() {
		return inputMoney;
	}

	public void setInputMoney(Integer inputMoney) {
		this.inputMoney = inputMoney;
	}

	public List<PaymentDetail> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

}
