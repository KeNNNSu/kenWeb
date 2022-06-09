package application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.VoConverter;
import application.model.vo.SubjectVo;
import domain.dao.SubjectDao;

/**
 * <p>
 * [AccSServise]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/24
 */
@Service
public class SubjectService {

    @Autowired
    private SubjectDao subjectDao;
    
    public List<SubjectVo> findAll() {
        return subjectDao.findAll().stream()
                .map(VoConverter::toVo)
                .collect(Collectors.toList());
    }
}
