package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.model.vo.DonutChartIncome;
import application.model.vo.DonutChartIncome.DonutChartData;

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

    @RequestMapping("/report")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView("report");
        modelAndView.addObject("incomeTableData", getDonutChartIncome().transforModel());
        modelAndView.addObject("payTableData", "");
        return modelAndView;
    }

    private DonutChartIncome getDonutChartIncome() {
        List<DonutChartData> dataList = new ArrayList<>();
        dataList.add(new DonutChartData("Work", 11));
        dataList.add(new DonutChartData("Eat", 2));
        dataList.add(new DonutChartData("Commute", 2));
        dataList.add(new DonutChartData("Watch TV", 2));
        dataList.add(new DonutChartData("Sleep", 7));
        return new DonutChartIncome(dataList);

    }

}
