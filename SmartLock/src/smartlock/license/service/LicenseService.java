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
}
