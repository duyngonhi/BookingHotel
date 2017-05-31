package vn.framgia.bean;

import vn.framgia.model.Booking;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 10/03/2017.
 */
public class ClientBean implements Serializable {
    private Integer id;
    private String fullName;
    private String cardNumber;
    private Date birthDay;
    private String address;
    private String phone;
    List<Booking> bookings =  new ArrayList<Booking>();

    public ClientBean() {
        super();
    }

    public ClientBean(Integer id, String fullName, String cardNumber, Date birthDay,
                  String address, String phone) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
