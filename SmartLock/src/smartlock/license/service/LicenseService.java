package smartlock.license.service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;

=======
>>>>>>> master
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import smartlock.license.vo.LicenseVO;
import smartlock.common.CommonDAO;
import smartlock.common.vo.DataResVO;

// TODO: LicenseService

@Service
public class LicenseService {

	@Resource(name = "commonDAO")
	private CommonDAO commonDAO;

<<<<<<< HEAD
	public UserVO getUserVO(String id) throws Exception {
		return (UserVO) commonDAO.selectOne("user.selectUser", id);
	}

	public ArrayList<LicenseVO> getLicenseVO(String id) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectLicense", id);
	}

	public ArrayList<LicenseVO> viewUserLicense(String id) throws Exception{
		ArrayList<LicenseVO> license = new ArrayList<>();
		DataResVO dataResVO = new DataResVO();
		license = getLicenseVO(id);

		return license;
	}

	public ArrayList<ReqLicenseVO> getReqLicenseVO(int state) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectReqLicense", state);
	}

	public ArrayList<ReqLicenseVO> viewAllRequest() throws Exception {
		ArrayList<ReqLicenseVO> result = new ArrayList<>();
		int state = 1;
		result = getReqLicenseVO(state);
		System.out.println(result);
		return result;
	}

	public ArrayList<ReqLicenseVO> getReqLicenseVO(String id) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectReqLicense", id);
	}

	public ModelAndView viewUserLicense() throws Exception {
		String id = "swan";
		ArrayList<LicenseVO> license = new ArrayList<LicenseVO>();
		ArrayList<ReqLicenseVO> reqLicense = new ArrayList<ReqLicenseVO>();

		license = getLicenseVO(id);
		reqLicense = getReqLicenseVO(id);

		System.out.println(license);
		System.out.println(reqLicense);
		return new ModelAndView("/smartlock/license_user");
=======
	public ModelAndView test() throws Exception{
		LicenseVO vo = (LicenseVO)commonDAO.selectOne("license.selectLicense", null);
		System.out.println(vo);

		// /smartlock/test/aa.jsp 는 커밋하면서 제거됨
		// return new ModelAndView("/smartlock/test/aa");

		// TODO: 올바른 파일로 수정이 필요합니다.
		return new ModelAndView("/smartlock/license");
>>>>>>> master
	}
}
