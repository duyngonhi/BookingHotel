package vn.framgia.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import vn.framgia.bean.RoomBean;
import vn.framgia.model.Hotel;
import vn.framgia.model.Room;
import vn.framgia.service.IRoomService;
import vn.framgia.util.Helpers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class RoomServiceImpl extends BaseserviceImpl implements IRoomService {
    private static final Logger logger = Logger.getLogger(RoomServiceImpl.class);

    public List<RoomBean> findAllRooms() {
        try {
            List<Room> listRooms = roomDAO.findAll();
            if (!Helpers.isEmpty(listRooms)) {
                List<RoomBean> listRoomsBean = new ArrayList<RoomBean>();
                for (Room room : listRooms) {
                    RoomBean roomBean = new RoomBean();
                    BeanUtils.copyProperties(room, roomBean);
                    listRoomsBean.add(roomBean);
                }
                return listRoomsBean;
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean addRoom(RoomBean roomBean) {
        try {
            Room room = new Room();
            room.setName(roomBean.getName());
            room.setPrice(roomBean.getPrice());
            room.setSize(roomBean.getSize());
            room.setDescription(roomBean.getDescription());
            room.setHotel(roomBean.getHotel());
            roomDAO.save(room);
            return true;
        } catch (Exception e) {
            logger.info("Exception in function addRoom : ", e);
        }
        return false;
    }

    @Override
    public boolean deleteRoom(int id) {
        try {
            Room room = roomDAO.findById(id);
            roomDAO.delete(room);
            return true;
        } catch (Exception e) {
            logger.debug("Exception in function deleteRoom: ", e);
        }
        return false;
    }

    @Override
    public RoomBean getRoomBeanById(int id) {
        try {
            Room room = roomDAO.findById(id);
            RoomBean roomBean = new RoomBean();
            roomBean.setId(room.getId());
            roomBean.setName(room.getName());
            roomBean.setPrice(room.getPrice());
            roomBean.setSize(room.getSize());
            roomBean.setDescription(room.getDescription());
            Hotel hotel = hotelDAO.getHotelById(room.getHotel().getId());
            roomBean.setHotel(hotel);;
            return roomBean;
        } catch (Exception e) {
            logger.debug("Exception in function getRoomBeanById: ", e);
        }
        return null;
    }

    @Override
    public boolean udpateRoom(RoomBean roomBean) {
        try {
            Room room = roomDAO.findById(roomBean.getId());
            room.setName(roomBean.getName());
            room.setPrice(roomBean.getPrice());
            room.setSize(roomBean.getSize());
            room.setDescription(roomBean.getDescription());
            room.setHotel(roomBean.getHotel());
            roomDAO.save(room);
            return true;
        } catch (Exception e) {
            logger.debug("Exception in function udpateRoom: ", e);
        }
        return false;
    }

    @Override
    public List<RoomBean> getRoomByRoomName(String roomName) {
        try {
            return roomDAO.getRoomByRoomName(roomName);
        } catch (Exception e) {
            logger.error("Exception in function getRoomByRoomName: ", e);
        }
        return null;
    }

    public List<RoomBean> searchRoomCondition(Date startDate, Date endDate, Integer size) {
        try {
            List<Integer> listRooms = roomDAO.searchRoomCondition(startDate, endDate, size);
            List<RoomBean> listRoomsBean = new ArrayList<RoomBean>();
            for(int i = 0; i<listRooms.size(); ++i) {
                RoomBean roomBean = new RoomBean();
                roomBean = getRoomBeanById(Integer.parseInt(listRooms.get(i)+""));
                roomBean.setStart(Helpers.convertDatetoString(startDate));
                roomBean.setEnd(Helpers.convertDatetoString(endDate));
                listRoomsBean.add(roomBean);
            }
            return listRoomsBean;
        } catch (Exception e) {
            logger.error("Exception in function searchRoomCondition :", e);
        }
        return null;
    }

    @Override
    public Room getRoomById(int id) {
        try {
            Room room = roomDAO.findById(id);
            Hotel hotel = hotelDAO.getHotelById(room.getHotel().getId());
            room.setHotel(hotel);;
            return room;
        } catch (Exception e) {
            logger.debug("Exception in function getRoomBeanById: ", e);
        }
        return null;
    }
}
