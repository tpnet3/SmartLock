package smartlock.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SoftwareWebController {

    @RequestMapping(value = "/software", method = RequestMethod.GET)
    public ModelAndView software() {
        // TODO: software list 구현
        return new ModelAndView("/smartlock/software");
    }
}
