package vn.framgia.bean;

public class ShowBookingBean {
	public static final String STATUS_NO = "NO";
	public static final String STATUS_NOT = "NOT";
	public static final String STATUS_OK = "OK";

	private Integer bookingId;
	private String nameClient;
	private String nameRoom;
	private String checkIn;
	private String checkOut;
	private String paymentDate;
	private String paymentAmount;
	private String paymentByUser;
	private String textNote;
	private Integer isCheckin;
	private String status;
	private Integer priceRoom;

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

	public String getNameRoom() {
		return nameRoom;
	}

	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentByUser() {
		return paymentByUser;
	}

	public void setPaymentByUser(String paymentByUser) {
		this.paymentByUser = paymentByUser;
	}

	public String getTextNote() {
		return textNote;
	}

	public void setTextNote(String textNote) {
		this.textNote = textNote;
	}

	public Integer getIsCheckin() {
		return isCheckin;
	}

	public void setIsCheckin(Integer isCheckin) {
		this.isCheckin = isCheckin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPriceRoom() {
		return priceRoom;
	}

	public void setPriceRoom(Integer priceRoom) {
		this.priceRoom = priceRoom;
	}

}
