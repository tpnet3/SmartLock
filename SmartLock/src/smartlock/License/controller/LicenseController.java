package smartlock.License.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import smartlock.License.Service.LicenseService;

@Controller
public class LicenseController {
	
	@Resource(name="licenseService")
	private LicenseService licenseService;
	
	@RequestMapping("/license")
	public ModelAndView test() throws Exception{
		return licenseService.test();
	}
}
