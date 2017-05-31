package vn.framgia.model;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
/**
 * Created by tienduongvan on 27/02/2017.
 *
 */
public class Booking implements Serializable {
	private Integer id;
	private Date checkIn;
	private Date checkOut;
	private Float totalPrice;
	private String note;
	private Client client;
	private Room room;
	private Integer isCheckIn;

	private List items = new ArrayList();
	public Booking() {
		super();
	}
	
	public Booking(Integer id) {
		this.id = id;
	}

	public Booking(Integer id, Date checkIn, Date checkOut, Float totalPrice,
			String note, Client client, Room room, Integer isCheckIn) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalPrice = totalPrice;
		this.note = note;
		this.client = client;
		this.room = room;
		this.isCheckIn = isCheckIn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getIsCheckIn() {
		return isCheckIn;
	}

	public void setIsCheckIn(Integer isCheckIn) {
		this.isCheckIn = isCheckIn;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}
}
