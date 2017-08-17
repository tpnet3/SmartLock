package smartlock.device.vo;

import java.sql.Date;

public class DeviceVO {
	private int id;
	private String user_id;
	private int sw_id;
	private String nickname;
	private Date reg_date;
	private int type;
	private String mac;
	private String usim;
	private String pin;
	private String serial;
	private String udid;
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
	public int getSw_id() {
		return sw_id;
	}
	public void setSw_id(int sw_id) {
		this.sw_id = sw_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getUsim() {
		return usim;
	}
	public void setUsim(String usim) {
		this.usim = usim;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getUdid() {
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
	}
	@Override
	public String toString() {
		return "DeviceVO [id=" + id + ", user_id=" + user_id + ", sw_id=" + sw_id + ", nickname=" + nickname
				+ ", reg_date=" + reg_date + ", type=" + type + ", mac=" + mac + ", usim=" + usim + ", pin=" + pin
				+ ", serial=" + serial + ", udid=" + udid + "]";
	}
}
