package smartlock.download.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DownloadWebController {

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView download(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Integer authority = (Integer) httpSession.getAttribute("authority");

        if (authority != null && authority == 0) {
            return new ModelAndView("/smartlock/download_user");
        } else {
            return new ModelAndView("/smartlock/download");
        }
    }
}
