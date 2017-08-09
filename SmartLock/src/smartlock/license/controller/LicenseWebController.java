package smartlock.license.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

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

//	@RequestMapping("/license")
//	public ModelAndView test() throws Exception{
//		return licenseService.test();
//	}
	@RequestMapping("/license")
	public ModelAndView test() throws Exception{
		return licenseService.test();
	}
	@RequestMapping("/reqLicense")
	public ArrayList<ReqLicenseVO> viewAllRequest() throws Exception{
		return licenseService.viewAllRequest();
	}
}
