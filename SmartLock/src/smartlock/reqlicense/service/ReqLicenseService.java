package smartlock.reqlicense.service;

import org.springframework.stereotype.Service;
import smartlock.common.CommonDAO;
import smartlock.reqlicense.vo.ReqLicenseVO;

import javax.annotation.Resource;

@Service
public class ReqLicenseService {

    @Resource(name = "commonDAO")
    private CommonDAO commonDAO;

    /**
     * 라이센스 요청
     * @param reqLicenseVO {@link ReqLicenseVO#sw_id},
     *                     {@link ReqLicenseVO#state}
     * @return 실패시 0, 성공시 1
     * @throws Exception DAO Exception
     */
    public int addRequestLicense(ReqLicenseVO reqLicenseVO) throws Exception {
        return commonDAO.insert("reqlicense.insert", reqLicenseVO);
    }
}
