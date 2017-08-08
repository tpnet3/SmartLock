package smartlock.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainWebController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        // TODO: check user

        // guest
        return new ModelAndView("/smartlock/main");

        // user
        // return new ModelAndView("/smartlock/main");

        // manager
        // return new ModelAndView("/smartlock/main");
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
    public ModelAndView download() {
        return new ModelAndView("/smartlock/download");
    }
}
