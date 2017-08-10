package smartlock.device.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import smartlock.member.vo.UserVO;

@Controller
public class DeviceWebController {
	
	@RequestMapping(value="/device/all", method=RequestMethod.GET)
	public ModelAndView getAllDevice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("user");
		System.out.println(userVO);
		if(userVO != null) {
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("smartlock/device_user");
		}
	}
	
}
