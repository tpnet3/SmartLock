package smartlock.license.vo;

import java.util.Date;

//import java.sql.Date;

public class LicenseVO {

	private int id;
	private String user_id;
	private Date start_date;
	private Date end_date;
	private int sw_id;
	private int state;
<<<<<<< Updated upstream
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getSw_id() {
		return sw_id;
	}
	public void setSw_id(int sw_id) {
		this.sw_id = sw_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
=======
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public Date getStart_date() {
		return start_date;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public int getSw_id() {
		return sw_id;
	}


	public void setSw_id(int sw_id) {
		this.sw_id = sw_id;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


>>>>>>> Stashed changes
	@Override
	public String toString() {
		return "LicenseVO [id=" + id + ", user_id=" + user_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", sw_id=" + sw_id + ", state=" + state + "]";
	}

	
	
}
