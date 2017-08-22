package smartlock.profile.service;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import smartlock.common.CommonDAO;
import smartlock.common.Util;
import smartlock.member.vo.UserInfoVO;
import smartlock.member.vo.UserVO;
import smartlock.member.vo.LoginReqVO;
import smartlock.member.vo.SignupReqVO;

@Service
public class ProfileService {
	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	/**
	 * id 로 UserVO 를 가져오는 메소드
	 * @param id 아이디
	 * @return UserVO
	 * @throws Exception DAO 예외
	 */	
	public UserVO getUserVO(String id) throws Exception{
		return (UserVO) commonDAO.selectOne("user.userInfo", id);
	}
	
	/**
	 * 
	 * @param UserVO
	 * @return void
	 * @throws Exception DAO 예외
	 */
	 public void updateUser(UserVO userVO) throws Exception{		 
		 int cnt = commonDAO.update("user.updateUser", userVO);
		 System.out.println(cnt+"개의 회원정보가 업데이트 되었습니다.");
	 }
	 
	 /**
		 * 
		 * @param UserVO
		 * @return void
		 * @throws Exception DAO 예외
		 */
	 public void changePasswordUser(UserVO userVO) throws Exception{
		// 비밀번호 암호화
		userVO.setPassword(Util.encrypt(userVO.getPassword()));
		 
		 int cnt = commonDAO.update("user.changePassword", userVO);
		 System.out.println(cnt+"개의 회원의 비밀번호가 업데이트 되었습니다.");
	 }
	 
	 /**
		 * 전송받은 패스워드와 DB패스워드 비교
		 * @param UserVO
		 * @return boolean
		 * @throws Exception DAO 예외
		 */
	 public boolean checkPassword(UserVO userVO) throws Exception{
		//json으로 받은 패스워드 : encrypt_password
		//DB에 있는 실제 패스워드 : real_password
		 String encrypt_password = Util.encrypt(userVO.getPassword());
		 String real_password = (String)commonDAO.selectOne("user.selectPassword", userVO);
		 System.out.println("회원의 비밀번호가 조회되었습니다.");
		 
		 if(encrypt_password.equals(real_password)){
			 return true;
		 }
		 else{
			 return false;
		 }
	 }
}
