package smartlock.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import smartlock.member.service.MemberService;

@Controller
public class MemberController {

	@Resource
	private MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("/smartlock/log_in");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(HttpServletRequest request,
			@RequestParam("id") String id, 
			@RequestParam("pwd") String pwd) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		return memberService.loginPost(map);
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signup() {

		// 일반사용자 회원가입
		// return new ModelAndView("/smartlock/sign_up_user");

		// 사업자 회원가입
		// return new ModelAndView("/smartlock/sign_up_manager");

		return new ModelAndView("/smartlock/sign_up_user");
	}
	
	@RequestMapping(value="/ckeck/id", method=RequestMethod.GET)
	public ModelAndView ckeckId(HttpServletRequest request,
			@RequestParam("id") String id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);

		return memberService.ckeckId(map);
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView signupPost(HttpServletRequest request,
			@RequestParam("id") String id, 
			@RequestParam("pwd") String pwd,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("corp_id") String company) throws Exception{
		System.out.println(1251251);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pwd", pwd);
		map.put("name", name);
		map.put("email", email);
		map.put("phone", phone);
		map.put("company", company);

		return memberService.signupPost(map);
	}

	@RequestMapping(value="/signup/ok", method=RequestMethod.GET)
	public ModelAndView signupPost() throws Exception{
		return new ModelAndView("/smartlock/sign_up_finish");
	}
}
