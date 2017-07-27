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
		return new ModelAndView("/smartlock/member/login");
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
		return new ModelAndView("/smartlock/member/signup");
	}
}
