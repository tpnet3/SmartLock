package smartlock.device.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import smartlock.device.service.DeviceService;
import smartlock.device.vo.DeviceVO;
import smartlock.member.vo.UserVO;

import java.util.ArrayList;

@Controller
public class DeviceWebController {

	@Resource
	private DeviceService deviceService;

	@RequestMapping(value="/device", method=RequestMethod.GET)
	public ModelAndView getAllDevice(
			@RequestParam(value="sw", required=false, defaultValue="") String sw,
			@RequestParam(value="order", required=false, defaultValue="") String order_param,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("user");

		ArrayList<String> swNameList = new ArrayList<String>();
		ArrayList<DeviceVO> deviceList;
	
		String order;
		switch (order_param) {
		case "ASC":
			order = "reg_date";
			order_param = "오름차순";
			break;
		case "DESC":
			order = "reg_date desc";
			order_param ="내림차순";
			break;
		default:
			order = "nickname";
			order_param = "";
			break;
		}
		
		try {
			if (userVO != null && userVO.getAuthority() == 0) {
				deviceList = deviceService.getDeviceList(userVO.getId(), order);

				for(int i = 0; i < deviceList.size(); i++) { 
					if(!swNameList.contains(deviceList.get(i).getSw_name())){
						swNameList.add(deviceList.get(i).getSw_name());
					} 
				}
				
				if(!sw.equals("")) {
					deviceList = deviceService.getDeviceList(userVO.getId(), sw, order);
				} 
				
				ModelAndView modelAndView = new ModelAndView("smartlock/device_user");
				
				modelAndView.addObject("deviceList", deviceList);
				modelAndView.addObject("swNameList", swNameList);
				modelAndView.addObject("sw",sw);
				modelAndView.addObject("order",order_param);
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
