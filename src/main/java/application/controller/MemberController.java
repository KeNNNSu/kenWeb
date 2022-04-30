package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.service.MemberService;

/**
 * [會員管理頁]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @RequestMapping("/member")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView("member");
        modelAndView.addObject("memberList", memberService.findAll());
        return modelAndView;
    }
}
