package smartlock.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class QnaWebController {

    @RequestMapping(value = "/qna", method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Integer authority = (Integer) httpSession.getAttribute("authority");

        if (authority != null && authority == 0) {
            return new ModelAndView("/smartlock/qna_user");
        } else if (authority != null && authority == 1) {
            // TODO: qna_manager
            return new ModelAndView("/smartlock/qna_user");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}