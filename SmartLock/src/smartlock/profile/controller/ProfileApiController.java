package smartlock.profile.controller;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import smartlock.member.service.UserService;
import smartlock.member.vo.*;
import smartlock.profile.service.ProfileService;
import smartlock.profile.vo.PasswordVO;
import smartlock.common.vo.DataResVO;
import smartlock.common.vo.MsgResVO;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProfileApiController {
	
	@Resource
    private ProfileService profileService;
	
	@Resource
	private UserService userService;

	/**
	 * 프로필 업데이트
	 * @param userVO {@link UserVO#id},
	 *               {@link UserVO#email},
	 *               {@link UserVO#phone_number}
	 * @return 성공시 "회원정보 수정이 완료되었습니다.", 실패시 "error"
	 */	
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO updateProfile(
			@RequestBody UserVO userVO,
			HttpServletRequest request) {

		return new MsgResVO(request, (sessionUserVO, msgResVO) -> {
			int result = profileService.updateUser(userVO);
			
			if(result ==0){
				// 현재 비밀번호 불일치
				msgResVO.setStatus("error");
				return "error";
			}
			else{
				// 로그인시 Session data
	            UserVO loginUserVO = userService.getUserVO(userVO.getId());
	            
	            // 비밀번호 데이터 null
	            loginUserVO.setPassword(null);

	            // 세션에 로그인 정보 추가
	            request.getSession().setAttribute("user", loginUserVO);

	            // 로그인시 API 데이터
	            UserInfoVO userInfoVO = userService.getUserInfoVO(loginUserVO.getId());
	            
				return "회원정보 수정이 완료되었습니다.";
			}		
		});
	}
	
	/**
	 * 비밀번호 변경
	 * @param PasswordVO {@link PasswordVO#id},
	 *               {@link PassswordVO#password}
	 *               {@link PassswordVO#new_password}
	 * @return 성공시 "비밀번호 수정이 완료되었습니다.", 실패시 "error"
	 */
	@RequestMapping(value = "/profile/change/success", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO changeNewPassword(
			@RequestBody PasswordVO passwordVO,
			HttpServletRequest request) {
		
		return new MsgResVO(request, (sessionUserVO, msgResVO) -> {
			int result = profileService.changePasswordUser(passwordVO);
			
			if(result ==0){
				// 현재 비밀번호 불일치
				msgResVO.setStatus("error");
				return "error";
			}
			else{
				// 로그인시 Session data
	            UserVO loginUserVO = userService.getUserVO(passwordVO.getId());
	            
	            // 비밀번호 데이터 null
	            loginUserVO.setPassword(null);

	            // 세션에 로그인 정보 추가
	            request.getSession().setAttribute("user", loginUserVO);

	            // 로그인시 API 데이터
	            UserInfoVO userInfoVO = userService.getUserInfoVO(loginUserVO.getId());
	            
	            System.out.println(userInfoVO);
	            				
				return "비밀번호 수정이 완료되었습니다.";
			}
		});
	}
	
	/**
	 * 회원탈퇴
	 * @param UserVO {@link UserVO#id},
	 *               {@link UserVO#password}	 *               
	 * @return 성공시 "회원탈퇴가 완료되었습니다.", 실패시 "error"
	 */
	@RequestMapping(value = "/profile/quit/success", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO removeUser(
			@RequestBody UserVO userVO,
			HttpServletRequest request) {
		
		return new MsgResVO(request, (sessionUserVO, msgResVO) -> {
			int cnt = profileService.removeUser(userVO);
			
			if(cnt ==0){
				// 현재 비밀번호 불일치
				msgResVO.setStatus("error");
				return "error";
			}
			else{
				return "회원탈퇴가 완료되었습니다.";
			}
		});
	}
	
	/**
	 * 기업아이디로 기업이름 
	 * @param corpVO {@link CorpVO#id},
	 * @return 성공시 "success" 실패시 "error"
	 */	
	/*
	@RequestMapping(value = "/profile/getCorpName", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO getCorpName(
			@RequestBody CorpVO corpVO,
			HttpServletRequest request) {
		
		return new MsgResVO(request, (sessionUserVO, msgResVO) -> {
			String corp_name = profileService.selectCorpName(corpVO);
			request.getSession().setAttribute("corp_name", corp_name);
			
			System.out.println("select문으로 받은 기업명" +corp_name);
			System.out.println("세션에 저장중인 기업명" + request.getSession().getAttribute("corp_name"));
			
			if(corp_name == null){
				// id에 해당하는 기업명을 찾지 못했을때,
				msgResVO.setStatus("error");
				return "error";
			}
			else{
				return "success";
			}
		});
	}
	*/
}


