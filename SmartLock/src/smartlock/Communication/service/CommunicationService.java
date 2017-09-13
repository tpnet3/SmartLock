package smartlock.Communication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import smartlock.Communication.vo.macVO;
import smartlock.common.CommonDAO;

@Service
public class CommunicationService {

	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	public ArrayList<String> getMac(String id) throws Exception{
		return (ArrayList) commonDAO.selectList("getMac", id);
	}
	
	public ArrayList<String> getSoftwareList(String id, String mac) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("mac", mac);
		return (ArrayList) commonDAO.selectList("getSoftwareList", map);
	}
	
}
