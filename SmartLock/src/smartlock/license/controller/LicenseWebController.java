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
//	@RequestMapping(value = "/licenseUser_byName", method = RequestMethod.GET)
//	public ModelAndView viewUserLicenseByName(HttpServletRequest request) throws Exception{
//		HttpSession httpSession = request.getSession();
//		UserVO userVO = (UserVO) httpSession.getAttribute("user");
//	
//		HashMap<String , Object> map = new HashMap<>();
//		//map = licenseService.viewUserLicense(userVO.getId());
//		map = licenseService.viewUserLicenseByName("swan");
//		return new ModelAndView("/smartlock/license_user", map);
//	}
	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public ModelAndView login(HttpServletRequest request) {
//		
//		if (userVO != null) {
//			return new ModelAndView("redirect:/");
//		} else {
//			return new ModelAndView("/smartlock/log_in");
//		}
//	}
	
}
