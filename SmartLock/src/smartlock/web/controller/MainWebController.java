package smartlock.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import smartlock.member.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainWebController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 0) {
            return new ModelAndView("/smartlock/main_user");
        } else if (userVO != null && userVO.getAuthority() == 1) {
            return new ModelAndView("/smartlock/main_manager");
        } else {
            return new ModelAndView("/smartlock/main");
        }
    }

    @RequestMapping(value = "/about_us", method = RequestMethod.GET)
    public ModelAndView aboutUs() {
        return new ModelAndView("/smartlock/about_us");
    }
}
