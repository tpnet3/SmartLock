package smartlock.license.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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

	/**
	 * 사용자 발급현황 전체 조회 
	 * id로 ArrayList<LicenseVO> 가져오는 메소드 
	 * @param id
	 * @return ArrayList<LicenseVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseVO> viewUserLicense(String id) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectLicense", id);
	}
	
	public ArrayList<LicenseVO> viewUserLicenseByName(Map<String, String> map) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectLicenseByName", map);
	}
	
	/**
	 * 사용자 요청현황 전체 조회
	 * id로 ArrayList<ReqLicenseVO> 가져오는 메소드 
	 * @param id
	 * @return ArrayList<ReqLicenseVO>
	 * @throws Exception
	 */
	public ArrayList<ReqLicenseVO> viewUserReqLicense(String id) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectReqLicense", id);
	}
	
	public ArrayList<ReqLicenseVO> viewUserReqLicenseByName(Map<String, String> map) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectReqLicenseByName", map);
	}

	
}
