package vn.framgia.bean;

import java.io.Serializable;
/**
 * Created by tienduongvan on 12/03/2017.
 */
public class ConditionBookingBean implements Serializable {

    private String startDate;
    private String endDate;
    private Integer size;

    public ConditionBookingBean(){};

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
