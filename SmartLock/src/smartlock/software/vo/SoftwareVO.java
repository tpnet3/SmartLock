package smartlock.software.vo;


import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


@Repository("softwareVO")
public class SoftwareVO {
    private String sw_name;
    private String version;
    private String proc_name;
    private String sw_info;
    private MultipartFile sw_img;
    
	public SoftwareVO() {
		super();
	}

	public SoftwareVO(String sw_name, String version, String proc_name,
			String sw_info, MultipartFile sw_img) {
		super();
		this.sw_name = sw_name;
		this.version = version;
		this.proc_name = proc_name;
		this.sw_info = sw_info;
		this.sw_img = sw_img;
	}

	public String getSw_name() {
		return sw_name;
	}

	public void setSw_name(String sw_name) {
		this.sw_name = sw_name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getProc_name() {
		return proc_name;
	}

	public void setProc_name(String proc_name) {
		this.proc_name = proc_name;
	}

	public String getSw_info() {
		return sw_info;
	}

	public void setSw_info(String sw_info) {
		this.sw_info = sw_info;
	}

	public MultipartFile getSw_img() {
		return sw_img;
	}

	public void setSw_img(MultipartFile sw_img) {
		this.sw_img = sw_img;
	}

	@Override
	public String toString() {
		return "SoftwareVO [sw_name=" + sw_name + ", version=" + version
				+ ", proc_name=" + proc_name + ", sw_info=" + sw_info
				+ ", sw_img=" + sw_img + "]";
	}
	
}
