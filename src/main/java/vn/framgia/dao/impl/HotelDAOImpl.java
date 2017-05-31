package vn.framgia.dao.impl;

import org.apache.log4j.Logger;
import vn.framgia.bean.HotelBean;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IHotelDAO;
import vn.framgia.model.Hotel;
import vn.framgia.model.Room;
import vn.framgia.service.impl.RoomServiceImpl;

/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */
public class HotelDAOImpl extends GenericDAO<Hotel, Integer> implements IHotelDAO {
    private static final Logger logger = Logger.getLogger(HotelDAOImpl.class);


    public HotelDAOImpl() {
        super.setPersistentClass(Hotel.class);
    }

    @Override
    public Hotel getHotelById(int id) {
        try {
            Hotel hotel = findById(id);
            HotelBean hotelBean = new HotelBean();
            hotelBean.setId(hotel.getId());
            hotelBean.setName(hotel.getName());
            hotelBean.setAddress(hotel.getAddress());
            hotelBean.setStarLevel(hotel.getStarLevel());
            hotelBean.setDescription(hotel.getDescription());
            return hotel;
        } catch (Exception e) {
            logger.debug("Exception in function getHotelById: ", e);
        }
        return null;
    }
}
