package application.model;

import application.model.data.Person;
import application.model.vo.MemberVo;
import domain.model.dto.Member;

/**
 * [VoConverter]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
public class VoConverter {

    public static MemberVo toVo(Member dto) {
        Person person = new Person(dto.getName());
        if (dto.getEmail().isPresent())
            person.setEmail(dto.getEmail().get());
        if (dto.getPhone().isPresent())
            person.setPhone(dto.getPhone().get());
        return new MemberVo().setId(dto.getId() + "").setPerson(person);
    }
}
