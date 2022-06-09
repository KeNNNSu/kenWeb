package infrastructure.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.dao.CashBookDao;
import domain.dao.JournalBookDao;
import domain.dao.SubjectDao;
import domain.model.dto.CashBook;
import domain.model.dto.JournalBook;
import domain.model.dto.Subject;
import infrastructure.model.DataConverter;
import infrastructure.model.po.JournalBookPo;


/**
 * <p>
 * [CashBookDaoImpl]
 * </p>
 * 
 * @author ken
 * @since 2022/06/01
 */
@Repository
public class CashBookDaoImpl implements CashBookDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CashBook> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(CashBook cashBook) {
        String sql = "INSERT INTO ACC_CASH (JOURNAL_ID, INCREASE, REDUCE, TIME_BUILD, TIME_MODIFY) VALUES (?, ?, ?, ?, ?)";
        List<Object> objList = new ArrayList<>();
        objList.add(cashBook.getJournalId());
        objList.add(cashBook.getIncrease());
        objList.add(cashBook.getReduce());
        objList.add(new Date());
        objList.add(new Date());
        Object[] values = objList.toArray(new Object[objList.size()]);
        int result = jdbcTemplate.update(sql, values);
        return (result == 1);
    }

    @Override
    public boolean modify(Long journalBookId, CashBook cashBook) {
        String sql = "UPDATE ACC_CASH SET INCREASE = ? , REDUCE = ? WHERE JOURNAL_ID = ?";
        List<Object> objList = new ArrayList<>();
        objList.add(cashBook.getIncrease());
        objList.add(cashBook.getReduce());
        objList.add(journalBookId);
        Object[] values = objList.toArray(new Object[objList.size()]);
        int result = jdbcTemplate.update(sql, values);
        return (result == 1);
    }

    @Override
    public boolean remove(Long journalBookId) {
        String sql = "DELETE FROM ACC_CASH WHERE JOURNAL_ID = ?";
        List<Object> objList = new ArrayList<>();
        objList.add(journalBookId);
        Object[] values = objList.toArray(new Object[objList.size()]);
        int result = jdbcTemplate.update(sql, values);
        return (result == 1);
    }

}
