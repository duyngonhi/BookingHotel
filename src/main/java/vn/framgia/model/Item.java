package vn.framgia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 17/03/2017.
 */
public class Item {
    private int id;
    private String name;
    private float price;
    private String description;

    List bookings = new ArrayList();

    public Item() {}

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
