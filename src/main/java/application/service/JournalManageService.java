package application.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.controller.JournalController;
import application.model.req.JournalAddReq;
import application.model.req.JournalModifyReq;
import application.model.req.JournalRemoveReq;
import application.model.vo.JournalVo;
import domain.dao.SubjectDao;
import domain.model.dto.IncludeCashOfSubject;
import domain.model.dto.JournalBook;
import domain.model.dto.Subject;
import domain.service.JournalService;

/**
 * <p>
 * [JournalManageService]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
@Service
public class JournalManageService {

    private static Logger logger = LogManager.getLogger(JournalManageService.class);

    @Autowired
    private JournalService journalService;

    @Autowired
    private SubjectDao subjectDao;

    public List<JournalVo> findAll() {
        List<JournalVo> vos = new ArrayList<>();
        List<JournalBook> journalBooks = journalService.findAllOfJournalBook();
        for (JournalBook journalBook : journalBooks)
            vos.add(of(journalBook));
        return vos;
    }

    private JournalVo of(JournalBook journalBook) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return new JournalVo()
                .setJournalBookId(journalBook.getId())
                .setDate(sdf.format(journalBook.getRecordDate()))
                .setDebitCode(journalBook.getDebit().getCode())
                .setDebit(journalBook.getDebit().getName())
                .setCreditCode(journalBook.getCredit().getCode())
                .setCredit(journalBook.getCredit().getName())
                .setPlusOrMinusSign(checkPlusOrMinusSign(journalBook.getIncludeCashOfSubject()))
                .setAmount(journalBook.getAmount())
                .setItem(journalBook.getItem())
                .setPlace(journalBook.getPlace())
                .setWho(journalBook.getWho())
                .setAccountName("ken")
                .setTimeModify(sdf.format(journalBook.getTimeModify()));
    }

    private String checkPlusOrMinusSign(IncludeCashOfSubject includeCashOfSubject) {
        if (includeCashOfSubject.isIncludeCashOfDebit())
            return "+";
        if (includeCashOfSubject.isIncludeCashOfCredit())
            return "-";
        return "";
    }

    public boolean add(JournalAddReq journalAddReq) {
        JournalBook journalBook = toDto(journalAddReq);
        return journalService.add(journalBook);
    }

    public boolean modify(JournalModifyReq journalModifyReq) {
        JournalBook journalBook = toDto(journalModifyReq);
        // 修改前有現金, 修改後有現金
        // 修改前沒有現金, 修改後沒有現金
        // 修改前有現金, 修改後沒有現金
        // 修改前沒有現金, 修改後有現金
        // -> 修改 CashBook
        return journalService.modify(journalModifyReq.getJournalBookId(), journalBook);
    }

    private JournalBook toDto(JournalAddReq journalAddReq) {
        try {
            Date recordDate = new SimpleDateFormat("yyyy-MM-dd").parse(journalAddReq.getRecordDate());
            Subject debit = fromCode(journalAddReq.getCodeOfDebit());
            Subject credit = fromCode(journalAddReq.getCodeOfCredit());
            return JournalBook.addOf(recordDate, debit, credit, journalAddReq.getAmount(), journalAddReq.getItem(),
                    journalAddReq.getAccountId())
                    .setPlace(journalAddReq.getPlace())
                    .setWho(journalAddReq.getWho());
        } catch (ParseException e) {
            throw new IllegalArgumentException("recordDate 轉換錯誤!!");
        }
    }

    private JournalBook toDto(JournalModifyReq journalModifyReq) {
        try {
            Date recordDate = new SimpleDateFormat("yyyy-MM-dd").parse(journalModifyReq.getRecordDate());
            Subject debit = fromCode(journalModifyReq.getCodeOfDebit());
            Subject credit = fromCode(journalModifyReq.getCodeOfCredit());
            return JournalBook.modifyOf(recordDate, debit, credit, journalModifyReq.getAmount(), journalModifyReq.getItem())
                    .setPlace(journalModifyReq.getPlace())
                    .setWho(journalModifyReq.getWho());
        } catch (ParseException e) {
            throw new IllegalArgumentException("recordDate 轉換錯誤!!");
        }
    }

    private Subject fromCode(String code) {
        List<Subject> subjects = subjectDao.findAll();
        return subjects.stream().filter(subject -> subject.getCode().equals(code)).findAny().get();
    }

    public boolean remove(String journalBookIdStr) {
        Long journalBookId = Long.parseLong(journalBookIdStr);
        return journalService.remove(journalBookId);
    }
}
