package domain.dao;

import java.util.List;

import domain.model.dto.Subject;

/**
 * <p>
 * [SubjectDao]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/24
 */
public interface SubjectDao {
    
    public List<Subject> findAll();

}
