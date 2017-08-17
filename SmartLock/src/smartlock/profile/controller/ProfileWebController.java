package smartlock.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import smartlock.common.vo.MsgResVO;
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
            return new ModelAndView("/smartlock/profile_user");
        } else if (userVO != null && userVO.getAuthority() == 1) {
            return new ModelAndView("/smartlock/profile_manager");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
    
    @RequestMapping(value = "/profile/changePassword", method = RequestMethod.GET)
    public ModelAndView changePassword(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null) {        
            return new ModelAndView("/smartlock/profile_changePassword");
        }
        else{
        	return new ModelAndView("redirect:/");
        }
    }
    
    @RequestMapping(value = "/profile/quit", method = RequestMethod.GET)
    public ModelAndView quit(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null) {        
            return new ModelAndView("/smartlock/profile_quit");
        }
        else{
        	return new ModelAndView("redirect:/");
        }
    }
    
	@RequestMapping(value="/profile/ok", method=RequestMethod.GET)
	public ModelAndView profileOk(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");
        
        if (userVO != null) {
            return new ModelAndView("/smartlock/profile_finish");
        } else {
            return new ModelAndView("redirect:/");
        }
	}
}
