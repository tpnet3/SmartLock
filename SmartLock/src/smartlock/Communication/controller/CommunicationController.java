package smartlock.Communication.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import smartlock.Communication.service.CommunicationService;
import smartlock.Communication.vo.macVO;
import smartlock.member.vo.UserVO;

@Controller 
public class CommunicationController {
	
	@Resource
	private CommunicationService communicationService;
	
	@RequestMapping(value="/check/mac", method=RequestMethod.POST)
	public @ResponseBody boolean checkMac(
			@RequestBody String mac,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		boolean check = true;
		try {
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<String> macList = new ArrayList<String>();
				macList = communicationService.getMac(userVO.getId());
				for(int i = 0; i < macList.size() ; i++){
					if(macList.get(i).equals(mac)){
						check = false;
					}
				}
				return check;
			} else {
				return false;
			}
		} catch(Exception e) {
			return false;
		}
	}
	
	@RequestMapping(value="/check", method = RequestMethod.POST)
	public @ResponseBody ArrayList<String> check(
			@RequestBody String mac,
			HttpServletRequest request) throws Exception{
		ArrayList<String> list = new ArrayList<String>();
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				list = communicationService.getSoftwareList(userVO.getId(), mac);
				return list;
			} else {
				return null;
			}
		} catch(Exception e){
			return null;
		}
	}
	
	@RequestMapping(value="/check/nickname", method = RequestMethod.POST)
	public @ResponseBody boolean checkNickname(
			@RequestBody String nickname,
			HttpServletRequest request) throws Exception{
		ArrayList<String> list = new ArrayList<String>();
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		boolean check = true;
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				list = communicationService.getNicknameList(userVO.getId());
				for(int i = 0; i < list.size() ; i++){
					if(nickname.equals(list.get(i))){
						check = false;
					}
				}
				return check;
			} else {
				return false;
			}
		} catch(Exception e){
			return false;
		}
	}
	
}
