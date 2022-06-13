package infrastructure.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import infrastructure.model.po.ReportGroupByCredit;
import infrastructure.model.po.ReportGroupByDebit;

/**
 * <p>
 * [SubjectDaoImpl]
 * </p>
 * 
 * @author ken
 * @since 2022/05/24
 */
@Repository
public class ReportDaoImpl implements ReportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ReportGroupByDebit> findDebitAll() {
        String sql = "SELECT * FROM report_groupby_debit";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ReportGroupByDebit.class));
    }

    @Override
    public List<ReportGroupByCredit> findCreditAll() {
        String sql = "SELECT * FROM report_groupby_credit";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ReportGroupByCredit.class));
    }

}
