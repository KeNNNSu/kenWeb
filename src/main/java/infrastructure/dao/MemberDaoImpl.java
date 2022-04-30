package infrastructure.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.dao.MemberDao;
import domain.model.dto.Member;
import infrastructure.model.DataConverter;
import infrastructure.model.po.MemberPo;

/**
 * [MemberDaoImpl]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Member> findAll() {
        String sql = "SELECT * FROM MEMBERS";
        List<MemberPo> poList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MemberPo.class));
        return poList.stream()
                .map(po -> DataConverter.toDto(po))
                .collect(Collectors.toList());
    }

}
