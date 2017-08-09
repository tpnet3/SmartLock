package smartlock.license.vo;

public class SoftwareVO {

    private int id;
    private String name;
    private int corp_id;
    private String version;
    private String path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "SoftwareVO [id=" + id + ", name=" + name + ", corp_id=" + corp_id + ", version=" + version + ", path="
				+ path + "]";
	}

}
