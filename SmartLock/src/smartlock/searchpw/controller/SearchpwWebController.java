package smartlock.searchpw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// TODO: SearchpwWebController 구현

@Controller
public class SearchpwWebController {

    @RequestMapping(value="/search_pw", method=RequestMethod.GET)
    public ModelAndView searchPw() {
        return new ModelAndView("/smartlock/search_pw");
    }
}
