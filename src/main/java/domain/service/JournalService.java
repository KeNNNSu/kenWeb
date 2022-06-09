package domain.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.dao.CashBookDao;
import domain.dao.JournalBookDao;
import domain.model.dto.CashBook;
import domain.model.dto.JournalBook;

/**
 * <p>
 * [日記帳 Service]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
@Service
public class JournalService {

    private static Logger logger = LogManager.getLogger(JournalService.class);

    @Autowired
    private JournalBookDao journalBookDao;

    @Autowired
    private CashBookDao cashBookDao;

    // 新增資料
    public boolean add(JournalBook journalBook) {
        try {
            // 1 新增日記帳
            journalBookDao.add(journalBook);
            // 2 重新查出 journalBook 的 ID
            Long journalBookId = journalBookDao.findLatest().getId();
            journalBook.setId(journalBookId);
            // 3 有現金, 就要新增現金帳
            if (journalBook.getIncludeCashOfSubject().isIncludeCash())
                cashBookDao.add(CashBook.from(journalBook));
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new IllegalArgumentException("出現不明異常!!");
        }
    }

    // 修改資料
    public boolean modify(Long journalBookId , JournalBook journalBook) {
        JournalBook oldJournalBook = journalBookDao.findById(journalBookId);
        //檢查
        if (journalBook == null)
            throw new IllegalArgumentException(journalBookId + " 查無此資料!!");
        //更改資料
        journalBook.setId(oldJournalBook.getId());
        journalBook.setAccountId(oldJournalBook.getAccountId());
        return journalBookDao.modify(journalBookId, journalBook);
    }
    
    // 刪除資料
    public boolean remove(Long journalBookId) {
        boolean result = true;
        JournalBook journalBook = journalBookDao.findById(journalBookId);
        if (journalBook.getIncludeCashOfSubject().isIncludeCash())
            result = result & cashBookDao.remove(journalBookId);
        return result & journalBookDao.remove(journalBookId);
    }

    // 查詢資料
    public List<JournalBook> findAllOfJournalBook() {
        return journalBookDao.findAll();
    }
}
