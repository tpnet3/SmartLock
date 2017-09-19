package smartlock.software.controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import smartlock.member.vo.UserVO;
import smartlock.software.service.SoftwareService;
import smartlock.software.vo.SoftwareReqVO;
import smartlock.software.vo.SoftwareVO;

// TODO: SoftwareWebController 구현

@Controller
public class SoftwareWebController {

	@Resource(name="softwareService")
	private SoftwareService softwareService;

	@RequestMapping(value = "/software", method = RequestMethod.GET)
    public ModelAndView software(HttpServletRequest request) throws Exception{
		try{
				ArrayList<SoftwareVO> softwareList = new ArrayList<SoftwareVO>();
				softwareList = softwareService.softwareList();
				
				ModelAndView modelAndView = new ModelAndView("smartlock/software");
				modelAndView.addObject("softwareList", softwareList);
				return modelAndView;
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
    }

	
	@RequestMapping(value = "/software/user", method = RequestMethod.GET)
	public @ResponseBody ModelAndView softwareList(
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				ArrayList<SoftwareVO> softwareList = new ArrayList<SoftwareVO>();
				softwareList = softwareService.softwareListByCorp(userVO.getCorpId());
				
				ModelAndView modelAndView = new ModelAndView("smartlock/software_user");
				modelAndView.addObject("softwareList", softwareList);
				return modelAndView;
			} else{
				return new ModelAndView("redirect:/");	
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	
	@RequestMapping(value = "/software/user/request", method = RequestMethod.GET)
	public @ResponseBody ModelAndView requestSoftware(
			HttpServletRequest request,
			@RequestParam("id") String sw_id) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				SoftwareReqVO software;
				software = softwareService.softwareRequest(sw_id);
				
				ModelAndView modelAndView = new ModelAndView("smartlock/request_license");
				modelAndView.addObject("software", software);
				modelAndView.addObject("sw_id", sw_id);
				return modelAndView;
			} else{
				return new ModelAndView("redirect:/");	
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	@RequestMapping(value = "/software/user/request/final", method = RequestMethod.POST)
	public @ResponseBody void requestSoftwareFinal(
			@RequestBody Map<String, String> map,
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
				map.put("id", userVO.getId());
				softwareService.softwareRequestFinal(map);
		} catch(Exception e){
			e.printStackTrace();
				
		}
	}
	@RequestMapping(value = "/software/user/request/final", method = RequestMethod.GET)
	public @ResponseBody ModelAndView requestSoftwareFinalView(
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
			if(userVO != null && userVO.getAuthority() == 0){
				return new ModelAndView("smartlock/request_finish");
			} else{
				return new ModelAndView("redirect:/");	
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	
	/**
	 * 관리자 - 소프트웨어 업로드 페이지 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/software/upload", method = RequestMethod.GET)
	public @ResponseBody ModelAndView softwareUpload(
			HttpServletRequest request) throws Exception{
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		try{
		
			if(userVO != null && userVO.getAuthority() == 1){
				ModelAndView modelAndView = new ModelAndView("smartlock/software_upload");
				String corp_name = softwareService.getCorp_name(userVO.getCorpId());
				modelAndView.addObject("corp_name", corp_name);
				return modelAndView;
			} else{
				return new ModelAndView("redirect:/");	
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/");	
		}
	}
	
	/**
	 * 관리자 - 소프트웨어 업로드
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/software/upload", method = RequestMethod.POST)
	public ModelAndView softwareUpload
		(SoftwareVO softwareVO, MultipartHttpServletRequest multipartRequest) throws Exception
	{
		/*
		 * 세션 얻기
		 */
		UserVO userVO = (UserVO) multipartRequest.getSession().getAttribute("user");
		try
		{
			/*
			 * 세션 유지 & 관리자 계정일 경우
			 */
			if(userVO != null && userVO.getAuthority() == 1)
			{				

				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("sw_name", softwareVO.getSw_name());
				map.put("corp_id", userVO.getCorpId());
				map.put("version", softwareVO.getVersion());
				map.put("proc_name", softwareVO.getProc_name());
				map.put("img", softwareVO.getSw_img().getBytes());	

				//프로퍼티에 설명추가
				Properties prop = new Properties();
				OutputStream out = new FileOutputStream("");
				
				if(softwareService.softwareInsert(map) > 0)
				{
					return new ModelAndView("redirect:/software/manager");	
				} 
			}
			return new ModelAndView("redirect:/software/manager");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ModelAndView("redirect:/software/manager");	
		}
	}
}
