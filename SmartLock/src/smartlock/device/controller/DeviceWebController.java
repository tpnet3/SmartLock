package smartlock.device.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import smartlock.member.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DeviceWebController {

    @RequestMapping(value="/device", method= RequestMethod.GET)
    public ModelAndView device(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        // TODO: device list 구현

        if (userVO != null && userVO.getAuthority() == 0) {
            return new ModelAndView("/smartlock/device_user");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}
