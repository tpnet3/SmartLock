package smartlock.member.vo;

public class UserVO {
	private String id;
	private String password;
	private int authority;
	private String phoneNumber;
	private String email;
	private int corpId;
	private String name;

	public UserVO() {}

	public UserVO(SignupReqVO signupReqVO) {
		this.id = signupReqVO.getId();
		this.password = signupReqVO.getPwd();
		this.authority = 0; // TODO: Authority 설정
		this.phoneNumber = signupReqVO.getPhone();
		this.email = signupReqVO.getEmail();
		this.corpId = 1; // TODO: corpId 설정
		this.name = signupReqVO.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCorpId() {
		return corpId;
	}

	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
