package application.model;

import application.model.data.Person;
import application.model.vo.SubjectVo;
import application.model.vo.AccountVo;
import application.model.vo.MemberVo;
import domain.model.dto.Subject;
import domain.model.dto.Account;
import domain.model.dto.Member;

/**
 * [VoConverter-轉換器] 有問題
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
    
    public static AccountVo toAVo(Account dto) {
        AccountVo accountVo = new AccountVo();
        accountVo.setId(dto.getId());
        accountVo.setAccount(dto.getAccount());
        accountVo.setPassword(dto.getPassword());
        accountVo.setStatus(dto.getAccountStatus().getComment());
        return accountVo;
    }
    
    public static SubjectVo toVo(Subject dto) {
        SubjectVo subjectVo = new SubjectVo();
        subjectVo.setId(dto.getId());
        subjectVo.setCode(dto.getCode());
        subjectVo.setName(dto.getName());
        return subjectVo;
    }
}
