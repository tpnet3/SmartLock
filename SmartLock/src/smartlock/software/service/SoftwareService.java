package smartlock.software.service;

import org.springframework.stereotype.Service;
import smartlock.common.CommonDAO;
import smartlock.software.vo.SoftwareReqVO;
import smartlock.software.vo.SoftwareVO;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SoftwareService {

    @Resource(name="commonDAO")
    private CommonDAO commonDAO;

    /**
     * 소프트웨어 목록 조회
     * @param softwareVO {@link SoftwareVO#sw_name}
     * @return 결과 List
     * @throws Exception DAO Exception
     */
    public ArrayList<SoftwareVO> softwareList() throws Exception {
        return (ArrayList) commonDAO.selectList("software.softwareList", null);
    }
   
    public SoftwareReqVO softwareRequest(String id) throws Exception {
    	return (SoftwareReqVO) commonDAO.selectOne("softwareSelect", id);
    }
}
