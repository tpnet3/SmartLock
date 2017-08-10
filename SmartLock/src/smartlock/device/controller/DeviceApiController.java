package smartlock.device.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import smartlock.common.vo.DataResVO;
import smartlock.device.service.DeviceService;
import smartlock.device.vo.DeviceVO;

@Controller
public class DeviceApiController {
	
	@Resource
	private DeviceService deviceService;
	
	@RequestMapping(
			value = "/device/all"
	)
	public @ResponseBody DataResVO viewAllDevice(
			HttpServletRequest request) {
		DataResVO dataResVO = new DataResVO();
		HttpSession session = request.getSession();
		
		ArrayList<DeviceVO> list = new ArrayList<DeviceVO>();
		
		try {
			//list = deviceService.getDeviceList(session.getAttribute("id").toString());
			list = deviceService.getDeviceList("swan");
			if(!list.isEmpty()) {
				dataResVO.setStatus("success");;
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
}
