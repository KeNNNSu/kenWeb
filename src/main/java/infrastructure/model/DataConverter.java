package infrastructure.model;

import java.util.List;

import domain.enums.AccountStatus;
import domain.model.dto.Account;
import domain.model.dto.JournalBook;
import domain.model.dto.Member;
import domain.model.dto.Subject;
import infrastructure.model.po.SubjectPo;
import infrastructure.model.po.AccountPo;
import infrastructure.model.po.JournalBookPo;
import infrastructure.model.po.MemberPo;

/**
 * [DataConverter]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
public class DataConverter {

    public static JournalBook toDto(JournalBookPo po, List<Subject> subjects) {
        Subject debit = null;
        Subject credit = null;
        for (Subject subject : subjects) {
            if (po.getDebit().equals(subject.getId()))
                debit = subject;
            if (po.getCredit().equals(subject.getId()))
                credit = subject;
        }
        Long accountId = 1L;
        return JournalBook.findOf(
                po.getId(),
                po.getTimeDate(),
                debit,
                credit,
                po.getAmount(),
                po.getItem(),
                accountId)
                .setPlace(po.getPlace())
                .setWho(po.getWho())
                .setTimeBuild(po.getTimeBuild())
                .setTimeModify(po.getTimeModify());
    }

    public static Member toDto(MemberPo po) {
        return new Member()
                .setId(po.getId())
                .setName(po.getName())
                .setEmail(po.getEmail())
                .setPhone(po.getPhone());
    }

    public static Account toDto(AccountPo po) {
        return new Account()
                .setId(po.getId())
                .setAccount(po.getAccount())
                .setPassword(po.getPassword())
                .setAccountStatus(AccountStatus.of(po.getStatus()));
    }

    public static Subject toDto(SubjectPo po) {
        return new Subject()
                .setId(po.getId())
                .setCode(po.getCode())
                .setName(po.getName());
    }
}
