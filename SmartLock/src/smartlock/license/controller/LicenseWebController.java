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
import smartlock.license.vo.*;
import smartlock.member.vo.UserVO;


// TODO: LicenseWebController

@Controller
public class LicenseWebController {
	
	@Resource(name="licenseService")
	private LicenseService licenseService;

	//사용자 화면
	@RequestMapping(value = "/license/user", method = RequestMethod.GET)
	public ModelAndView viewUserLicense(HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 0) {
			ModelAndView modelAndView = new ModelAndView("/smartlock/license_user");
			ArrayList<LicenseUserVO> licenseUserVOArrayList = licenseService.viewUserLicense(userVO.getId());
			modelAndView.addObject("licenseUserVOArrayList", licenseUserVOArrayList);
			return modelAndView;
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/license/user/filter", method = RequestMethod.GET)
	public ModelAndView viewUserLicenseByName(HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 0) {
			return new ModelAndView("/smartlock/license_user");
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/license/user/request", method = RequestMethod.GET)
	public ModelAndView viewUserReqLicense(HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 0) {
			ModelAndView modelAndView = new ModelAndView("/smartlock/license_user_request");
			ArrayList<LicenseUserReqVO> licenseUserReqVOArrayList = licenseService.viewUserReqLicense(userVO.getId());
			modelAndView.addObject("licenseUserReqVOArrayList", licenseUserReqVOArrayList);
			return modelAndView;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/license/user/request/filter", method = RequestMethod.GET)
	public ModelAndView viewUserReqLicenseByName(HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 0) {
			return new ModelAndView("/smartlock/license_user_request");
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	//관리자 화면 
	@RequestMapping(value = "/license/manager/request", method = RequestMethod.GET)
	public ModelAndView viewManagerReqLicense(HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 1) {
			ModelAndView modelAndView = new ModelAndView("/smartlock/license_manager");
			ArrayList<LicenseManagerReqVO> licenseManagerReqVOArrayList = licenseService.viewManagerReqLicense(userVO.getId());
			modelAndView.addObject("licenseManagerReqVOArrayList", licenseManagerReqVOArrayList);
			return modelAndView;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/license/manager/request/filter", method = RequestMethod.GET)
	public ModelAndView viewManagerReqLicenseByName(HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 1) {
			return new ModelAndView("/smartlock/license_manager");
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/license/manager", method = RequestMethod.GET)
	public ModelAndView viewManagerLicense(HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 1) {
			ModelAndView modelAndView = new ModelAndView("/smartlock/license_finish_manager");
			ArrayList<LicenseManagerVO> licenseManagerVOArrayList = licenseService.viewManagerLicense(userVO.getId());
			modelAndView.addObject("licenseManagerVOArrayList", licenseManagerVOArrayList);
			return modelAndView;
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/license/manager/filter", method = RequestMethod.GET)
	public ModelAndView viewManagerLicenseByName(HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 1) {
			return new ModelAndView("/smartlock/license_finish_manager");
		} else {
			return new ModelAndView("redirect:/");
		}
	}
}