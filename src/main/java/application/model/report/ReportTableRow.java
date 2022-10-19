package application.model.report;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import application.model.enums.Month;

/**
 * <p>
 * [每行 sujbect 資料]
 * </p>
 * 
 * @author ken
 * @since 2022/06/15
 */
public class ReportTableRow {

    private String code;
    private String subjectName;
    private Map<Month, BigDecimal> monthColumns;

    private ReportTableRow() {
        super();
    }

    public ReportTableRow(String code, String subjectName) {
        this();
        this.code = code;
        this.subjectName = subjectName;
        this.monthColumns = new HashMap<>();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setMonthColumns(Map<Month, BigDecimal> monthColumns) {
        this.monthColumns = monthColumns;
    }

    public String getCode() {
        return code;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Map<Month, BigDecimal> getMonthColumns() {
        return monthColumns;
    }

    @Override
    public String toString() {
        return "ReportTableRow [code=" + code + ", subjectName=" + subjectName + ", monthColumns=" + monthColumns + "]";
    }

}
