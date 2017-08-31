package smartlock.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import smartlock.common.vo.DataResVO;
import smartlock.member.vo.UserVO;
import smartlock.software.service.SoftwareService;
import smartlock.software.vo.SoftwareVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SoftwareApiController {

    @Resource
    private SoftwareService softwareService;


    @RequestMapping(value = "/software/list", method = RequestMethod.POST)
    public @ResponseBody DataResVO software1(
            HttpServletRequest request) {

        return new DataResVO(request, userVO -> {
            return softwareService.softwareList();
        });
    }

    /**
     * 소프트웨어 목록 조회
     * @param softwareVO {@link SoftwareVO#sw_name}
     * @return {@link SoftwareVO}
     */
    @RequestMapping(value = "/software/corp", method = RequestMethod.GET)
    public @ResponseBody DataResVO software(
            HttpServletRequest request) {

    	return new DataResVO(request, userVO -> {
            return softwareService.softwareListByCorp(""+userVO.getCorpId());
        });
    }
}
