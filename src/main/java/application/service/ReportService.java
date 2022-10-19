package application.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.enums.Month;
import application.model.report.ReportTable;
import application.model.report.ReportTableIncome;
import application.model.report.ReportTablePay;
import application.model.report.ReportTableRow;
import application.model.vo.DonutChartIncome;
import application.model.vo.DonutChartIncome.DonutChartIncomeData;
import application.model.vo.DonutChartPay;
import application.model.vo.DonutChartPay.DonutChartPayData;
import domain.dao.SubjectDao;
import domain.model.dto.JournalBook;
import domain.model.dto.Subject;
import domain.service.JournalService;
import infrastructure.dao.ReportDao;
import infrastructure.model.po.ReportGroupByCredit;
import infrastructure.model.po.ReportGroupByDebit;

/**
 * <p>
 * [報表 Service]
 * </p>
 * 
 * @author ken
 * @since 2022/06/13
 */
@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private JournalService journalService;

    public List<ReportGroupByDebit> findDebitAll() {
        return reportDao.findDebitAll();
    }

    public List<ReportGroupByCredit> findCreditAll() {
        return reportDao.findCreditAll();
    }

    public List<List<Object>> findByIncome() {
        List<ReportGroupByCredit> list = findCreditAll().stream()
                .filter(data -> data.getCode().startsWith("2-1"))
                .collect(Collectors.toList());
        return parseDonutChartIncome(list).transforModel();
    }

    public List<List<Object>> findByPay() {
        List<ReportGroupByDebit> list = findDebitAll().stream()
                .filter(data -> data.getCode().startsWith("2-2"))
                .collect(Collectors.toList());
        return parseDonutChartPay(list).transforModel();
    }

    public PayObject findAllToPayObject() {
        List<ReportGroupByDebit> list = findDebitAll().stream()
                .filter(data -> data.getCode().startsWith("2-2"))
                .collect(Collectors.toList());
        Map<String, Subject> mainItem = new HashMap<>();
        for (ReportGroupByDebit data : list) {
            // code 2-1-1-2
            // index 0123456
            mainItem.put(data.getCode().substring(0, 5), null);
        }
        mainItem = getAllSubject(mainItem);
        return new PayObject(mainItem, list);
    }

    private Map<String, Subject> getAllSubject(Map<String, Subject> mainItem) {
        List<Subject> subjects = subjectDao.findAll();
        for (String code : mainItem.keySet()) {
            for (Subject subject : subjects) {
                if (subject.getCode().equals(code)) {
                    mainItem.put(code, subject);
                }
            }
        }
        return mainItem;
    }

    private static class PayObject {
        Map<String, Subject> mainItem;
        List<ReportGroupByDebit> reportGroupByDebits;

        public PayObject(Map<String, Subject> mainItem, List<ReportGroupByDebit> reportGroupByDebits) {
            super();
            this.mainItem = mainItem;
            this.reportGroupByDebits = reportGroupByDebits;
        }

        public List<ReportGroupByDebit> getListByMainItem() {
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String code : mainItem.keySet()) {
                map.put(code, 0);
            }
            for (String code : map.keySet()) {
                for (ReportGroupByDebit data : reportGroupByDebits) {
                    if (data.getCode().startsWith(code)) {
                        int total = map.get(code) + data.getSubtotal();
                        map.put(code, total);
                    }
                }
            }

            List<ReportGroupByDebit> reportGroupByDebits = new ArrayList<>();
            for (String code : map.keySet()) {
                ReportGroupByDebit data = new ReportGroupByDebit();
                data.setDebit(mainItem.get(code).getName());
                data.setSubtotal(map.get(code));
                reportGroupByDebits.add(data);
            }
            return reportGroupByDebits;
        }

        public Map<String, Subject> getMainItem() {
            return mainItem;
        }

        public List<ReportGroupByDebit> getReportGroupByDebits() {
            return reportGroupByDebits;
        }
    }

    private DonutChartIncome parseDonutChartIncome(List<ReportGroupByCredit> reportGroupByCredits) {
        List<DonutChartIncomeData> donutChartDatas = reportGroupByCredits.stream()
                .map(data -> parseDonutChartIncomeData(data))
                .collect(Collectors.toList());
        return new DonutChartIncome(donutChartDatas);
    }

    private DonutChartPay parseDonutChartPay(List<ReportGroupByDebit> reportGroupByDebits) {
        List<DonutChartPayData> donutChartDatas = reportGroupByDebits.stream()
                .map(data -> parseDonutChartPayData(data))
                .collect(Collectors.toList());
        return new DonutChartPay(donutChartDatas);
    }

    private DonutChartPay parseDonutChartPayOfPayObject(PayObject payObject) {
        List<DonutChartPayData> donutChartDatas = payObject.getListByMainItem().stream()
                .map(data -> parseDonutChartPayData(data))
                .collect(Collectors.toList());
        return new DonutChartPay(donutChartDatas);
    }

    private DonutChartIncomeData parseDonutChartIncomeData(ReportGroupByCredit reportGroupByCredit) {
        return new DonutChartIncomeData(reportGroupByCredit.getCredit(), reportGroupByCredit.getSubtotal());
    }

    private DonutChartPayData parseDonutChartPayData(ReportGroupByDebit reportGroupByDebit) {
        return new DonutChartPayData(reportGroupByDebit.getDebit(), reportGroupByDebit.getSubtotal());
    }

    private void processIncomeData(String targetCode, List<JournalBook> journalBooks, List<Long> lastIds,
            List<DonutChartIncomeData> dataList) {
        List<JournalBook> codes = new ArrayList<>();
        // 分類
        for (JournalBook journalBook : journalBooks) {
            if (targetCode.equals(journalBook.getCredit().getCode())) {
                lastIds.remove(journalBook.getId());
                codes.add(journalBook);
            }
        }
        Optional<DonutChartIncomeData> incomeDatas = toDonutChartIncomeData(codes);
        if (incomeDatas.isPresent())
            dataList.add(incomeDatas.get());
    }

    private void processIncomeOtherData(List<JournalBook> journalBooks, List<Long> lastIds,
            List<DonutChartIncomeData> dataList) {
        List<JournalBook> codes = new ArrayList<>();
        for (JournalBook journalBook : journalBooks) {
            for (Long id : lastIds) {
                if (id.compareTo(journalBook.getId()) == 0) {
                    codes.add(journalBook);
                }
            }
        }
        Optional<DonutChartIncomeData> otherDatas = toDonutChartIncomeData(codes);
        if (otherDatas.isPresent())
            dataList.add(otherDatas.get());
    }

    private DonutChartIncome getDonutChartIncome() {
        List<JournalBook> journalBooks = journalService.findAllOfJournalBook().stream()
                .filter(jb -> jb.getCredit().getCode().startsWith("2-1"))
                .collect(Collectors.toList());

        List<Long> lastIds = new ArrayList<>();
        for (JournalBook journalBook : journalBooks) {
            lastIds.add(journalBook.getId());
        }

        List<DonutChartIncomeData> dataList = new ArrayList<>();
        processIncomeData("2-1-1-1", journalBooks, lastIds, dataList);
        processIncomeData("2-1-1-2", journalBooks, lastIds, dataList);
        processIncomeData("2-1-1-3", journalBooks, lastIds, dataList);
        processIncomeData("2-1-1-4", journalBooks, lastIds, dataList);
        processIncomeOtherData(journalBooks, lastIds, dataList);

//        List<String> codes = Arrays.asList("2-1-1-1", "2-1-1-2", "2-1-1-3", "2-1-1-4");
//        List<JournalBook> code2111 = new ArrayList<>();
//        List<JournalBook> code2112 = new ArrayList<>();
//        List<JournalBook> code2113 = new ArrayList<>();
//        List<JournalBook> code2114 = new ArrayList<>();
//        List<JournalBook> others = new ArrayList<>();
//        for (JournalBook journalBook : journalBooks) {
//            if (codes.get(0).equals(journalBook.getCredit().getCode())) {
//                code2111.add(journalBook);
//            }
//            if (codes.get(1).equals(journalBook.getCredit().getCode())) {
//                code2112.add(journalBook);
//            }
//            if (codes.get(2).equals(journalBook.getCredit().getCode())) {
//                code2113.add(journalBook);
//            }
//            if (codes.get(3).equals(journalBook.getCredit().getCode())) {
//                code2114.add(journalBook);
//            }
//            others.add(journalBook);
//        }
//
////        List<DonutChartIncomeData> dataList = new ArrayList<>();
////        dataList.add(new DonutChartIncomeData("Work", 11));
////        dataList.add(new DonutChartIncomeData("Eat", 2));
////        dataList.add(new DonutChartIncomeData("Commute", 2));
////        dataList.add(new DonutChartIncomeData("Watch TV", 2));
////        dataList.add(new DonutChartIncomeData("Sleep", 7));
//
//        Optional<DonutChartIncomeData> incomeData2111 = toDonutChartIncomeData(code2111);
//        Optional<DonutChartIncomeData> incomeData2112 = toDonutChartIncomeData(code2112);
//        Optional<DonutChartIncomeData> incomeData2113 = toDonutChartIncomeData(code2113);
//        Optional<DonutChartIncomeData> incomeData2114 = toDonutChartIncomeData(code2114);
//        Optional<DonutChartIncomeData> incomeDataOthers = toDonutChartIncomeData(others);
//        if (incomeData2111.isPresent())
//            dataList.add(incomeData2111.get());
//        if (incomeData2112.isPresent())
//            dataList.add(incomeData2112.get());
//        if (incomeData2113.isPresent())
//            dataList.add(incomeData2113.get());
//        if (incomeData2114.isPresent())
//            dataList.add(incomeData2114.get());
//        if (incomeDataOthers.isPresent())
//            dataList.add(incomeDataOthers.get());
        return new DonutChartIncome(dataList);

    }

    private Optional<DonutChartIncomeData> toDonutChartIncomeData(List<JournalBook> journalBooks) {
        if (journalBooks.size() == 0) {
            return Optional.empty();
        }
        String text = journalBooks.get(0).getCredit().getName();
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (JournalBook journalBook : journalBooks) {
            totalAmount = totalAmount.add(journalBook.getAmount());
        }
        return Optional.of(new DonutChartIncomeData(text, totalAmount.intValue()));
    }

    private DonutChartPay getDonutChartPay() {
        List<JournalBook> journalBooks = journalService.findAllOfJournalBook().stream()
                .filter(jb -> jb.getDebit().getCode().startsWith("2-2"))
                .collect(Collectors.toList());

        List<String> codes = Arrays.asList("2-2-1", "2-2-2", "2-2-3", "2-2-4", "2-2-5", "2-2-6");
        List<JournalBook> code221 = new ArrayList<>();
        List<JournalBook> code222 = new ArrayList<>();
        List<JournalBook> code223 = new ArrayList<>();
        List<JournalBook> code224 = new ArrayList<>();
        List<JournalBook> code225 = new ArrayList<>();
        List<JournalBook> code226 = new ArrayList<>();
        List<JournalBook> others = new ArrayList<>();
        for (JournalBook journalBook : journalBooks) {
            if (journalBook.getDebit().getCode().startsWith(codes.get(0))) {
                code221.add(journalBook);
            }
            if (journalBook.getDebit().getCode().startsWith(codes.get(1))) {
                code222.add(journalBook);
            }
            if (journalBook.getDebit().getCode().startsWith(codes.get(2))) {
                code223.add(journalBook);
            }
            if (journalBook.getDebit().getCode().startsWith(codes.get(3))) {
                code224.add(journalBook);
            }
            if (journalBook.getDebit().getCode().startsWith(codes.get(4))) {
                code225.add(journalBook);
            }
            if (journalBook.getDebit().getCode().startsWith(codes.get(5))) {
                code226.add(journalBook);
            }
            others.add(journalBook);
        }

        List<DonutChartPayData> dataList = new ArrayList<>();
//        dataList.add(new DonutChartPayData("Watch TV", 3));
//        dataList.add(new DonutChartPayData("Work", 6));
//        dataList.add(new DonutChartPayData("Sleep", 8));
//        dataList.add(new DonutChartPayData("Eat", 5));
//        dataList.add(new DonutChartPayData("Commute", 4));

        // sorted
        code221 = code221.stream()
                .sorted((jb1, jb2) -> jb1.getDebit().getCode().hashCode() - jb2.getDebit().getCode().hashCode())
                .collect(Collectors.toList());
        code222 = code222.stream()
                .sorted((jb1, jb2) -> jb1.getDebit().getCode().hashCode() - jb2.getDebit().getCode().hashCode())
                .collect(Collectors.toList());
        code223 = code223.stream()
                .sorted((jb1, jb2) -> jb1.getDebit().getCode().hashCode() - jb2.getDebit().getCode().hashCode())
                .collect(Collectors.toList());
        code224 = code224.stream()
                .sorted((jb1, jb2) -> jb1.getDebit().getCode().hashCode() - jb2.getDebit().getCode().hashCode())
                .collect(Collectors.toList());
        code225 = code225.stream()
                .sorted((jb1, jb2) -> jb1.getDebit().getCode().hashCode() - jb2.getDebit().getCode().hashCode())
                .collect(Collectors.toList());
        code226 = code226.stream()
                .sorted((jb1, jb2) -> jb1.getDebit().getCode().hashCode() - jb2.getDebit().getCode().hashCode())
                .collect(Collectors.toList());
        others = others.stream()
                .sorted((jb1, jb2) -> jb1.getDebit().getCode().hashCode() - jb2.getDebit().getCode().hashCode())
                .collect(Collectors.toList());

        Optional<DonutChartPayData> payData221 = toDonutChartPayData(code221);
        Optional<DonutChartPayData> payData222 = toDonutChartPayData(code222);
        Optional<DonutChartPayData> payData223 = toDonutChartPayData(code223);
        Optional<DonutChartPayData> payData224 = toDonutChartPayData(code224);
        Optional<DonutChartPayData> payData225 = toDonutChartPayData(code225);
        Optional<DonutChartPayData> payData226 = toDonutChartPayData(code226);
        Optional<DonutChartPayData> payDataOthers = toDonutChartPayData(others);
        if (payData221.isPresent())
            dataList.add(payData221.get());
        if (payData222.isPresent())
            dataList.add(payData222.get());
        if (payData223.isPresent())
            dataList.add(payData223.get());
        if (payData224.isPresent())
            dataList.add(payData224.get());
        if (payData225.isPresent())
            dataList.add(payData225.get());
        if (payData226.isPresent())
            dataList.add(payData226.get());
        if (payDataOthers.isPresent())
            dataList.add(payDataOthers.get());
        return new DonutChartPay(dataList);

    }

    private Optional<DonutChartPayData> toDonutChartPayData(List<JournalBook> journalBooks) {
        if (journalBooks.size() == 0) {
            return Optional.empty();
        }
        String text = journalBooks.get(0).getDebit().getName();
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (JournalBook journalBook : journalBooks) {
            totalAmount = totalAmount.add(journalBook.getAmount());
        }
        return Optional.of(new DonutChartPayData(text, totalAmount.intValue()));
    }

    public ReportTable getReportTable() {
        return new ReportTable(getReportTableIncome(), getReportTablePay());
    }
    
    public ReportTableIncome getReportTableIncome() {
    List<Subject> subjects = subjectDao.findAll().stream()
            .filter(sj -> sj.getCode().startsWith("2-1"))
            .collect(Collectors.toList());
    List<ReportTableRow> rows = new ArrayList<>();
    for (Subject subject : subjects) {
        ReportTableRow row = getReportTableRowCredit(subject);
        rows.add(row);
    }
    return new ReportTableIncome(rows);
    }
    public ReportTablePay getReportTablePay() {
        List<Subject> subjects = subjectDao.findAll().stream()
                .filter(sj -> sj.getCode().startsWith("2-2"))
                .collect(Collectors.toList());
        List<ReportTableRow> rows = new ArrayList<>();
        for (Subject subject : subjects) {
            ReportTableRow row = getReportTableRowDebit(subject);
            rows.add(row);
        }
        return new ReportTablePay(rows);
    }

    public ReportTableRow getReportTableRowDebit(Subject subject) {
        ReportTableRow row = new ReportTableRow(subject.getCode(), subject.getName());
        Map<Month, BigDecimal> monthColumnsMap = new EnumMap<>(Month.class);
        for (Month month : Month.values()) {
            monthColumnsMap.put(month, BigDecimal.ZERO);
        }

        List<JournalBook> journalBooks = journalService.findAllOfJournalBook();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        for (JournalBook book : journalBooks) {
            if (!book.getDebit().getCode().equals(subject.getCode())) {
                continue;
            }
            int monthValue = Integer.parseInt(sdf.format(book.getRecordDate()));
            Month month = Month.of(monthValue);
            BigDecimal sum = monthColumnsMap.get(month).add(book.getAmount());
            monthColumnsMap.put(month, sum);
        }

        row.setMonthColumns(monthColumnsMap);
        return row;
    }

    public ReportTableRow getReportTableRowCredit(Subject subject) {
        ReportTableRow row = new ReportTableRow(subject.getCode(), subject.getName());
        Map<Month, BigDecimal> monthColumnsMap = new EnumMap<>(Month.class);
        for (Month month : Month.values()) {
            monthColumnsMap.put(month, BigDecimal.ZERO);
        }

        List<JournalBook> journalBooks = journalService.findAllOfJournalBook();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        for (JournalBook book : journalBooks) {
            if (!book.getCredit().getCode().equals(subject.getCode())) {
                continue;
            }
            int monthValue = Integer.parseInt(sdf.format(book.getRecordDate()));
            Month month = Month.of(monthValue);
            BigDecimal sum = monthColumnsMap.get(month).add(book.getAmount());
            monthColumnsMap.put(month, sum);
        }

        row.setMonthColumns(monthColumnsMap);
        return row;
    }
}
