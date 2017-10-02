package smartlock.license.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import smartlock.member.vo.*;
import smartlock.common.vo.DataResVO;
import smartlock.license.service.LicenseService;
import smartlock.license.vo.DeviceRequestVO;
import smartlock.license.vo.LicenseManagerReqVO;
import smartlock.license.vo.LicenseManagerVO;
import smartlock.license.vo.LicenseUserReqVO;
import smartlock.license.vo.LicenseUserVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LicenseApiController {
	
	
	@Resource(name="licenseService")
	private LicenseService licenseService;
	
//	@RequestMapping(value="/getModalDevice", method = RequestMethod.POST) 
//	public @ResponseBody ArrayList<DeviceRequestVO> getModalDevice(
//			@RequestBody Map<String, String> map,
//			HttpServletRequest request) {
//		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
//		//System.out.println("!!!!!!!!!!"+ map.get("sw_id"));
//		LicenseService licenseService = new LicenseService();
//		ArrayList<DeviceRequestVO> deviceList = new ArrayList<DeviceRequestVO>();
//		//System.out.println("@@@@@@@@@@"+userVO.getId());
//		map.put("id", userVO.getId());
//		try {
//			deviceList = licenseService.getDevice(map);
//			System.out.println("오마갓"+deviceList.get(0));
//			return deviceList;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	
	
//	/**
//	 * 아이디로 라이센스 정보
//	 * @param userVO {@link UserVO#id}
//	 * @return {@link ArrayList<LicenseUserVO>}
//	 * @throws Exception DAO Exception
//	 */
//	@RequestMapping(
//			value = "/license/by_id",
//			method = RequestMethod.POST
//	)
//	public @ResponseBody DataResVO getUserLicenseById(
//			HttpServletRequest request,
//			@RequestBody UserVO userVO) throws Exception {
//
//		return new DataResVO(request, (sessionUserVO) -> {
//			ArrayList<LicenseUserVO> license = licenseService.viewUserLicense(userVO.getId());
//			//license = licenseService.viewUserLicense("swan");
//
//			System.out.println(license);
//
//			return license.isEmpty() ? null : license;
//		});
//	}
   
    /**
     * 개인 라이센스 전체 조회
     * @return {@link ArrayList<LicenseUserVO>}
     */
//    @RequestMapping(
//            value = "/license/user",
//            method = RequestMethod.POST
//    )
//    public @ResponseBody DataResVO viewUserLicense(
//            HttpServletRequest request) throws Exception {
//
//    	return new DataResVO(request, (userVO) -> {
//    		// 로그인 되지 않은 사용자라면 null
//    		if (userVO == null) return null;
//
//			ArrayList<LicenseUserVO> license = licenseService.viewUserLicense(userVO.getId());
//			//license = licenseService.viewUserLicense("swan");
//
//			System.out.println(license);
//
//			return license.isEmpty() ? null : license;
//		});
//
//    	/*
//		ArrayList<LicenseUserVO> license = new ArrayList<LicenseUserVO>();
//		license = licenseService.viewUserLicense(userVO.getId());
//		//license = licenseService.viewUserLicense("swan");
//
//		try{
//			System.out.println(license);
//			if(license.isEmpty()) {
//				dataResVO.setStatus("success");
//				dataResVO.setData(null);
//			} else {
//				dataResVO.setStatus("success");
//				dataResVO.setData(license);
//			}
//		} catch(Exception e){
//			dataResVO.setStatus("error");
//			dataResVO.setData("error");
//		}
//		
//        return dataResVO;
//        */
//    }
    
    /**
     * 개인 라이센스 소프트웨어명 별로 조회
	 * @param name 소프트웨어명
     * @return {@link ArrayList<LicenseUserVO>}
     */
/*    @RequestMapping(
            value = "/license/user/filter",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO viewUserLicenseByName(
    		@RequestParam("name") String name,
            HttpServletRequest request) throws Exception {

    	return new DataResVO(request, (userVO) -> {
        	// 로그인 되지 않은 사용자라면 null
        	if (userVO == null) return null;

			ArrayList<LicenseUserVO> license = new ArrayList<LicenseUserVO>();
			Map<String, String> map = new HashMap<String, String>();

			map.put("name", name);
			map.put("id", userVO.getId());
			//map.put("id", "swan");
			license = licenseService.viewUserLicenseByName(map);

			System.out.println(license);

			return license.isEmpty() ? null : license;
		});*/

        /*
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseUserVO> license = new ArrayList<LicenseUserVO>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("name", name);
		map.put("id", userVO.getId());
		//map.put("id", "swan");
		license = licenseService.viewUserLicenseByName(map);
		
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
        */
    //}
    
    /**
     * 개인 요청 라이센스 전체 조회
     * @return {@link ArrayList<LicenseUserReqVO>}
     */
   /* @RequestMapping(
            value = "/license/user/request",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO viewUserReqLicense(
            HttpServletRequest request) throws Exception {

    	return new DataResVO(request, userVO -> {
        	if (userVO == null) return null;

			ArrayList<LicenseUserReqVO> license = new ArrayList<LicenseUserReqVO>();
			license = licenseService.viewUserReqLicense(userVO.getId());
			//license = licenseService.viewUserReqLicense("madrid");

			System.out.println(license);

			return license.isEmpty() ? null : license;
		});
*/
        /*
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseUserReqVO> license = new ArrayList<LicenseUserReqVO>();
		license = licenseService.viewUserReqLicense(userVO.getId());
		//license = licenseService.viewUserReqLicense("madrid");
		
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
        */
    //}

    /**
     * 개인 요청 라이센스 소프트웨어명별 조회
	 * @param name 소프트웨어명
     * @return {@link ArrayList<LicenseUserReqVO>}
     */
    /*@RequestMapping(
            value = "/license/user/request/filter",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO viewUserReqLiceneByName(
    		@RequestParam("name") String name,
            HttpServletRequest request) throws Exception {

    	return new DataResVO(request, userVO -> {
        	if (userVO == null) return null;

			ArrayList<LicenseUserReqVO> license = new ArrayList<LicenseUserReqVO>();
			Map<String, String> map = new HashMap<String, String>();

			map.put("name", name);
			map.put("id", userVO.getId());
			//map.put("id", "madrid");
			license = licenseService.viewUserReqLicenseByName(map);

			System.out.println(license);

			return license.isEmpty() ? null : license;
		});*/

    	/*
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseUserReqVO> license = new ArrayList<LicenseUserReqVO>();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("id", userVO.getId());
		//map.put("id", "madrid");
		license = licenseService.viewUserReqLicenseByName(map);
		
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
        */
   // }
    
    /**
     * 관리자 요청 라이센스 전체 조회
     * @return {@link ArrayList<LicenseManagerReqVO>}
     */
    /*@RequestMapping(
            value = "/license/manager/request",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO viewManagerReqLicense(
            HttpServletRequest request) throws Exception {
    	return new DataResVO(request, userVO -> {
    		if (userVO == null) return null;

			ArrayList<LicenseManagerReqVO> license = new ArrayList<LicenseManagerReqVO>();
			license = licenseService.viewManagerReqLicense(userVO.getId());
			//license = licenseService.viewManagerReqLicense("arsenal");

			System.out.println(license);

			return license.isEmpty() ? null : license;
		});*/

    	/*
    	HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

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
        */
  //  }
    
    /**
     * 관리자 요청 라이센스 소프트웨어명별 조회 
	 * @param name 소프트웨어명
     * @return {@link ArrayList<LicenseManagerReqVO>}
     */
   /* @RequestMapping(
            value = "/license/manager/request/filter",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO viewManagerReqLicenseByName(
    		@RequestParam("name") String name,
            HttpServletRequest request) throws Exception {

    	return new DataResVO(request, userVO -> {
    		if (userVO == null) return null;

			ArrayList<LicenseManagerReqVO> license = new ArrayList<LicenseManagerReqVO>();
			Map<String, String> map = new HashMap<String, String>();

			map.put("name", name);
			map.put("id", userVO.getId());
			//map.put("id", "arsenal");

			license = licenseService.viewManagerReqLicenseByName(map);

			System.out.println(license);

			return license.isEmpty() ? null : license;
		});
*/
    	/*
    	DataResVO dataResVO = new DataResVO();
        
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseManagerReqVO> license = new ArrayList<LicenseManagerReqVO>();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("id", userVO.getId());
		//map.put("id", "arsenal");
		
		license = licenseService.viewManagerReqLicenseByName(map);
		
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
        */
   // }
    
    /**
     * 관리자 발급완료 라이센스 전체 조회
     * @return {@link ArrayList<LicenseManagerVO>}
     */
    /*@RequestMapping(
            value = "/license/manager",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO viewManagerLicense(
            HttpServletRequest request) throws Exception {

    	return new DataResVO(request, userVO -> {
        	if (userVO == null) return null;

			ArrayList<LicenseManagerVO> license = new ArrayList<LicenseManagerVO>();
			license = licenseService.viewManagerLicense(userVO.getId());
			//license = licenseService.viewManagerLicense("arsenal");

			System.out.println(license);

			return license.isEmpty() ? null : license;
		});*/

        /*
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseManagerVO> license = new ArrayList<LicenseManagerVO>();
		license = licenseService.viewManagerLicense(userVO.getId());
		//license = licenseService.viewManagerLicense("arsenal");
		
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
        */
    //}
    
    /**
     * 관리자 발급완료 라이센스 소프트웨어명별 조회
	 * @param name 소프트웨어명
     * @return {@link ArrayList<LicenseManagerVO>}
     */
    /*@RequestMapping(
            value = "/license/manager/filter",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO viewManagerLicense(
    		@RequestParam("name") String name,
            HttpServletRequest request) throws Exception {

    	return new DataResVO(request, userVO -> {
			ArrayList<LicenseManagerVO> license = new ArrayList<LicenseManagerVO>();
			Map<String, String> map = new HashMap<String, String>();

			map.put("name", name);
			map.put("id", userVO.getId());
			//map.put("id", "arsenal");

			System.out.println(license);

			return license.isEmpty() ? null : license;
		});*/

    	/*
    	DataResVO dataResVO = new DataResVO();
        
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseManagerVO> license = new ArrayList<LicenseManagerVO>();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("id", userVO.getId());
		//map.put("id", "arsenal");
		
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
        */
//    }
}