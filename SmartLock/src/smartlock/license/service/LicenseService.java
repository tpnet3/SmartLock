package smartlock.license.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import smartlock.license.controller.LicenseWebController;
import smartlock.license.vo.LicenseVO;
import smartlock.license.vo.ReqLicenseVO;
import smartlock.member.vo.UserVO;
import smartlock.common.CommonDAO;
import smartlock.common.vo.DataResVO;

// TODO: LicenseService

@Service
public class LicenseService {

	@Resource(name = "commonDAO")
	private CommonDAO commonDAO;

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
	}
}
