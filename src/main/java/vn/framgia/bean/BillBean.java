package vn.framgia.bean;

import java.util.Date;

import vn.framgia.util.Helpers;

public class BillBean {
	public final String NOTE = "REFUNEDE_" + Helpers.convertDateTimetoString(new Date());
	private Integer id;
	private Date paymentDate;
	private Integer paymentAmount;
	private String note;
	private Integer bookingId;
	private Integer userId;
	private String nameUser;
	private String datePayment;

	public BillBean() {
		super();
	}

	public BillBean(Date paymentDate, Integer paymentAmount, String note,
			Integer bookingId, Integer userId) {
		super();
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.note = note;
		this.bookingId = bookingId;
		this.userId = userId;
	}
	
	public BillBean(Integer paymentAmount, Integer bookingId, Integer userId) {
		super();
		this.paymentAmount = paymentAmount;
		this.bookingId = bookingId;
		this.userId = userId;
	}
	
	public BillBean(String datePayment, Integer paymentAmount, String note,
			String nameUser, Integer id) {
		this.datePayment = datePayment;
		this.paymentAmount = paymentAmount;
		this.note = note;
		this.nameUser = nameUser;
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Integer paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(String datePayment) {
		this.datePayment = datePayment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
}
