package smartlock.member.service;

import java.util.HashMap;
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
		
		MemberVO resultVO = (MemberVO)commonDAO.selectOne("member.memberSelect", vo);
		
		// 존재하지 않는 아이디
		if(resultVO.getId() == null) {
			
		// 비밀번호 틀림
		} else if(!vo.getPassword().equals(resultVO.getPassword())) {
		
		// 일치
		} else {
			
		}
		
		return new ModelAndView("jsonView");
	}
	
	public ModelAndView ckeckId(Map<String, Object> map) throws Exception {
		MemberVO vo = new MemberVO();
		vo.setId(map.get("id").toString());
		
		MemberVO resultVO = (MemberVO)commonDAO.selectOne("member.memberSelect", vo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//System.out.println(resultVO.getId());
		
		if(resultVO == null) {
			resultMap.put("status", "success");
			resultMap.put("data", "ok");
		} else {
			resultMap.put("status", "success");
			resultMap.put("data", "duplication");
		}
		
		return new ModelAndView("jsonView", resultMap);
	}
	
	public ModelAndView signupPost(Map<String, Object> map) throws Exception{
		MemberVO vo = new MemberVO();
		vo.setId(map.get("id").toString());
		vo.setPassword(Util.encrypt(map.get("pwd").toString()));
		vo.setName(map.get("name").toString());
		vo.setEmail(map.get("email").toString());
		vo.setPhone_number(map.get("phone").toString());
		vo.setCorp_id(1);
//		CorperationVO corpVO = new CorperationVO();
//		corpVO.setCorp_name(map.get("corp_id"));
		
		commonDAO.insert("member.memberInsert", vo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", "success");
		resultMap.put("data", vo);
		
		return new ModelAndView("jsonView", resultMap);
	}
}
