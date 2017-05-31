package vn.framgia.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tienduongvan on 12/03/2017.
 */
public class ConditionBooking implements Serializable {

    private Date startDate;
    private Date endDate;
    private Integer size;

    public ConditionBooking(){};

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
