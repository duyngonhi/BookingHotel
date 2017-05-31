package vn.framgia.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UsedItem implements Serializable {
	private Integer id;
	private Booking booking;
	private Item item;

	public UsedItem() {
		super();
	}

	public UsedItem(Integer id, Booking booking, Item item) {
		super();
		this.id = id;
		this.booking = booking;
		this.item = item;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
