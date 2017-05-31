package vn.framgia.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import vn.framgia.bean.HotelBean;
import vn.framgia.bean.RoomBean;
import vn.framgia.dao.impl.HotelDAOImpl;
import vn.framgia.model.Hotel;
import vn.framgia.service.IHotelService;
import vn.framgia.util.Helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */
public class HotelServiceImpl extends BaseserviceImpl implements IHotelService {

    private static final Logger logger = Logger.getLogger(HotelServiceImpl.class);

    @Override
    public List<HotelBean> findAllHotels() {
        try {
            List<Hotel> listHotels = hotelDAO.findAll();
            if (!Helpers.isEmpty(listHotels)) {
                List<HotelBean> listHotelsBean = new ArrayList<HotelBean>();
                for (Hotel room : listHotels) {
                    HotelBean roomBean = new HotelBean();
                    BeanUtils.copyProperties(room, roomBean);
                    listHotelsBean.add(roomBean);
                }
                return listHotelsBean;
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public HotelBean getHotelBeanById(int id) {
        try {
            Hotel hotel = hotelDAO.findById(id);
            HotelBean hotelBean = new HotelBean();
            hotelBean.setId(hotel.getId());
            hotelBean.setName(hotel.getName());
            hotelBean.setAddress(hotel.getAddress());
            hotelBean.setStarLevel(hotel.getStarLevel());
            hotelBean.setDescription(hotel.getDescription());
            return hotelBean;
        } catch (Exception e) {
            logger.debug("Exception in function getHotelBeanById: ", e);
        }
        return null;
    }

    @Override
    public Hotel getHotelById(int id) {
        try {
            Hotel hotel = hotelDAO.findById(id);
            return hotel;
        } catch (Exception e) {
            logger.debug("Exception in function getHotelById: ", e);
        }
        return null;
    }

}
