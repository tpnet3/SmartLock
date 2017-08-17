package smartlock.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import smartlock.member.service.UserService;
import smartlock.member.vo.*;
import smartlock.profile.service.ProfileService;
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
	
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO updateProfile(
			@RequestBody UserVO userVO){
				
		MsgResVO msgResVO = new MsgResVO();
		 
		try{
			profileService.updateUser(userVO);
			msgResVO.setStatus("success");
			msgResVO.setMessage("회원정보 수정이 완료되었습니다.");
			
		}catch(Exception e){
			e.printStackTrace();
			msgResVO.setStatus("error");
			msgResVO.setMessage("error");
		}
				
		return msgResVO;
	}
	
	@RequestMapping(value = "/profile/change/success", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO changeNewPassword(
			@RequestBody UserVO userVO){
				
		MsgResVO msgResVO = new MsgResVO();
		 
		try{
			profileService.changePasswordUser(userVO);
			msgResVO.setStatus("success");
			msgResVO.setMessage("비밀번호 수정이 완료되었습니다.");
			
		}catch(Exception e){
			e.printStackTrace();
			msgResVO.setStatus("error");
			msgResVO.setMessage("error");
		}
				
		return msgResVO;
	}
	
	@RequestMapping(value = "/profile/checkPassword", method = RequestMethod.POST)
	public  @ResponseBody boolean checkPassword(
			@RequestBody UserVO userVO){
				
		MsgResVO msgResVO = new MsgResVO();
		try{
			if(profileService.checkPassword(userVO)){
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			msgResVO.setStatus("error");
			msgResVO.setMessage("error");
		}
		
		return false;
	}
	
	// /profile/checkPassword
}
