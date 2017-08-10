package smartlock.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import smartlock.member.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberWebController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null) {
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("/smartlock/log_in");
		}
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupSelect(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null) {
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("/smartlock/sign_up_select");
		}
	}

	@RequestMapping(value = "/signup/manager", method = RequestMethod.GET)
	public ModelAndView signupManager(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null) {
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("/smartlock/sign_up_manager");
		}
	}

	@RequestMapping(value = "/signup/user", method = RequestMethod.GET)
	public ModelAndView signupUser(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null) {
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("/smartlock/sign_up_user");
		}
	}

	@RequestMapping(value="/signup/ok", method=RequestMethod.GET)
	public ModelAndView signupOk(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");

		if (userVO != null) {
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("/smartlock/sign_up_finish");
		}
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("user", null);
		return new ModelAndView("redirect:/");
	}
}
