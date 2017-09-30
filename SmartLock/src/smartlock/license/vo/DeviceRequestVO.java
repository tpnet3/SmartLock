package smartlock.license.vo;

public class DeviceRequestVO {
	private String nickname;
	private String mac;
	private int type;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "DeviceRequestVO [nickname=" + nickname + ", mac=" + mac + ", type=" + type + "]";
	}

	
}
