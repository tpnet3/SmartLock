package smartlock.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import smartlock.member.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// TODO: ProfileWebController 구현

@Controller
public class ProfileWebController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 0) {
        	ModelAndView modelAndView = new ModelAndView("/smartlock/profile_user");
        	//mdelAndView.add
            return modelAndView;
        } else if (userVO != null && userVO.getAuthority() == 1) {
            return new ModelAndView("/smartlock/profile_manager");
        } else {
            return new ModelAndView("redirect:/");
        }
    }

}
