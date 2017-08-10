package smartlock.searchpw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import smartlock.member.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// TODO: SearchpwWebController 구현

@Controller
public class SearchpwWebController {

    @RequestMapping(value="/search_pw", method=RequestMethod.GET)
    public ModelAndView searchPw(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null) {
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("/smartlock/search_pw");
        }
    }
}
