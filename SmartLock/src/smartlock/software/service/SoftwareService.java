package smartlock.software.service;

import org.springframework.stereotype.Service;
import smartlock.common.CommonDAO;
import smartlock.software.vo.SoftwareVO;

import javax.annotation.Resource;
import java.util.List;

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
    public List<SoftwareVO> select(SoftwareVO softwareVO) throws Exception {
        return (List) commonDAO.selectList("software.select", softwareVO);
    }
}
