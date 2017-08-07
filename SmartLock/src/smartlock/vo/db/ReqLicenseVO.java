package smartlock.vo.db;

import java.util.Date;

public class ReqLicenseVO {

    private int id;
    private String userId;
    private Date requestDate;
    private int swId;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public int getSwId() {
        return swId;
    }

    public void setSwId(int swId) {
        this.swId = swId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
