package application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import application.model.req.JournalAddReq;
import application.model.req.JournalModifyReq;
import application.model.req.JournalRemoveReq;
import application.model.vo.JournalVo;
import application.model.vo.SubjectVo;
import application.response.KenResponse;
import application.response.enums.StatusCode;
import application.service.JournalManageService;
import application.service.SubjectService;

/**
 * <p>
 * [日記帳/現金帳管理]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
@Controller
public class JournalController {

    private static Logger logger = LogManager.getLogger(JournalController.class);

    @Autowired
    private JournalManageService journalManageService;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/journal")
    public ModelAndView view() {
        logger.info("進入 jounral 管理頁面");
        ModelAndView modelAndView = new ModelAndView("journal");
        List<JournalVo> journalVos = journalManageService.findAll();
        List<SubjectVo> subjectVos = subjectService.findAll();
        modelAndView.addObject("journalList", journalVos);
        modelAndView.addObject("subjectList", subjectVos);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = { "/journal/queryAll" })
    public String queryAll() {
        List<JournalVo> journalVos = journalManageService.findAll();
        KenResponse kenResponse = new KenResponse("查詢成功", journalVos, StatusCode.SUCCESS);
        return kenResponse.toJson();
    }

    @ResponseBody
    @RequestMapping(value = { "/journal/add" })
    public String add(HttpServletRequest request, JournalAddReq journalAddReq) {
        boolean result = journalManageService.add(journalAddReq);
//        String recordDateStr = request.getParameter("recordDate");
//        System.out.println(recordDateStr);
//        System.out.println(journalCashVo.getRecordDate());
        StatusCode statusCode = (result ? StatusCode.S201 : StatusCode.E401);
        KenResponse kenResponse = new KenResponse(statusCode.getMsg(), null, statusCode);
        return kenResponse.toJson();
    }
    
    @ResponseBody
    @RequestMapping(value = { "/journal/modify" })
    public String modify(HttpServletRequest request, JournalModifyReq journalModifyReq) {
        boolean result = journalManageService.modify(journalModifyReq);
//        String recordDateStr = request.getParameter("recordDate");
//        System.out.println(recordDateStr);
//        System.out.println(journalCashVo.getRecordDate());
        StatusCode statusCode = (result ? StatusCode.S202 : StatusCode.E402);
        KenResponse kenResponse = new KenResponse(statusCode.getMsg(), null, statusCode);
        return kenResponse.toJson();
    }

    @ResponseBody
    @RequestMapping(value = { "/journal/remove" })
    public String remove(JournalRemoveReq journalRemoveReq) {
        boolean result = journalManageService.remove(journalRemoveReq.getJournalBookId());
//        String recordDateStr = request.getParameter("recordDate");
//        System.out.println(recordDateStr);
//        System.out.println(journalCashVo.getRecordDate());
        StatusCode statusCode = (result ? StatusCode.S203 : StatusCode.E403);
        KenResponse kenResponse = new KenResponse(statusCode.getMsg(), null, statusCode);
        return kenResponse.toJson();
    }

}
