package smartlock.license.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import smartlock.common.vo.DataResVO;
import smartlock.license.service.LicenseService;
import smartlock.license.vo.*;
import smartlock.member.vo.UserVO;


// TODO: LicenseWebController

@Controller
public class LicenseWebController {
	
	@Resource(name="licenseService")
	private LicenseService licenseService;

	@RequestMapping(value = "/license/user", method = RequestMethod.GET)
	public @ResponseBody ModelAndView viewUserLicense(
			HttpServletRequest request,
			@RequestParam("name") String name) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseUserVO> licenseUserList;
				licenseUserList = licenseService.viewUserLicense(userVO.getId());
				for(int i = 0; i < licenseUserList.size(); i++) { 
					if(!swNameList.contains(licenseUserList.get(i).getSw_name())){
						swNameList.add(licenseUserList.get(i).getSw_name());
						} 
				}
				if(!name.equals("")){
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", name);
					map.put("id", userVO.getId());
					licenseUserList = licenseService.viewUserLicenseByName(map);
				}
				ModelAndView modelAndView = new ModelAndView("smartlock/license_user");
				modelAndView.addObject("licenseUserList", licenseUserList);
				modelAndView.addObject("swNameList", swNameList);
				return modelAndView;
			} else {
				return new ModelAndView("redirect:/");
			}
		} catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	
	@RequestMapping(value = "/license/user/request", method = RequestMethod.GET)
	public @ResponseBody ModelAndView viewUserReqLicense(
			@RequestParam("name") String name,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
			
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseUserReqVO> licenseUserReqList;
				licenseUserReqList = licenseService.viewUserReqLicense(userVO.getId());
				for(int i = 0; i < licenseUserReqList.size(); i++) { 
					if(!swNameList.contains(licenseUserReqList.get(i).getSw_name())){
						swNameList.add(licenseUserReqList.get(i).getSw_name());
						} 
				}
				if(!name.equals("")){Map<String, String> map = new HashMap<String, String>();
				map.put("name", name);
				map.put("id", userVO.getId());
				licenseUserReqList = licenseService.viewUserReqLicenseByName(map);
				} 
				
				ModelAndView modelAndView = new ModelAndView("smartlock/license_user_request");
				modelAndView.addObject("licenseUserReqList", licenseUserReqList);
				modelAndView.addObject("swNameList", swNameList);
				return modelAndView;
			} else {
				return new ModelAndView("redirect:/");
			}
		} catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	
	//관리자 화면 
	@RequestMapping(value = "/license/manager/request", method = RequestMethod.GET)
	public @ResponseBody ModelAndView viewManagerReqLicense(
			@RequestParam("name") String name,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		try{
			if(userVO != null && userVO.getAuthority() == 1){
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseManagerReqVO> licenseManagerReqList;
				if(name.equals("")){
					licenseManagerReqList = licenseService.viewManagerReqLicense(userVO.getId());
				} else {
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", name);
					map.put("id", userVO.getId());
					licenseManagerReqList = licenseService.viewManagerReqLicenseByName(map);
				}
				for(int i = 0; i < licenseManagerReqList.size(); i++) { 
					if(!swNameList.contains(licenseManagerReqList.get(i).getSw_name())){
						swNameList.add(licenseManagerReqList.get(i).getSw_name());
						} 
				}
				ModelAndView modelAndView = new ModelAndView("smartlock/license_manager_request");
				modelAndView.addObject("licenseManagerReqList", licenseManagerReqList);
				modelAndView.addObject("swNameList", swNameList);
				return modelAndView;
			} else {
				return new ModelAndView("redirect:/");
			}
		} catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	
	
	@RequestMapping(value = "/license/manager", method = RequestMethod.GET)
	public @ResponseBody ModelAndView viewManagerLicense(
			@RequestParam("name") String name,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
			
		try{
			if(userVO != null && userVO.getAuthority() == 1){
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseManagerVO> licenseManagerList;
				if(name.equals("")){
					licenseManagerList = licenseService.viewManagerLicense(userVO.getId());
				} else {
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", name);
					map.put("id", userVO.getId());
					licenseManagerList = licenseService.viewManagerLicenseByName(map);
				}
				for(int i = 0; i < licenseManagerList.size(); i++) { 
					if(!swNameList.contains(licenseManagerList.get(i).getSw_name())){
						swNameList.add(licenseManagerList.get(i).getSw_name());
						} 
				}
				ModelAndView modelAndView = new ModelAndView("smartlock/license_manager");
				modelAndView.addObject("licenseManagerList", licenseManagerList);
				modelAndView.addObject("swNameList", swNameList);
				return modelAndView;
			} else {
				return new ModelAndView("redirect:/");
			}
		} catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
}