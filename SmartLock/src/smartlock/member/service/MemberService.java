package smartlock.member.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import smartlock.common.CommonDAO;
import smartlock.common.Util;
import smartlock.member.vo.MemberVO;

@Service
public class MemberService {

	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	public ModelAndView login() {
		return null;
	}
	
	public ModelAndView loginPost(Map<String, String> map) throws Exception{
		MemberVO vo = new MemberVO();
		vo.setId(map.get("id"));
		vo.setPassword(Util.encrypt(map.get("pwd")));
		
		MemberVO resultVO = (MemberVO)commonDAO.selectOne("test.selectTest", vo);
		
		// 존재하지 않는 아이디
		if(resultVO.getId() == null) {
			
		// 비밀번호 틀림
		} else if(!vo.getPassword().equals(resultVO.getPassword())) {
		
		// 일치
		} else {
			
		}
		
		return new ModelAndView("jsonView");
	}
	
	public ModelAndView register() {
		return null;
	}
}
