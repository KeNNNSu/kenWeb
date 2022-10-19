package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.model.report.ReportTableRow;
import application.service.ReportService;
import domain.model.dto.Subject;

/**
 * <p>
 * [報表]
 * </p>
 * 
 * @author ken
 * @since 2022/05/01
 */
@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/report")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView("report");
        modelAndView.addObject("incomeTableData", reportService.findByIncome());
        modelAndView.addObject("payTableData", reportService.findByPay());
//        modelAndView.addObject("payTableData",
//                parseDonutChartPayOfPayObject(reportService.findAllToPayObject()).transforModel());
//        modelAndView.addObject("incomeTableData", getDonutChartIncome().transforModel());
//        modelAndView.addObject("payTableData", getDonutChartPay().transforModel());
        
//        Subject subject = new Subject();
//        subject.setCode("2-1-1-1");
//        subject.setName("薩莉亞薪資");
//        ReportTableRow row = reportService.getReportTableRowCredit(subject);
//        System.out.println(row);

        modelAndView.addObject("reportTableData", reportService.getReportTable());
        return modelAndView;
    }
}
