package smartlock.device.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	public ArrayList<DeviceVO> getDeviceListBySw(String id, String sw) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("sw_id", sw);
		return (ArrayList)commonDAO.selectList("device.selectDeviceBySw", map);
	}

	public int modifyDevice(int id, String nickName) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("nickname", nickName);
		return commonDAO.update("device.modifyDevice", map);
	}
	
	/**
	 * 디바이스 삭제
	 * @param id 디바이스 아이디
	 * @return 삭제된 row 수
	 * @throws Exception DAO Exception
	 */
	public int deleteDevice(int id) throws Exception {
		return commonDAO.delete("deleteDevice", id);
	}
}
