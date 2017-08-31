package smartlock.license.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import smartlock.license.vo.LicenseManagerReqVO;
import smartlock.license.vo.LicenseManagerVO;
import smartlock.license.vo.LicenseUserReqVO;
import smartlock.license.vo.LicenseUserVO;
import smartlock.common.CommonDAO;

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
	public ArrayList<LicenseUserVO> viewUserLicense(Map<String, String> map) throws Exception {
		if(map.get("order").equals("DEFAULT")){
			return (ArrayList) commonDAO.selectList("license.selectLicense", map.get("id"));
		} else {
			return (ArrayList) commonDAO.selectList("license.selectLicenseOrder", map);
		}
	}
	
	/**
	 * 사용자 발급현황 소프트웨어명 별로 조회 
	 * @param map(id, name)
	 * @return ArrayList<LicenseUserVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseUserVO> viewUserLicenseByName(Map<String, String> map) throws Exception {
		if(map.get("order").equals("DEFAULT")){
			return (ArrayList) commonDAO.selectList("license.selectLicenseByName", map);
		} else {
			return (ArrayList) commonDAO.selectList("license.selectLicenseByNameOrder", map);
		}
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

	/**
	 * 관리자 요청 라이센스 전체조회 
	 * @param String id
	 * @return ArrayList<LicenseManagerReqVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseManagerReqVO> viewManagerReqLicense(String id) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectManagerReqLicense", id);
	}
	
	/**
	 * 관리자 요청 라이센스 소프트웨어명별 조회 
	 * @param map(id, name)
	 * @return ArrayList<LicenseManagerReqVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseManagerReqVO> viewManagerReqLicenseByName(Map<String, String> map) throws Exception {
		return (ArrayList) commonDAO.selectList("license.selectManagerReqLicenseByName", map);
	}
	
	/**
	 * 관리자 발급완료 라이센스 전체조회 
	 * @param String id
	 * @return ArrayList<LicensemanagerVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseManagerVO> viewManagerLicense(String id) throws Exception{
		return (ArrayList) commonDAO.selectList("license.selectManagerLicense", id);
	}
	
	/**
	 * 관리자 발급완료 라이센스 소프트웨어명 별 조회 
	 * @param String id
	 * @return ArrayList<LicensemanagerVO>
	 * @throws Exception
	 */
	public ArrayList<LicenseManagerVO> viewManagerLicenseByName(Map<String, String> map) throws Exception{
		return (ArrayList) commonDAO.selectList("license.selectManagerLicenseByName", map);
	}
	
	public boolean permitFull(Map<String, String> map) throws Exception{
		if(commonDAO.update("permitFull", map) != 0){
			commonDAO.delete("permitDelete", map);
			return true;
		} else{
			return false;
		}
	}
	
	public boolean permitDemo(Map<String, String> map) throws Exception{
		if(commonDAO.update("permitDemo", map) != 0){
			commonDAO.delete("permitDelete", map);
			return true;
		} else{
			return false;
		}
	}
	
	public boolean licenseUserReqDemo(Map<String, String> map) throws Exception {
		if(commonDAO.insert("licenseUserReqDemo", map) != 0){
			return true;
		} else {
			return false;
		}
	}
}
