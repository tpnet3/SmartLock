package smartlock.license.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import smartlock.license.vo.LicenseManagerReqVO;
import smartlock.license.vo.LicenseManagerVO;
import smartlock.license.vo.LicenseUserReqVO;
import smartlock.license.vo.LicenseUserVO;
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

	/**
	 * 사용자 발급현황 전체 조회 
	 * @param String id
	 * @return ArrayList<LicenseUserVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseUserVO> viewUserLicense(String id) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectLicense", id);
	}
	
	/**
	 * 사용자 발급현황 소프트웨어명 별로 조회 
	 * @param map(id, name)
	 * @return ArrayList<LicenseUserVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseUserVO> viewUserLicenseByName(Map<String, String> map) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectLicenseByName", map);
	}
	
	/**
	 * 사용자 라이센스 요청현황 전체 조회
	 * @param String id
	 * @return ArrayList<LicenseUserReqVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseUserReqVO> viewUserReqLicense(String id) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectReqLicense", id);
	}
	
	/**
	 * 사용자 라이센스 요청현황 소프트웨어명 별 전체 조회 
	 * @param map(id, name)
	 * @return ArrayList<licenseUserReqVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseUserReqVO> viewUserReqLicenseByName(Map<String, String> map) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectReqLicenseByName", map);
	}

	public ArrayList<LicenseManagerReqVO> viewManagerReqLicense(String id) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectManagerReqLicense", id);
	}
	
	public ArrayList<LicenseManagerReqVO> viewManagerReqLicenseByName(Map<String, String> map) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectManagerReqLicenseByName", map);
	}
	
	public ArrayList<LicenseManagerVO> viewManagerLicense(String id) throws Exception{
		return (ArrayList) commonDAO.selectList("license.selectManagerLicense", id);
	}
	
}
