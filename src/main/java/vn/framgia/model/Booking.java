package vn.framgia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Booking implements Serializable {
	private int id;
	private Date checkIn;
	private Date checkOut;
	private float totalPrice;
	private String note;
	private Client clientId;
	private Room roomId;
	private int isCheckIn;

	public Booking() {
		super();
	}

	public Booking(int id, Date checkIn, Date checkOut, float totalPrice,
			String note, Client clientId, Room roomId, int isCheckIn) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalPrice = totalPrice;
		this.note = note;
		this.clientId = clientId;
		this.roomId = roomId;
		this.isCheckIn = isCheckIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	public int getIsCheckIn() {
		return isCheckIn;
	}

	public void setIsCheckIn(int isCheckIn) {
		this.isCheckIn = isCheckIn;
	}

}
