package infrastructure.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.dao.JournalBookDao;
import domain.dao.SubjectDao;
import domain.model.dto.JournalBook;
import domain.model.dto.Subject;
import infrastructure.model.DataConverter;
import infrastructure.model.po.JournalBookPo;

/**
 * <p>
 * [JournalBookDaoImpl]
 * </p>
 * 
 * @author ken
 * @since 2022/05/24
 */
@Repository
public class JournalBookDaoImpl implements JournalBookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<JournalBook> findAll() {
        List<Subject> subjects = subjectDao.findAll();
        String sql = "SELECT * FROM ACC_JOURNALS";
        List<JournalBookPo> poList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JournalBookPo.class));
        return poList.stream().map(po -> DataConverter.toDto(po, subjects)).collect(Collectors.toList());
    }

    @Override
    public boolean add(JournalBook journalBook) {
        String sql = "INSERT INTO ACC_JOURNALS (ID, TIME_DATE,DEBIT,CREDIT,AMOUNT,ITEM,PLACE,WHO,A_ID,TIME_BUILD,TIME_MODIFY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        List<Object> objList = new ArrayList<>();
        objList.add(this.findNextId());
        objList.add(journalBook.getRecordDate());
        objList.add(journalBook.getDebit().getId());
        objList.add(journalBook.getCredit().getId());
        objList.add(journalBook.getAmount());
        objList.add(journalBook.getItem());
        objList.add(journalBook.getPlace());
        objList.add(journalBook.getWho());
        objList.add(journalBook.getAccountId());
        objList.add(new Date());
        objList.add(new Date());
        Object[] values = objList.toArray(new Object[objList.size()]);
        int result = jdbcTemplate.update(sql, values);
        return (result == 1);
    }

    @Override
    public boolean modify(Long journalBookId, JournalBook journalBook) {
        String sql = "UPDATE ACC_JOURNALS SET TIME_DATE = ? , DEBIT =? , CREDIT = ? , AMOUNT = ? , ITEM =? , PLACE = ? , WHO = ? WHERE ID = ?";
        List<Object> objList = new ArrayList<>();
        objList.add(journalBook.getRecordDate());
        objList.add(journalBook.getDebit().getId());
        objList.add(journalBook.getCredit().getId());
        objList.add(journalBook.getAmount());
        objList.add(journalBook.getItem());
        objList.add(journalBook.getPlace());
        objList.add(journalBook.getWho());
        objList.add(journalBookId);
        Object[] values = objList.toArray(new Object[objList.size()]);
        int result = jdbcTemplate.update(sql, values);
        return (result == 1);
    }

    @Override
    public boolean remove(Long journalBookId) {
        String sql = "DELETE FROM ACC_JOURNALS WHERE ID = ?";
        List<Object> objList = new ArrayList<>();
        objList.add(journalBookId);
        Object[] values = objList.toArray(new Object[objList.size()]);
        int result = jdbcTemplate.update(sql, values);
        return (result == 1);
    }

    @Override
    public Long findNextId() {
        JournalBook maxIdPo = findAll().stream()
                .max(Comparator.comparing(JournalBook::getId)).get();
        return maxIdPo.getId() + 1L;
    }

    @Override
    public JournalBook findLatest() {
        List<JournalBook> journalBooks = findAll();
        journalBooks = journalBooks.stream()
            .sorted(Comparator.comparing(JournalBook::getTimeBuild).reversed())
            .collect(Collectors.toList());
        return journalBooks.get(0);
    }

    @Override
    public JournalBook findById(Long journalBookId) {
        return findAll().stream()
                .filter(j -> j.getId() - journalBookId == 0)
                .findAny().get();
    }

}
