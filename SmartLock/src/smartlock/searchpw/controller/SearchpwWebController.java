package smartlock.searchpw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import smartlock.member.service.UserService;
import smartlock.member.vo.UserVO;
import smartlock.searchpw.service.MailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// TODO: SearchpwWebController 구현

@Controller
public class SearchpwWebController {
	/* 수정중
	private UserService userService;
    private MailService mailService;
 
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
 
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }
    */

    @RequestMapping(value="/search_pw", method=RequestMethod.GET)
    public ModelAndView searchPw(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null) {
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("/smartlock/search_pw");
        }
    }
    
    @RequestMapping(value="/search_pw/authenticate", method=RequestMethod.GET)
    public ModelAndView athenticate(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null) {
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("/smartlock/search_pw_select");
        }
    }
    
    @RequestMapping(value="/search_pw/setNewPassword", method=RequestMethod.GET)
    public ModelAndView setNewPassword(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null) {
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("/smartlock/search_pw_final");
        }
    }
    
    /* 수정중
    // 비밀번호 찾기
    @RequestMapping(value = "/sendMail/password", method = RequestMethod.POST)
    public String sendMailPassword(HttpSession session, @RequestParam String id, @RequestParam String email, @RequestParam String captcha, RedirectAttributes ra) {
        String captchaValue = (String) session.getAttribute("captcha");
        if (captchaValue == null || !captchaValue.equals(captcha)) {
            ra.addFlashAttribute("resultMsg", "자동 방지 코드가 일치하지 않습니다.");
            return "redirect:/find/password";
        }
 
        //User user = userService.findAccount(email);
        if (user != null) {
            if (!user.getId().equals(id)) {
                ra.addFlashAttribute("resultMsg", "입력하신 이메일의 회원정보와 가입된 아이디가 일치하지 않습니다.");
                return "redirect:/find/password";
            }
            int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
            String password = String.valueOf(ran);
            userService.updateInfo(user.getNo(), "password", password); // 해당 유저의 DB정보 변경
 
            String subject = "임시 비밀번호 발급 안내 입니다.";
            StringBuilder sb = new StringBuilder();
            sb.append("귀하의 임시 비밀번호는 " + password + " 입니다.");
            mailService.send(subject, sb.toString(), "아이디@gmail.com", email, null);
            ra.addFlashAttribute("resultMsg", "귀하의 이메일 주소로 새로운 임시 비밀번호를 발송 하였습니다.");
        } else {
            ra.addFlashAttribute("resultMsg", "귀하의 이메일로 가입된 아이디가 존재하지 않습니다.");
        }
        return "redirect:/find/password";
    }
    */
}
