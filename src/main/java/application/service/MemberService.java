package application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.VoConverter;
import application.model.vo.MemberVo;
import domain.dao.MemberDao;

/**
 * [MemberService]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public List<MemberVo> findAll() {
        return memberDao.findAll().stream()
//              .map(dto -> VoConverter.toVo(dto))
                .map(VoConverter::toVo)
                .collect(Collectors.toList());
    }
}
