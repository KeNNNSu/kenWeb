package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * [首頁]
 * </p>
 * 
 * @author ken
 * @since 2022/04/28
 */
@Controller
public class IndexController {

    @RequestMapping(value = { "/", "/{idx}" })
    public ModelAndView index(@PathVariable("idx") String idx) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", "KEN WEB");
        modelAndView.addObject("data", "kennnnnnn");
        boolean flag = false;
        try {
            flag = (Integer.parseInt(idx) == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        modelAndView.addObject("flag", flag);
        return modelAndView;
    }

    @RequestMapping(value = { "/index/test" })
    public ModelAndView indexTEST() {
        ModelAndView modelAndView = new ModelAndView("indexTEST");
       
        return modelAndView;
    }
}
