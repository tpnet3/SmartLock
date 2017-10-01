package smartlock.license.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.util.json.JSONArray;

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
			@RequestParam(value="sw_id", required=false, defaultValue="") String sw_id,
			@RequestParam(value="order", required=false, defaultValue="") String order) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<Integer> swIdList = new ArrayList<Integer>();
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseUserVO> licenseUserList;
//				ArrayList<DeviceRequestVO> deviceList = new ArrayList<DeviceRequestVO>();
				Map<String, String> map = new HashMap<String, String>();
				map.put("order",  order);
				map.put("id", userVO.getId());
//				deviceList = licenseService.getDevice(map);
				licenseUserList = licenseService.viewUserLicense(map);
				for(int i = 0; i < licenseUserList.size(); i++) { 
					if(!swIdList.contains(licenseUserList.get(i).getSw_id())){
						swIdList.add(licenseUserList.get(i).getSw_id());
						swNameList.add(licenseUserList.get(i).getSw_name());
						} 
				}
				if(!sw_id.equals("")){
					map.put("sw_id", sw_id);
					licenseUserList = licenseService.viewUserLicenseByName(map);
				}
				ModelAndView modelAndView = new ModelAndView("smartlock/license_user");
//				modelAndView.addObject("deviceList", deviceList);
				modelAndView.addObject("licenseUserList", licenseUserList);
				modelAndView.addObject("swNameList", swNameList);
				modelAndView.addObject("swIdList", swIdList);
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
			HttpServletRequest request,
			@RequestParam(value="sw_id", required=false, defaultValue="") String sw_id,
			@RequestParam(value="order", required=false, defaultValue="") String order)
			 throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<Integer> swIdList = new ArrayList<Integer>();
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseUserReqVO> licenseUserReqList;
				Map<String, String> map = new HashMap<String, String>();
				map.put("order",  order);
				map.put("id", userVO.getId());
				licenseUserReqList = licenseService.viewUserReqLicense(map);
				for(int i = 0; i < licenseUserReqList.size(); i++) { 
					if(!swIdList.contains(licenseUserReqList.get(i).getSw_id())){
						swIdList.add(licenseUserReqList.get(i).getSw_id());
						swNameList.add(licenseUserReqList.get(i).getSw_name());
						} 
				}
				if(!sw_id.equals("")){
					map.put("sw_id", sw_id);
					licenseUserReqList = licenseService.viewUserReqLicenseByName(map);
				} 
				
				ModelAndView modelAndView = new ModelAndView("smartlock/license_user_request");
				modelAndView.addObject("licenseUserReqList", licenseUserReqList);
				modelAndView.addObject("swNameList", swNameList);
				modelAndView.addObject("swIdList", swIdList);
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
			HttpServletRequest request,
			@RequestParam(value="sw_id", required=false, defaultValue="") String sw_id,
			@RequestParam(value="order", required=false, defaultValue="") String order) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		try{
			if(userVO != null && userVO.getAuthority() == 1){
				ArrayList<Integer> swIdList = new ArrayList<Integer>();
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseManagerReqVO> licenseManagerReqList;
				Map<String, String> map = new HashMap<String, String>();
				map.put("order",  order);
				map.put("id", userVO.getId());
				licenseManagerReqList = licenseService.viewManagerReqLicense(map);
				for(int i = 0; i < licenseManagerReqList.size(); i++) { 
					if(!swIdList.contains(licenseManagerReqList.get(i).getSw_id())){
						swIdList.add(licenseManagerReqList.get(i).getSw_id());
						swNameList.add(licenseManagerReqList.get(i).getSw_name());
						} 
				}
				if(!sw_id.equals("")){
					map.put("sw_id", sw_id);
					licenseManagerReqList = licenseService.viewManagerReqLicenseByName(map);
				} 
				ModelAndView modelAndView = new ModelAndView("smartlock/license_manager");
				modelAndView.addObject("licenseManagerReqList", licenseManagerReqList);
				modelAndView.addObject("swNameList", swNameList);
				modelAndView.addObject("swIdList", swIdList);
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
			HttpServletRequest request,
			@RequestParam(value="sw_id", required=false, defaultValue="") String sw_id,
			@RequestParam(value="order", required=false, defaultValue="") String order) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
			
		try{
			if(userVO != null && userVO.getAuthority() == 1){
				ArrayList<Integer> swIdList = new ArrayList<Integer>();
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseManagerVO> licenseManagerList;
				Map<String, String> map = new HashMap<String, String>();
				map.put("order",  order);
				map.put("id", userVO.getId());
				licenseManagerList = licenseService.viewManagerLicense(map);
				for(int i = 0; i < licenseManagerList.size(); i++) { 
					if(!swIdList.contains(licenseManagerList.get(i).getSw_id())){
						swIdList.add(licenseManagerList.get(i).getSw_id());
						swNameList.add(licenseManagerList.get(i).getSw_name());
						} 
				}
				if(!sw_id.equals("")){
					map.put("sw_id", sw_id);
					licenseManagerList = licenseService.viewManagerLicenseByName(map);
				} 
				ModelAndView modelAndView = new ModelAndView("smartlock/license_finish_manager");
				modelAndView.addObject("licenseManagerList", licenseManagerList);
				modelAndView.addObject("swNameList", swNameList);
				modelAndView.addObject("swIdList", swIdList);
				return modelAndView;
			} else {
				return new ModelAndView("redirect:/");
			}
		} catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	
	@RequestMapping(value = "/permit/full", method = RequestMethod.POST)
	public @ResponseBody boolean permit(
			@RequestBody Map<String, String> map,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 1){
				licenseService.permitFull(map);
				return true;
			} else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/permit/demo", method = RequestMethod.POST)
	public @ResponseBody boolean permitDemo(
			@RequestBody Map<String, String> map,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 1){
				licenseService.permitDemo(map);
				return true;
			} else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/license/user/requestDemo", method = RequestMethod.POST)
	public @ResponseBody boolean licenseUserReqDemo(
			@RequestBody Map<String, String> map,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		map.put("id", userVO.getId());
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				licenseService.licenseUserReqDemo(map);
				return true;
			} else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/match", method = RequestMethod.POST)
	public @ResponseBody boolean match(
			@RequestBody Map<String, String> map,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		map.put("id", userVO.getId());
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				licenseService.licenseMatch(map);
				return true;
			} else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/reject", method = RequestMethod.POST)
	public @ResponseBody boolean reject(
			@RequestBody Map<String, String> map,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 1){
				licenseService.licenseReject(map);
				return true;
			} else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
}