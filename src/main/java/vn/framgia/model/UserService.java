package vn.framgia.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserService implements Serializable {
	private Integer id;
	private Booking bookingId;
	private Service serviceId;

	public UserService() {
		super();
	}

	public UserService(Integer id, Booking bookingId, Service serviceId) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.serviceId = serviceId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
