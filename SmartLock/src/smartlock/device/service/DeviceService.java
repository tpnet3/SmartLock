package smartlock.device.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import smartlock.common.CommonDAO;
import smartlock.device.vo.DeviceVO;

@Service
public class DeviceService {

	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	/**
	 * id로 전체 디바이스 목록 조회
	 * @param id 조회할 사용자 아이
	 * @return 조회된 디바이스 목
	 * @throws Exception
	 */
	public ArrayList<DeviceVO> getDeviceList(String id) throws Exception {
		return (ArrayList)commonDAO.selectList("device.selectDeviceList", id);
	}
	
}
