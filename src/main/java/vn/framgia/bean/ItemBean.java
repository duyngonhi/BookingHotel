package vn.framgia.bean;

import java.io.Serializable;
import vn.framgia.model.Booking;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
public class ItemBean implements Serializable {
    private int id;
    private String name;
    private float price;
    private String description;

    private List bookings = new ArrayList();
    public ItemBean() {}

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

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public List getBookings() {
        return bookings;
    }

    public void setBookings(List bookings) {
        this.bookings = bookings;
    }
}
