package vn.framgia.bean;


public class ShowBookingBean {
	private String nameClient;
	private String nameRoom;
	private String checkIn;
	private String checkOut;
	private String paymentDate;
	private String paymentAmount;
	private String paymentByUser;
	private String textNote;
	private int isCheckin;
	private boolean status;
	private float priceRoom;

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

	public int getIsCheckin() {
		return isCheckin;
	}

	public void setIsCheckin(int isCheckin) {
		this.isCheckin = isCheckin;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getPriceRoom() {
		return priceRoom;
	}

	public void setPriceRoom(float priceRoom) {
		this.priceRoom = priceRoom;
	}
	
}
