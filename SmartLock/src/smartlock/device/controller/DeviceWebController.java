package smartlock.device.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import smartlock.device.service.DeviceService;
import smartlock.device.vo.DeviceVO;
import smartlock.member.vo.UserVO;

import java.util.ArrayList;

@Controller
public class DeviceWebController {

	@Resource
	private DeviceService deviceService;

	@RequestMapping(value="/device/all", method=RequestMethod.GET)
	public ModelAndView getAllDevice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("user");

		try {
			if (userVO != null && userVO.getAuthority() == 0) {
				ArrayList<DeviceVO> deviceList = deviceService.getDeviceList(((UserVO)session.getAttribute("user")).getId());

				ModelAndView modelAndView = new ModelAndView("smartlock/device_user");
				modelAndView.addObject("deviceList", deviceList);
				return modelAndView;
			} else {
				return new ModelAndView("redirect:/");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/");
		}
	}
}
