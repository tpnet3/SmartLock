package smartlock.statistics.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import smartlock.member.vo.UserVO;
import smartlock.statistics.service.StatisticsService;
import smartlock.statistics.vo.StatisticsVO;

// TODO: StatisticsWebController 구현

@Controller
public class StatisticsWebController {

	@Resource(name="statisticsService")
	private StatisticsService statisticsService;
	
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ModelAndView statistics(HttpServletRequest request,
    		 @RequestParam(value="sw_id", required=false, defaultValue="0") String sw_id) throws Exception {
    	
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 1) {
        	StatisticsVO statistics = new StatisticsVO();
            ModelAndView modelAndView = new ModelAndView("/smartlock/statistics");
            
            // sw_id => all
            if(sw_id.equals("0")) {
            	statistics = statisticsService.viewStatistics(userVO.getId());
            } else {
            	Map<String, String> map = new HashMap<String, String>();
            	map.put("sw_id", sw_id);
            	map.put("corp_id", ""+userVO.getCorpId());
            	statistics = statisticsService.viewStatisticsMyName(map);
            }
            
            modelAndView.addObject("sw_id", sw_id);
            modelAndView.addObject("statistics", statistics);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/statistics/filter", method = RequestMethod.GET)
    public ModelAndView statisticsByName(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 1) {
            return new ModelAndView("/smartlock/statistics");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
    
    @RequestMapping(value = "/statistics/monthly", method = RequestMethod.POST)
    public ModelAndView statisticsMonthly(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 1) {
            return new ModelAndView("/smartlock/statistics_monthly");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
    
    @RequestMapping(value = "/statistics/monthly/filter", method = RequestMethod.POST)
    public ModelAndView statisticsMonthlyByName(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 1) {
            return new ModelAndView("/smartlock/statistics_monthly");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}
