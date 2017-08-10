package smartlock.download.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import smartlock.member.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// TODO: DownloadWebController 구현

@Controller
public class DownloadWebController {

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView download(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 0) {
            return new ModelAndView("/smartlock/download_user");
        } else {
            return new ModelAndView("/smartlock/download");
        }
    }
}
