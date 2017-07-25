package smartlock.test.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import smartlock.common.CommonDAO;
import smartlock.test.vo.TestVO;

@Service
public class TestService {
	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	public ModelAndView test() throws Exception{
		TestVO vo = (TestVO)commonDAO.selectOne("test.selectTest", null);
		System.out.println(vo);
		return new ModelAndView("/smartlock/test/aa");
	}
}
