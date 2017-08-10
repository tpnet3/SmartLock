package smartlock.license.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import smartlock.member.service.UserService;
import smartlock.member.vo.*;
import smartlock.common.vo.DataResVO;
import smartlock.license.service.LicenseService;
import smartlock.license.vo.LicenseVO;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LicenseApiController {
	
	
	@Resource(name="licenseService")
	private LicenseService licenseService;

   
    @RequestMapping(
            value = "/license/user",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO viewUserLicense(
            HttpServletRequest request) throws Exception {
        DataResVO dataResVO = new DataResVO();
        
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseVO> license = new ArrayList<LicenseVO>();
		//dataResVO = licenseService.viewUserLicense(userVO.getId());
		license = licenseService.viewUserLicense("swan");
		
		try{
			System.out.println(license);
			if(license.isEmpty()) {
				dataResVO.setStatus("success");
				dataResVO.setData(null);
			} else {
				dataResVO.setStatus("success");
				dataResVO.setData(license);
			}
		} catch(Exception e){
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
        return dataResVO;
    }

//    /**
//     * 아이디 중복 체크
//     * @param userIdReqVO 아이디
//     * @return DataResVO
//     */
//    @RequestMapping(
//            value="/check/id",
//            method=RequestMethod.GET
//    )
//    public @ResponseBody DataResVO checkId(
//            UserIdReqVO userIdReqVO){
//        DataResVO dataResVO = new DataResVO();
//
//        try {
//            if(userService.existId(userIdReqVO.getId())) {
//                dataResVO.setStatus("success");
//                dataResVO.setData("no");
//            } else {
//                dataResVO.setStatus("success");
//                dataResVO.setData("ok");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            dataResVO.setStatus("error");
//            dataResVO.setData("error");
//        }
//
//        return dataResVO;
//    }
//
//    /**
//     * 회원가입
//     * @param signupReqVO 회원가입 계정 정보
//     * @return UserVO
//     */
//    @RequestMapping(
//            value = "/signup",
//            method = RequestMethod.POST
//    )
//    public @ResponseBody DataResVO signupPost(
//            @RequestBody SignupReqVO signupReqVO) {
//        DataResVO dataResVO = new DataResVO();
//
//        try {
//            if (userService.signup(signupReqVO)) {
//                dataResVO.setStatus("success");
//                dataResVO.setData(userService.getUserInfoVO(signupReqVO.getId()));
//            } else {
//                dataResVO.setStatus("success");
//                dataResVO.setData(null);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            dataResVO.setStatus("error");
//            dataResVO.setData("error");
//        }
//
//        return dataResVO;
//    }
}
