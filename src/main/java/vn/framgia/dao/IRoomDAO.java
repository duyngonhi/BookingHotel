package vn.framgia.dao;

import vn.framgia.bean.RoomBean;
import vn.framgia.model.Room;

import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public interface IRoomDAO extends IGenericDAO<Room, Integer>{
    public List<RoomBean> getRoomByRoomName(String roomNameSearch);
    public List<Integer> searchRoomCondition(Date startDate, Date endDate, Integer size);
}
