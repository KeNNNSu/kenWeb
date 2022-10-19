package application.model.report;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.model.enums.Month;

/**
 * <p>
 * [收入]
 * </p>
 * 
 * @author ken
 * @since 2022/06/15
 */
public class ReportTableIncome {

    private List<ReportTableRow> rows;
    private Map<Month, BigDecimal> total;

    private ReportTableIncome() {
        super();
    }

    public ReportTableIncome(List<ReportTableRow> rows) {
        this();
        this.rows = rows;
        this.total = totalIncome(rows);
    }

    private Map<Month, BigDecimal> totalIncome(List<ReportTableRow> rows) {
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
        return "ReportTableIncome [rows=" + rows + ", total=" + total + "]";
    }

}
