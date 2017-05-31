package vn.framgia.dao;

import vn.framgia.bean.HotelBean;
import vn.framgia.model.Hotel;

/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */
public interface IHotelDAO extends IGenericDAO<Hotel, Integer> {

    public Hotel getHotelById(int id);
}
