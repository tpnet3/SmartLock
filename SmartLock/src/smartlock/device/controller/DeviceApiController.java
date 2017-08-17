package smartlock.device.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import smartlock.common.vo.DataResVO;
import smartlock.device.service.DeviceService;
import smartlock.device.vo.DeviceVO;

@Controller
public class DeviceApiController {
	@Resource
	private DeviceService deviceService;

	@RequestMapping(value = "/device/all", method = RequestMethod.POST)
	public @ResponseBody DataResVO getAllDevicePost(
			HttpServletRequest request) {

		return new DataResVO(request, (userVO) -> {
			ArrayList<DeviceVO> list = deviceService.getDeviceList("swan");
			return list.isEmpty() ? null : list;
		});

		/*
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
		*/
	}

	@RequestMapping(value = "/device", method = RequestMethod.GET)
	public @ResponseBody DataResVO getDeviceBySw(
			@RequestParam("sw") String sw,
			HttpServletRequest request) {

		return new DataResVO(request, (userVO) -> {
			ArrayList<DeviceVO> list = deviceService.getDeviceListBySw("swan", sw);
			return list.isEmpty() ? null : list;
		});

		/*
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
		*/
	}

	/**
	 * 디바이스 제거
	 * @param deviceVO 제거할 디바이스 아이디
	 * @param request HttpServletRequest
	 * @return 성공 여부
	 */
	@RequestMapping(value = "/device/delete", method = RequestMethod.POST)
	public @ResponseBody DataResVO deleteDevice(
			@RequestBody DeviceVO deviceVO,
			HttpServletRequest request) {

		return new DataResVO(request, (userVO) -> {
			return deviceService.deleteDevice(deviceVO.getId());
		});

		/*
		DataResVO dataResVO = new DataResVO();

		try {
			int deletedRowCnt = deviceService.deleteDevice(deviceVO.getId());

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
		*/
	}

	@RequestMapping(value = "/device/update/nickname", method = RequestMethod.POST)
	public @ResponseBody DataResVO updateDeviceNickname(
			@RequestBody DeviceVO deviceVO,
			HttpServletRequest request) {

		return new DataResVO(request, (userVO) -> {
			return deviceService.updateDeviceNickname(deviceVO);
		});

		/*
		DataResVO dataResVO = new DataResVO();

		try {
			int updatedRowCnt = deviceService.updateDeviceNickname(deviceVO);

			if (updatedRowCnt > 0) {
				dataResVO.setStatus("success");
				dataResVO.setData(updatedRowCnt);
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
		*/
	}
}
