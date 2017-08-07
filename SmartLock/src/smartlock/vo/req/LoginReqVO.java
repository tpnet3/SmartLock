package smartlock.vo.req;

public class LoginReqVO extends UserIdReqVO {

    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
