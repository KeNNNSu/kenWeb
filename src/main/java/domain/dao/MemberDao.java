package domain.dao;

import java.util.List;

import domain.model.dto.Member;

/**
 * [MemberDao]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
public interface MemberDao {

    public List<Member> findAll();
}
