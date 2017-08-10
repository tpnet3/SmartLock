package smartlock.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SoftwareWebController {

    @RequestMapping(value = "/software", method = RequestMethod.GET)
    public ModelAndView software() {
        return new ModelAndView("/smartlock/software");
    }
}
