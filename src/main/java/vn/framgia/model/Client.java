package vn.framgia.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Client implements Serializable {
	private int id;
	private String fullName;
	private String cardNumber;
	private Date birthday;
	private String address;
	private String phone;

	public Client() {
		super();
	}

	public Client(int id, String fullName, String cardNumber, Date birthday,
			String address, String phone) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.cardNumber = cardNumber;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
