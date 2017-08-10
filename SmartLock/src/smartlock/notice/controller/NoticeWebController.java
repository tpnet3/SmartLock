package smartlock.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class NoticeWebController {

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public ModelAndView notice(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Integer authority = (Integer) httpSession.getAttribute("authority");

        if (authority != null && authority == 0) {
            return new ModelAndView("/smartlock/notice_user");
        } else if (authority != null && authority == 1) {
            // TODO: notice_manager
            return new ModelAndView("/smartlock/notice_user");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}
