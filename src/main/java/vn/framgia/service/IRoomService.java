package vn.framgia.service;

import vn.framgia.bean.RoomBean;
import vn.framgia.model.Room;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public interface IRoomService extends Serializable {

    public List<RoomBean> findAllRooms();
    public boolean addRoom(RoomBean roomBean);
    public boolean deleteRoom(int id);
    public RoomBean getRoomBeanById(int id);
    public boolean udpateRoom(RoomBean roomBean);
    public List<RoomBean> getRoomByRoomName(String roomNameSearch);
    public List<RoomBean> searchRoomCondition(Date startDate, Date endDate, Integer size);
    public Room getRoomById(int id);
}
