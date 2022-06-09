package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.service.SubjectService;


/**
 * <p>
 * [管理頁]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/24
 */
@Controller
public class SubjectController {
    
    @Autowired
    private SubjectService subjectServise;
    
    @RequestMapping("/subject")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView("subject");
        modelAndView.addObject("subjectList", subjectServise.findAll());
        return modelAndView;
    }
    

}
