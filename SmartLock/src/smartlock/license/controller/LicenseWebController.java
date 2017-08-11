package smartlock.license.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import smartlock.common.vo.DataResVO;
import smartlock.license.service.LicenseService;
import smartlock.license.vo.LicenseVO;
import smartlock.license.vo.ReqLicenseVO;
import smartlock.member.vo.UserVO;


// TODO: LicenseWebController

@Controller
public class LicenseWebController {
	
	@Resource(name="licenseService")
	private LicenseService licenseService;

	//사용자 화면
	@RequestMapping(value = "/license/user", method = RequestMethod.POST)
	public ModelAndView viewUserLicense(HttpServletRequest request) throws Exception{
		return new ModelAndView("/smartlock/license_user");
	}

	@RequestMapping(value = "/license/user/filter", method = RequestMethod.POST)
	public ModelAndView viewUserLicenseByName(HttpServletRequest request) throws Exception{
		return new ModelAndView("/smartlock/license_user");
	}
	
	@RequestMapping(value = "/license/user/request", method = RequestMethod.POST)
	public ModelAndView viewUserReqLicense(HttpServletRequest request) throws Exception{
		return new ModelAndView("/smartlock/license_user_request");
	}
	
	@RequestMapping(value = "/license/user/request/filter", method = RequestMethod.POST)
	public ModelAndView viewUserReqLicenseByName(HttpServletRequest request) throws Exception{
		return new ModelAndView("/smartlock/license_user_request");
	}
	
	//관리자 화면 
	@RequestMapping(value = "/license/manager/request", method = RequestMethod.POST)
	public ModelAndView viewManagerReqLicense(HttpServletRequest request) throws Exception{
		return new ModelAndView("/smartlock/license_manager");
	}
	
	@RequestMapping(value = "/license/manager/request/filter", method = RequestMethod.POST)
	public ModelAndView viewManagerReqLicenseByName(HttpServletRequest request) throws Exception{
		return new ModelAndView("/smartlock/license_manager");
	}
	
	@RequestMapping(value = "/license/manager", method = RequestMethod.POST)
	public ModelAndView viewManagerLicense(HttpServletRequest request) throws Exception{
		return new ModelAndView("/smartlock/license_finish_manager");
	}
	
	@RequestMapping(value = "/license/manager/filter", method = RequestMethod.POST)
	public ModelAndView viewManagerLicenseByName(HttpServletRequest request) throws Exception{
		return new ModelAndView("/smartlock/license_finish_manager");
	}
}
