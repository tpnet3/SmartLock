package smartlock.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

// TODO: SoftwareWebController 구현

@Controller
public class SoftwareWebController {

    @RequestMapping(value = "/software", method = RequestMethod.GET)
    public ModelAndView software(HttpServletRequest request) {
        // 세션 정보 javax.servlet.http.HttpSession
        //HttpSession httpSession = request.getSession();

        // 로그인시 smartlock.member.vo.UserVO, 비로그인시 null
        //UserVO userVO = (UserVO) httpSession.getAttribute("user");

        return new ModelAndView("/smartlock/software");
    }
}
