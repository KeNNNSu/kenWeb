package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.model.vo.DonutChartIncome;
import application.model.vo.DonutChartIncome.DonutChartIncomeData;
import application.model.vo.DonutChartPay;
import application.model.vo.DonutChartPay.DonutChartPayData;

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
        modelAndView.addObject("payTableData", getDonutChartPay().transforModel());
        return modelAndView;
    }

    private DonutChartIncome getDonutChartIncome() {
        List<DonutChartIncomeData> dataList = new ArrayList<>();
        dataList.add(new DonutChartIncomeData("Work", 11));
        dataList.add(new DonutChartIncomeData("Eat", 2));
        dataList.add(new DonutChartIncomeData("Commute", 2));
        dataList.add(new DonutChartIncomeData("Watch TV", 2));
        dataList.add(new DonutChartIncomeData("Sleep", 7));
        return new DonutChartIncome(dataList);

    }

    private DonutChartPay getDonutChartPay() {
        List<DonutChartPayData> dataList =new ArrayList<>();
        dataList.add(new DonutChartPayData("Watch TV", 3));
        dataList.add(new DonutChartPayData("Work", 6));
        dataList.add(new DonutChartPayData("Sleep", 8));
        dataList.add(new DonutChartPayData("Eat", 5));
        dataList.add(new DonutChartPayData("Commute", 4));
        return new DonutChartPay(dataList);

    }
}
