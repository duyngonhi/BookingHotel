package vn.framgia.bean;

import vn.framgia.model.Client;
import vn.framgia.model.Item;
import vn.framgia.model.Room;
import java.io.Serializable;
import java.util.*;

/**
 * Created by tienduongvan on 12/03/2017.
 */
public class BookingBean implements Serializable{
    private Integer id;
    private Date checkIn;
    private Date checkOut;
    private Float totalPrice;
    private String note;
    private Integer isCheckin;
    private Client client;
    private Room room;

    List items = new ArrayList();
    public BookingBean() {}

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

    public Integer getIsCheckin() {
        return isCheckin;
    }

    public void setIsCheckin(Integer isCheckin) {
        this.isCheckin = isCheckin;
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
