package vn.framgia.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Activity implements Serializable {
	private int id;
	private Client clientId;
	private Room roomId;

	public Activity() {
		super();
	}

	public Activity(int id, Client clientId, Room roomId) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.roomId = roomId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
