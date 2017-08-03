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
		return new ModelAndView("/smartlock/test/aa");
	}
}
