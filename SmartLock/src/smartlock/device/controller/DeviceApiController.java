package smartlock.device.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import smartlock.common.vo.DataResVO;
import smartlock.device.service.DeviceService;
import smartlock.device.vo.DeviceVO;
import smartlock.member.vo.UserVO;

@Controller
public class DeviceApiController {
	@Resource
	private DeviceService deviceService;

	@RequestMapping(value = "/device/all", method = RequestMethod.POST)
	public @ResponseBody DataResVO getAllDevicePost(
			HttpServletRequest request) {
		DataResVO dataResVO = new DataResVO();
		HttpSession session = request.getSession();

		ArrayList<DeviceVO> list = new ArrayList<DeviceVO>();

		try {
			//list = deviceService.getDeviceList(((UserVO)session.getAttribute("user")).getId());
			list = deviceService.getDeviceList("swan");
			if (!list.isEmpty()) {
				dataResVO.setStatus("success");
				dataResVO.setData(list);
			} else {
				dataResVO.setStatus("success");
				dataResVO.setData(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
		return dataResVO;
	}
	@RequestMapping(value = "/device", method = RequestMethod.GET)
	public @ResponseBody DataResVO getDeviceBySw(
			@RequestParam("sw") String sw,
			HttpServletRequest request) {
		DataResVO dataResVO = new DataResVO();
		HttpSession session = request.getSession();
		ArrayList<DeviceVO> list = new ArrayList<DeviceVO>();
		
		try{
			//list = deviceService.getDeviceListBySw(((UserVO)session.getAttribute("user")).getId(), sw);
			list = deviceService.getDeviceListBySw("swan", sw);
			if(!list.isEmpty()) {
				dataResVO.setStatus("success");
				dataResVO.setData(list);
			} else {
				dataResVO.setStatus("success");
				dataResVO.setData(null);
			}
		}catch (Exception e) {
			e.printStackTrace();
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
		
		return dataResVO;
	}
}
