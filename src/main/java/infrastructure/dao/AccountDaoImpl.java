package infrastructure.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.dao.AccountDao;
import domain.model.dto.Account;
import infrastructure.model.DataConverter;
import infrastructure.model.po.AccountPo;


/**
 * <p>
 * [AccountDaoImpl] 實作
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/01
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAll() {
        String sql = "SELECT * FROM ACCOUNTS";
        List<AccountPo> poList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AccountPo.class));
        return poList.stream()
                .map(po -> DataConverter.toDto(po))
                .collect(Collectors.toList());
    }
    }


