package infrastructure.model;

import domain.model.dto.Member;
import infrastructure.model.po.MemberPo;

/**
 * [DataConverter]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
public class DataConverter {

    public static Member toDto(MemberPo po) {
        return new Member()
                .setId(po.getId())
                .setName(po.getName())
                .setEmail(po.getEmail())
                .setPhone(po.getPhone());
    }
}
