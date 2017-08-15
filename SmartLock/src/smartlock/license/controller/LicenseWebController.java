package smartlock.license.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import smartlock.license.service.LicenseService;
import smartlock.member.vo.UserVO;

// TODO: LicenseWebController

@Controller
public class LicenseWebController {

	@Resource(name = "licenseService")
	private LicenseService licenseService;

	// 사용자 화면
	@RequestMapping(value = "/license/user", method = RequestMethod.GET)
	public ModelAndView viewUserLicense(HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 0) {
			return new ModelAndView("/smartlock/license_user");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/license/user/filter", method = RequestMethod.GET)
	public ModelAndView viewUserLicenseByName(HttpServletRequest request) throws Exception {

		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 0) {
			return new ModelAndView("/smartlock/license_user");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/license/user/request", method = RequestMethod.GET)
	public ModelAndView viewUserReqLicense(HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 0) {
			return new ModelAndView("/smartlock/license_user_request");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/license/user/request/filter", method = RequestMethod.GET)
	public ModelAndView viewUserReqLicenseByName(HttpServletRequest request) throws Exception {
		return new ModelAndView("/smartlock/license_user_request");
	}

	// 관리자 화면
	@RequestMapping(value = "/license/manager/request", method = RequestMethod.GET)
	public ModelAndView viewManagerReqLicense(HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 1) {
			return new ModelAndView("/smartlock/license_manager");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/license/manager/request/filter", method = RequestMethod.GET)
	public ModelAndView viewManagerReqLicenseByName(HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 1) {
			return new ModelAndView("/smartlock/license_manager");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/license/manager", method = RequestMethod.GET)
	public ModelAndView viewManagerLicense(HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 1) {
			return new ModelAndView("/smartlock/license_finish_manager");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/license/manager/filter", method = RequestMethod.GET)
	public ModelAndView viewManagerLicenseByName(HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null && userVO.getAuthority() == 1) {
			return new ModelAndView("/smartlock/license_finish_manager");
		} else {
			return new ModelAndView("redirect:/");
		}
	}
}
