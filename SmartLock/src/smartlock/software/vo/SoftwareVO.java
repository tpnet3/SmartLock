package smartlock.software.vo;

public class SoftwareVO {

    private int id;
    private String sw_name;
    private int corp_id;
    private String version;
    private String path;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSw_name() {
		return sw_name;
	}

	public void setSw_name(String sw_name) {
		this.sw_name = sw_name;
	}

	public int getCorp_id() {
		return corp_id;
	}

	public void setCorp_id(int corp_id) {
		this.corp_id = corp_id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "SoftwareVO{" +
				"id=" + id +
				", sw_name='" + sw_name + '\'' +
				", corp_id=" + corp_id +
				", version='" + version + '\'' +
				", path='" + path + '\'' +
				'}';
	}
}
