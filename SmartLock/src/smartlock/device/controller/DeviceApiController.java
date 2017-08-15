package smartlock.device.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import smartlock.common.Util;
import smartlock.common.vo.DataResVO;
import smartlock.device.service.DeviceService;
import smartlock.device.vo.DeviceIdVO;
import smartlock.device.vo.DeviceVO;

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
			list = deviceService.getDeviceList(((UserVO)session.getAttribute("user")).getId());
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
			list = deviceService.getDeviceListBySw(((UserVO)session.getAttribute("user")).getId(), sw);
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
}
