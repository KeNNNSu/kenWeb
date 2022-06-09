package infrastructure.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.dao.SubjectDao;
import domain.model.dto.Subject;
import infrastructure.model.DataConverter;
import infrastructure.model.po.SubjectPo;


/**
 * <p>
 * [SubjectDaoImpl]
 * </p>
 * 
 * @author ken
 * @since 2022/05/24
 */
@Repository
public class SubjectDaoImpl implements SubjectDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Subject> findAll() {
        String sql = "SELECT * FROM ACC_SUBJECTS";
        List<SubjectPo> poList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SubjectPo.class));
        return poList.stream()
                .map(po -> DataConverter.toDto(po))
                .collect(Collectors.toList());
    }
    

}
