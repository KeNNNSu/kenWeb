package application.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.dao.SubjectDao;
import domain.model.dto.Subject;
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

    public List<ReportGroupByDebit> findDebitAll() {
        return reportDao.findDebitAll();
    }

    public List<ReportGroupByCredit> findCreditAll() {
        return reportDao.findCreditAll();
    }

    public List<ReportGroupByCredit> findByIncome() {
        return findCreditAll().stream()
                .filter(data -> data.getCode().startsWith("2-1"))
                .collect(Collectors.toList());
    }

    public List<ReportGroupByDebit> findByPay() {
        return findDebitAll().stream()
                .filter(data -> data.getCode().startsWith("2-2"))
                .collect(Collectors.toList());
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

    public static class PayObject {
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
}
