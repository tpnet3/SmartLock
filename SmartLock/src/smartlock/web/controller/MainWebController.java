package smartlock.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainWebController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) {
        Integer authority = (Integer) request.getSession().getAttribute("authority");

        if (authority != null && authority == 0) {
            return new ModelAndView("/smartlock/main_user");
        } else if (authority != null && authority == 1) {
            return new ModelAndView("/smartlock/main_manager");
        } else {
            return new ModelAndView("/smartlock/main");
        }
    }

    @RequestMapping(value = "/about_us", method = RequestMethod.GET)
    public ModelAndView aboutUs() {
        return new ModelAndView("/smartlock/about_us");
    }

    @RequestMapping(value = "/software", method = RequestMethod.GET)
    public ModelAndView software() {
        return new ModelAndView("/smartlock/software");
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView download(HttpServletRequest request) {
        Integer authority = (Integer) request.getSession().getAttribute("authority");

        if (authority != null && authority == 0) {
            return new ModelAndView("/smartlock/download_user");
        } else {
            return new ModelAndView("/smartlock/download");
        }
    }
}
