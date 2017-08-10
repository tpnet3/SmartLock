package smartlock.license.service;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import smartlock.license.controller.LicenseWebController;
import smartlock.license.vo.LicenseVO;
import smartlock.license.vo.ReqLicenseVO;
import smartlock.member.vo.UserVO;
import smartlock.common.CommonDAO;

// TODO: LicenseService

@Service
public class LicenseService {
	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;

	public UserVO getUserVO(String id) throws Exception {
		return (UserVO) commonDAO.selectOne("user.selectUser", id);
	}
	
<<<<<<< Updated upstream
	public LicenseVO getLicenseVO(String id) throws Exception{
		return (LicenseVO) commonDAO.selectOne("license.selectLicense", id);
	}
	
	public ArrayList<ReqLicenseVO> getReqLicenseVO(int state) throws Exception{
		return (ArrayList) commonDAO.selectList("license.selectReqLicense", state);
	}
	
	public ArrayList<ReqLicenseVO> viewAllRequest() throws Exception{
		ArrayList<ReqLicenseVO> result = new ArrayList<>();
		int state = 1;
		result = getReqLicenseVO(state);
		System.out.println(result);
		return result;
	}
=======
	public ArrayList<LicenseVO> getLicenseVO(String id) throws Exception{
		return (ArrayList) commonDAO.selectOne("license.selectLicense", id);
	}
	
	public ArrayList<ReqLicenseVO> getReqLicenseVO(String id) throws Exception{
		return (ArrayList) commonDAO.selectList("license.selectReqLicense", id);
	}
	
	public ModelAndView viewUserLicense() throws Exception{
		String id = "swan";
		ArrayList<LicenseVO> license = new ArrayList<LicenseVO>();
		ArrayList<ReqLicenseVO> reqLicense = new ArrayList<ReqLicenseVO>();
		
		license = getLicenseVO(id);
		reqLicense = getReqLicenseVO(id);
		
		System.out.println(license);
		System.out.println(reqLicense);
		return new ModelAndView("/smartlock/license_user");
	}
<<<<<<< HEAD
	
//	public ModelAndView viewAllRequest() throws Exception{
//		ArrayList<ReqLicenseVO> result = new ArrayList<>();
//		int state = 1;
//		result = getReqLicenseVO(state);
//		System.out.println(result);
//		return new ModelAndView("/smartlock/license_manager");
//	}
//	
//	public ModelAndView test() throws Exception{
//		System.out.println("hello~");
//		String id = "westham";
//		UserVO user = getUserVO(id);
//		System.out.println(user);
//		LicenseVO vo = getLicenseVO(id);
//		System.out.println("456");
//		System.out.println(vo);
//		System.out.println("789");
//
//		return new ModelAndView("/smartlock/license");
//	}
=======
>>>>>>> Stashed changes

	public ModelAndView test() throws Exception{
		System.out.println("hello~");
		String id = "westham";
		UserVO user = getUserVO(id);
		System.out.println(user);
		LicenseVO vo = getLicenseVO(id);
		System.out.println("456");
		System.out.println(vo);
		System.out.println("789");

		// TODO: 올바른 파일로 수정이 필요합니다.
		return new ModelAndView("/smartlock/license");
	}
<<<<<<< Updated upstream
=======
>>>>>>> master
>>>>>>> Stashed changes
}
