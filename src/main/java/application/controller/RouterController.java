package application.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 * [TODO]
 * </p>
 * 
 * @author ken
 * @since 2022/04/28
 */
@Controller
@RequestMapping("/route")
public class RouterController {

    private static Logger logger = LogManager.getLogger(RouterController.class);

    @RequestMapping("/resume")
    public ModelAndView resume(HttpServletRequest req) {
        logger.info("route resume!!");
        ModelAndView modelAndView = new ModelAndView("resume");
        return modelAndView;
    }

    @RequestMapping("/resume2")
    public ModelAndView resume2() {
        ModelAndView modelAndView = new ModelAndView("resume2");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/ajax_test")
    public String ajaxTest(@ModelAttribute Vo vo, HttpServletRequest req) {
        System.out.println(vo);
        System.err.println(req.getParameter("name"));
        logger.info("Vo: {}", vo);
        logger.info("req: {}", req.getParameter("name"));

        List<String> list = Arrays.asList("abc", "def", "ghijk");
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return json;
    }

    static class Vo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Vo [name=" + name + "]";
        }

    }
}
