package vn.framgia.model;

import java.io.Serializable;

public class UserService implements Serializable {
	private int id;
	private Booking bookingId;
	private Service serviceId;

	public UserService() {
		super();
	}

	public UserService(int id, Booking bookingId, Service serviceId) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.serviceId = serviceId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Booking getBookingId() {
		return bookingId;
	}

	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}

	public Service getServiceId() {
		return serviceId;
	}

	public void setServiceId(Service serviceId) {
		this.serviceId = serviceId;
	}

}
