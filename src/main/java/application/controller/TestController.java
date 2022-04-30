package application.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * [TODO]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/04/30
 */
@Controller
public class TestController {
    
   private static Logger logger = LogManager.getLogger(RouterController.class);
 
   @RequestMapping(value={"/test1"})
   public ModelAndView test() {
       ModelAndView modelAndView = new ModelAndView("test1");
       return modelAndView;
      
   }
}

