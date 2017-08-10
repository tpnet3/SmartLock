package smartlock.statistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// TODO: StatisticsWebController 구현

@Controller
public class StatisticsWebController {

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ModelAndView statistics(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Integer authority = (Integer) httpSession.getAttribute("authority");

        if (authority != null && authority == 1) {
            return new ModelAndView("/smartlock/statistics");
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/statistics/monthly", method = RequestMethod.GET)
    public ModelAndView statisticsMonthly(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Integer authority = (Integer) httpSession.getAttribute("authority");

        if (authority != null && authority == 1) {
            return new ModelAndView("/smartlock/statistics_monthly");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}
