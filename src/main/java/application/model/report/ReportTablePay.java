package application.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.model.enums.Month;

/**
 * <p>
 * [支出]
 * </p>
 * 
 * @author ken
 * @since 2022/06/15
 */
public class ReportTablePay {

    private List<ReportTableRow> rows;
    private Map<Month, BigDecimal> total;

    private ReportTablePay() {
        super();
    }

    public ReportTablePay(List<ReportTableRow> rows) {
        this();
        this.rows = rows;
        this.total = totalPay(rows);
    }

    private Map<Month, BigDecimal> totalPay(List<ReportTableRow> rows) {
        Map<Month, BigDecimal> totalPay = new HashMap<>();
        for (Month month : Month.values()) {
            BigDecimal sum = BigDecimal.ZERO;
            for (ReportTableRow row : rows) {
                sum = sum.add(row.getMonthColumns().get(month));
                totalPay.put(month, sum);
            }
        }
        return totalPay;
    }

    public static void main(String[] args) {
        List<ReportTableRow> rows = new ArrayList<>();
        ReportTableRow row1 = new ReportTableRow("2-2", "支出");
        Map<Month, BigDecimal> map1 = new HashMap<>();
        map1.put(Month.M1, BigDecimal.valueOf(150));
        map1.put(Month.M2, BigDecimal.valueOf(150));
        map1.put(Month.M3, BigDecimal.valueOf(150));
        map1.put(Month.M4, BigDecimal.valueOf(150));
        map1.put(Month.M5, BigDecimal.valueOf(150));
        map1.put(Month.M6, BigDecimal.valueOf(1500));
        map1.put(Month.M7, BigDecimal.valueOf(150));
        map1.put(Month.M8, BigDecimal.valueOf(150));
        map1.put(Month.M9, BigDecimal.valueOf(150));
        map1.put(Month.M10, BigDecimal.valueOf(1500));
        map1.put(Month.M11, BigDecimal.valueOf(150));
        map1.put(Month.M12, BigDecimal.valueOf(1050));
        row1.setMonthColumns(map1);
        rows.add(row1);
        ReportTableRow row2 = new ReportTableRow("2-2-1", "伙食費");
        Map<Month, BigDecimal> map2 = new HashMap<>();
        map2.put(Month.M1, BigDecimal.valueOf(150));
        map2.put(Month.M2, BigDecimal.valueOf(150));
        map2.put(Month.M3, BigDecimal.valueOf(150));
        map2.put(Month.M4, BigDecimal.valueOf(150));
        map2.put(Month.M5, BigDecimal.valueOf(150));
        map2.put(Month.M6, BigDecimal.valueOf(1500));
        map2.put(Month.M7, BigDecimal.valueOf(150));
        map2.put(Month.M8, BigDecimal.valueOf(150));
        map2.put(Month.M9, BigDecimal.valueOf(150));
        map2.put(Month.M10, BigDecimal.valueOf(1500));
        map2.put(Month.M11, BigDecimal.valueOf(150));
        map2.put(Month.M12, BigDecimal.valueOf(1050));
        row2.setMonthColumns(map2);
        rows.add(row2);

        Map<Month, BigDecimal> totalPay = new ReportTablePay().totalPay(rows);
        System.out.println(totalPay);
    }

    public void setRows(List<ReportTableRow> rows) {
        this.rows = rows;
    }

    public void setTotal(Map<Month, BigDecimal> total) {
        this.total = total;
    }

    public List<ReportTableRow> getRows() {
        return rows;
    }

    public Map<Month, BigDecimal> getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "ReportTablePay [rows=" + rows + ", total=" + total + "]";
    }

}
