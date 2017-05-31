package vn.framgia.service;

import vn.framgia.bean.HotelBean;
import vn.framgia.bean.RoomBean;
import vn.framgia.model.Hotel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */
public interface IHotelService extends Serializable {
    public List<HotelBean> findAllHotels();
    public HotelBean getHotelBeanById(int id);
    public Hotel getHotelById(int id);
}
