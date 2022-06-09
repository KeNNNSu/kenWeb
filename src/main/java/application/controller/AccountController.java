package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.service.AccountService;

/**
 * <p>
 * [會員管理頁-帳號]
 * </p>
 * 
 * @author ken
 * @since 2022/05/01
 */
@Controller
public class AccountController {
    
    @Autowired
    private AccountService accountService;
    
    @RequestMapping("/account")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView("account");
        modelAndView.addObject("accountList", accountService.findAll());
        return modelAndView;
        
    }

}
