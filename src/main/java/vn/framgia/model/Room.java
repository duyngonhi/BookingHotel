package vn.framgia.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Room implements Serializable {
	private int id;
	private String name;
	private float price;
	private String description;
	private Hotel hotelId;

	public Room() {
		super();
	}

	public Room(int id, String name, float price, String description,
			Hotel hotelId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.hotelId = hotelId;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Hotel getHotelId() {
		return hotelId;
	}

	public void setHotelId(Hotel hotelId) {
		this.hotelId = hotelId;
	}

}
