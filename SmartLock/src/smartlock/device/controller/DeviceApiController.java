package smartlock.device.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import smartlock.common.vo.DataResVO;
import smartlock.device.service.DeviceService;
import smartlock.device.vo.DeviceIdVO;
import smartlock.device.vo.DeviceModifyVO;
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
		UserVO userVO = (UserVO)session.getAttribute("user");

		ArrayList<DeviceVO> list = new ArrayList<DeviceVO>();

		try {
			list = deviceService.getDeviceList(userVO.getId());
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
		UserVO userVO = (UserVO)session.getAttribute("user");
		ArrayList<DeviceVO> list = new ArrayList<DeviceVO>();
		
		try{
			list = deviceService.getDeviceListBySw(userVO.getId(), sw);
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

	@RequestMapping(value = "/device/delete", method = RequestMethod.POST)
	public @ResponseBody DataResVO deleteDevice(
			@RequestBody DeviceIdVO deviceIdVO,
			HttpServletRequest request) {
		DataResVO dataResVO = new DataResVO();

		try {
			int deletedRowCnt = deviceService.deleteDevice(deviceIdVO.getId());

			if (deletedRowCnt > 0) {
				dataResVO.setStatus("success");
				dataResVO.setData(deletedRowCnt);
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
	
	@RequestMapping(value = "/device/modify", method = RequestMethod.POST)
	public @ResponseBody DataResVO modifyDevice(
			@RequestBody DeviceModifyVO deviceModifyVO,
			HttpServletRequest request) {
		DataResVO dataResVO = new DataResVO();
		
		try {
			int modifyRowCnt = deviceService.modifyDevice(deviceModifyVO.getId(), deviceModifyVO.getNickname());
			
			if(modifyRowCnt > 0) {
				dataResVO.setStatus("success");
				dataResVO.setData(modifyRowCnt);
			} else {
				dataResVO.setStatus("success");
				dataResVO.setData(null);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
		
		return dataResVO;
		
	}
}
