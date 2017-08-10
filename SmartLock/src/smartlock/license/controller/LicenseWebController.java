package smartlock.license.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import smartlock.license.service.LicenseService;
import smartlock.license.vo.ReqLicenseVO;

// TODO: LicenseWebController

@Controller
public class LicenseWebController {
	
	@Resource(name="licenseService")
	private LicenseService licenseService;

	@RequestMapping("/license")
	public ModelAndView license(HttpServletRequest request) throws Exception {
		/*
		TODO: user, manager, guest 에 대한 return view 나누기
		HttpSession httpSession = request.getSession();
		Integer authority = (Integer) httpSession.getAttribute("authority");

		if (authority != null && authority == 0) {
			return new ModelAndView("/smartlock/license_user");
		} else if (authority != null && authority == 1) {
			return new ModelAndView("/smartlock/license_manager");
		} else {
			return new ModelAndView("/smartlock/license");
		}
		*/

		return licenseService.test();
	}

	@RequestMapping("/reqLicense")
	public ArrayList<ReqLicenseVO> viewAllRequest() throws Exception{
		return licenseService.viewAllRequest();
	}
}
