package vn.framgia.dao.impl;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import vn.framgia.bean.RoomBean;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IRoomDAO;
import vn.framgia.model.Booking;
import vn.framgia.model.Room;
import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class RoomDAOImpl extends GenericDAO<Room, Integer> implements IRoomDAO {
    private static final Logger logger = Logger.getLogger(RoomDAOImpl.class);

    public RoomDAOImpl() {
        super.setPersistentClass(Room.class);
    }

    @Override
    public List<RoomBean> getRoomByRoomName(String roomName) {
        if(roomName.isEmpty()) {
            return null;
        }
        Criteria criteria = getSession().createCriteria(Room.class);
        criteria.add(Restrictions.like("name","%"+roomName+"%"));
        List<RoomBean> roomBeanList = criteria.list();
        return roomBeanList;
    }

    public List<Integer> searchRoomCondition(Date startDate, Date endDate, Integer size) {
        try {
            Criteria crt_roomIdHasBooking = getSession().createCriteria(Booking.class);
            crt_roomIdHasBooking.add(Restrictions.or(
                    Restrictions.between("checkIn", startDate, endDate),
                    Restrictions.between("checkOut", startDate, endDate)));
            crt_roomIdHasBooking.setProjection(Projections.projectionList().add(Property.forName("room.id")));
            List listRoomIdHasBooking = crt_roomIdHasBooking.list();

            Criteria crt_roomIdPass = getSession().createCriteria(Room.class);
            crt_roomIdPass.add(Restrictions.not(Restrictions.in("id",listRoomIdHasBooking)));
            crt_roomIdPass.add(Restrictions.eq("size", size));
            crt_roomIdPass.setProjection(Projections.projectionList().add(Property.forName("id")));
            return crt_roomIdPass.list();
        } catch (Exception e) {
            logger.error("Exception at function searchRoomCondition in RoomDAOImpl :", e);
        }
        return  null;
    }
}
