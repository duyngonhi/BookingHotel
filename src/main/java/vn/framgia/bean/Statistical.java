package vn.framgia.bean;

import java.io.Serializable;

/**
 * Created by FRAMGIA\duong.van.tien on 31/03/2017.
 */
public class Statistical implements Serializable {
    private Integer id;
    private String name;
    private Double totalPrice;

    public Statistical() {};

    public Statistical(Integer id, Double totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
