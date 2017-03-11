package vn.framgia.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Bill implements Serializable {
	private int id;
	private Date paymentDate;
	private float paymentAmount;
	private String note;

	public Bill() {
		super();
	}

	public Bill(int id, Date paymentDate, float paymentAmount, String note) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
