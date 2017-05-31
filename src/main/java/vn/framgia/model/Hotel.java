package vn.framgia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tienduongvan on 27/02/2017.
 *
 */
public class Hotel implements Serializable {

    private Integer id;
    private String name;
    private String address;
    private Integer starLevel;
    private String description;
    List<Room> rooms = new ArrayList<Room>();;

    public Hotel(){}

    public Hotel(Integer id) {
        this.id = id;
    }

    public Hotel(Integer id, String name, String address, Integer starLevel, String description, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.starLevel = starLevel;
        this.description = description;
        this.rooms = rooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
