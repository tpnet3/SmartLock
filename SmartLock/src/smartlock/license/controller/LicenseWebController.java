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
			@RequestParam(value="sw", required=false, defaultValue="") String name,
			@RequestParam(value="order", required=false, defaultValue="") String order) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<Integer> swIdList = new ArrayList<Integer>();
				ArrayList<String> swNameList = new ArrayList<String>();
				ArrayList<LicenseUserVO> licenseUserList;
				Map<String, String> map = new HashMap<String, String>();
				System.out.println(order + "!!!!" + name);
				map.put("order",  order);
				map.put("id", userVO.getId());
				licenseUserList = licenseService.viewUserLicense(map);
				for(int i = 0; i < licenseUserList.size(); i++) { 
					if(!swIdList.contains(licenseUserList.get(i).getSw_id())){
						swIdList.add(licenseUserList.get(i).getSw_id());
						swNameList.add(licenseUserList.get(i).getSw_name());
						} 
				}
				if(!name.equals("")){
					map.put("name", name);
					licenseUserList = licenseService.viewUserLicenseByName(map);
				}
				ModelAndView modelAndView = new ModelAndView("smartlock/license_user");
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
				licenseManagerReqList = licenseService.viewManagerReqLicense(userVO.getId());
				for(int i = 0; i < licenseManagerReqList.size(); i++) { 
					if(!swNameList.contains(licenseManagerReqList.get(i).getSw_name())){
						swNameList.add(licenseManagerReqList.get(i).getSw_name());
						} 
				}
				if(!name.equals("")){
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", name);
					map.put("id", userVO.getId());
					licenseManagerReqList = licenseService.viewManagerReqLicenseByName(map);
				} 
				ModelAndView modelAndView = new ModelAndView("smartlock/license_manager");
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
				licenseManagerList = licenseService.viewManagerLicense(userVO.getId());
				for(int i = 0; i < licenseManagerList.size(); i++) { 
					if(!swNameList.contains(licenseManagerList.get(i).getSw_name())){
						swNameList.add(licenseManagerList.get(i).getSw_name());
						} 
				}
				if(!name.equals("")){
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", name);
					map.put("id", userVO.getId());
					licenseManagerList = licenseService.viewManagerLicenseByName(map);
				} 
				ModelAndView modelAndView = new ModelAndView("smartlock/license_finish_manager");
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
	
	@RequestMapping(value = "/permit/full", method = RequestMethod.POST)
	public @ResponseBody boolean permit(
			@RequestBody Map<String, String> map,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 1){
				return licenseService.permitFull(map);
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
				return licenseService.permitDemo(map);
			} else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	/*
	@RequestMapping(value = "/license/user/ascend", method = RequestMethod.POST)
	public @ResponseBody ModelAndView licenseUserAscend(
			@RequestBody String list,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		System.out.println(list);
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<LicenseUserVO> licenseUserList = new ArrayList<LicenseUserVO>();
				ArrayList<String> swNameList = new ArrayList<String>();
				licenseUserList = licenseService.licenseUserAscend(list);
				for(int i = 0; i < licenseUserList.size(); i++) { 
					if(!swNameList.contains(licenseUserList.get(i).getSw_name())){
						swNameList.add(licenseUserList.get(i).getSw_name());
						} 
				}
				ModelAndView modelAndView = new ModelAndView("smartlock/license_finish_manager");
				modelAndView.addObject("licenseUserlist", licenseUserList);
				modelAndView.addObject("swNameList", swNameList);
				return modelAndView;
			} else{
				return new ModelAndView("redirect:/");	
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}*/
	@RequestMapping(value = "/license/user/requestDemo", method = RequestMethod.POST)
	public @ResponseBody boolean licenseUserReqDemo(
			@RequestBody Map<String, String> name,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", userVO.getId());
		map.put("name", name.get("swName"));
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				return licenseService.licenseUserReqDemo(map);
			} else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
}