package smartlock.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import smartlock.license.service.LicenseService;
import smartlock.member.vo.UserVO;
import smartlock.software.service.SoftwareService;
import smartlock.software.vo.SoftwareReqVO;
import smartlock.software.vo.SoftwareVO;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

// TODO: SoftwareWebController 구현

@Controller
public class SoftwareWebController {

	@Resource(name="softwareService")
	private SoftwareService softwareService;

	@RequestMapping(value = "/software", method = RequestMethod.GET)
    public ModelAndView software(HttpServletRequest request) {


        return new ModelAndView("/smartlock/software");
    }

	
	@RequestMapping(value = "/software/user", method = RequestMethod.GET)
	public @ResponseBody ModelAndView softwareList(
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<SoftwareVO> softwareList = new ArrayList<SoftwareVO>();
				softwareList = softwareService.softwareList();
				
				ModelAndView modelAndView = new ModelAndView("smartlock/software_user");
				modelAndView.addObject("softwareList", softwareList);
				return modelAndView;
			} else{
				return new ModelAndView("redirect:/");	
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	
	@RequestMapping(value = "/software/user/request", method = RequestMethod.GET)
	public @ResponseBody ModelAndView requestSoftware(
			HttpServletRequest request,
			@RequestParam("id") String sw_id) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				SoftwareReqVO software;
				software = softwareService.softwareRequest(sw_id);
				
				ModelAndView modelAndView = new ModelAndView("smartlock/request_license");
				modelAndView.addObject("software", software);
				return modelAndView;
			} else{
				return new ModelAndView("redirect:/");	
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
}
