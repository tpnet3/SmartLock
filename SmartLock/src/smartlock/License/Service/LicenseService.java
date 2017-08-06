package smartlock.License.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import smartlock.License.vo.LicenseVO;
import smartlock.common.CommonDAO;

@Service
public class LicenseService {
	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	public ModelAndView test() throws Exception{
		LicenseVO vo = (LicenseVO)commonDAO.selectOne("license.selectLicense", null);
		System.out.println(vo);

		// /smartlock/test/aa.jsp 는 커밋하면서 제거됨
		// return new ModelAndView("/smartlock/test/aa");

		// TODO: 올바른 파일로 수정이 필요합니다.
		return new ModelAndView("/smartlock/license");
	}
}
