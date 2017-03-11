package vn.framgia.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hotel implements Serializable {
	private int id;
	private String name;
	private String address;
	private int starLevel;
	private String description;

	public Hotel() {
		super();
	}

	public Hotel(int id, String name, String address, int starLevel,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.starLevel = starLevel;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
