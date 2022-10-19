package application.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.model.enums.Month;

/**
 * <p>
 * [報表資料]
 * </p>
 * 
 * @author ken
 * @since 2022/06/15
 */
public class ReportTable {

    private ReportTableIncome income;
    private ReportTablePay pay;
    private Map<Month, BigDecimal> balance;

    private ReportTable() {
        super();
    }

    public ReportTable(ReportTableIncome income, ReportTablePay pay) {
        this();
        this.income = income;
        this.pay = pay;
        this.balance = balance(income, pay);
    }

//    public static void main(String[] args) {
//        List<ReportTableRow> rowsI = new ArrayList<>();
//        Map<Month, BigDecimal> totalIncome = new HashMap<>();
//        totalIncome.put(Month.M1, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M2, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M3, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M4, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M5, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M6, BigDecimal.valueOf(1500));
//        totalIncome.put(Month.M7, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M8, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M9, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M10, BigDecimal.valueOf(1500));
//        totalIncome.put(Month.M11, BigDecimal.valueOf(150));
//        totalIncome.put(Month.M12, BigDecimal.valueOf(1050));
//        ReportTableIncome ReportTableIncome = new ReportTableIncome(rowsI, totalIncome);
//
//        List<ReportTableRow> rowsP = new ArrayList<>();
//        Map<Month, BigDecimal> totalPay = new HashMap<>();
//        totalPay.put(Month.M1, BigDecimal.valueOf(100));
//        totalPay.put(Month.M2, BigDecimal.valueOf(1100));
//        totalPay.put(Month.M3, BigDecimal.valueOf(100));
//        totalPay.put(Month.M4, BigDecimal.valueOf(1100));
//        totalPay.put(Month.M5, BigDecimal.valueOf(100));
//        totalPay.put(Month.M6, BigDecimal.valueOf(100));
//        totalPay.put(Month.M7, BigDecimal.valueOf(1100));
//        totalPay.put(Month.M8, BigDecimal.valueOf(100));
//        totalPay.put(Month.M9, BigDecimal.valueOf(100));
//        totalPay.put(Month.M10, BigDecimal.valueOf(1001));
//        totalPay.put(Month.M11, BigDecimal.valueOf(100));
//        totalPay.put(Month.M12, BigDecimal.valueOf(1001));
//        ReportTablePay reportTablePay = new ReportTablePay(rowsP, totalPay);
//
//        Map<Month, BigDecimal> balance = ReportTable.balance(ReportTableIncome, reportTablePay);
//        System.out.println(balance);
//    }

    private static Map<Month, BigDecimal> balance(ReportTableIncome reportTableIncome, ReportTablePay reportTablePay) {

        // 1
////        Month month = Month.M1;
////        System.out.println(reportTableIncome.getTotalIncome().get(month)); //150
////        System.out.println(reportTablePay.getTotalPay().get(month)); //100
////        System.out.println(reportTableIncome.getTotalIncome().get(month).subtract(reportTablePay.getTotalPay().get(month)));
////        Map<Month, BigDecimal> balance = new HashMap<>();
////        balance.put(month ,reportTableIncome.getTotalIncome().get(month).subtract(reportTablePay.getTotalPay().get(month)));
//        Map<Month, BigDecimal> balance = new HashMap<>(); 
//        for(Month month : Month.values() ) {
//            balance.put(month ,reportTableIncome.getTotalIncome().get(month).subtract(reportTablePay.getTotalPay().get(month)));
//        }

        // 2
        Map<Month, BigDecimal> balance = new EnumMap<>(Month.class);
        for (Month month : Month.values()) {
            BigDecimal income = reportTableIncome.getTotal().get(month);
            BigDecimal pay = reportTablePay.getTotal().get(month);
            balance.put(month, income.subtract(pay));
        }
        return balance;
    }

    public void setIncome(ReportTableIncome income) {
        this.income = income;
    }

    public void setPay(ReportTablePay pay) {
        this.pay = pay;
    }

    public void setBalance(Map<Month, BigDecimal> balance) {
        this.balance = balance;
    }

    public ReportTableIncome getIncome() {
        return income;
    }

    public ReportTablePay getPay() {
        return pay;
    }

    public Map<Month, BigDecimal> getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "ReportTable [income=" + income + ", pay=" + pay + ", balance=" + balance + "]";
    }

}
