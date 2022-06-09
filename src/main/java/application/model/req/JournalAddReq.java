package application.model.req;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import domain.model.dto.JournalBook;
import domain.model.dto.Subject;

/**
 * <p>
 * [JournalAddReq]
 * </p>
 * 
 * @author ken
 * @since 2022/06/01
 */
public class JournalAddReq {

    private String recordDate;
    private String codeOfDebit;
    private String codeOfCredit;
    private BigDecimal amount;
    private String item;
    private String place;
    private String who;
    private Long accountId;

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public void setCodeOfDebit(String codeOfDebit) {
        this.codeOfDebit = codeOfDebit;
    }

    public void setCodeOfCredit(String codeOfCredit) {
        this.codeOfCredit = codeOfCredit;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public String getCodeOfDebit() {
        return codeOfDebit;
    }

    public String getCodeOfCredit() {
        return codeOfCredit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getItem() {
        return item;
    }

    public String getPlace() {
        return place;
    }

    public String getWho() {
        return who;
    }

    public Long getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "JournalAddReq [recordDate=" + recordDate + ", codeOfDebit=" + codeOfDebit + ", codeOfCredit="
                + codeOfCredit + ", amount=" + amount + ", item=" + item + ", place=" + place + ", who=" + who
                + ", accountId=" + accountId + "]";
    }

}
