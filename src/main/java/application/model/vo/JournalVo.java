package application.model.vo;

import java.math.BigDecimal;

/**
 * <p>
 * [JournalVo]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
public class JournalVo {

    private Long journalBookId;
    private String date;
    private String debitCode;
    private String debit;
    private String creditCode;
    private String credit;
    private String plusOrMinusSign;
    private BigDecimal amount;
    private String item;
    private String place;
    private String who;
    private String accountName;
    private String timeModify;

    public JournalVo setJournalBookId(Long journalBookId) {
        this.journalBookId = journalBookId;
        return this;
    }

    public JournalVo setDate(String date) {
        this.date = date;
        return this;
    }

    public JournalVo setDebitCode(String debitCode) {
        this.debitCode = debitCode;
        return this;
    }

    public JournalVo setDebit(String debit) {
        this.debit = debit;
        return this;
    }

    public JournalVo setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }

    public JournalVo setCredit(String credit) {
        this.credit = credit;
        return this;
    }

    public JournalVo setPlusOrMinusSign(String plusOrMinusSign) {
        this.plusOrMinusSign = plusOrMinusSign;
        return this;
    }

    public JournalVo setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public JournalVo setItem(String item) {
        this.item = item;
        return this;
    }

    public JournalVo setPlace(String place) {
        this.place = place;
        return this;
    }

    public JournalVo setWho(String who) {
        this.who = who;
        return this;
    }

    public JournalVo setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public JournalVo setTimeModify(String timeModify) {
        this.timeModify = timeModify;
        return this;
    }

    public Long getJournalBookId() {
        return journalBookId;
    }

    public String getDate() {
        return date;
    }

    public String getDebitCode() {
        return debitCode;
    }

    public String getDebit() {
        return debit;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public String getCredit() {
        return credit;
    }

    public String getPlusOrMinusSign() {
        return plusOrMinusSign;
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

    public String getAccountName() {
        return accountName;
    }

    public String getTimeModify() {
        return timeModify;
    }

    @Override
    public String toString() {
        return "JournalVo [journalBookId=" + journalBookId + ", date=" + date + ", debitCode=" + debitCode + ", debit="
                + debit + ", creditCode=" + creditCode + ", credit=" + credit + ", plusOrMinusSign=" + plusOrMinusSign
                + ", amount=" + amount + ", item=" + item + ", place=" + place + ", who=" + who + ", accountName="
                + accountName + ", timeModify=" + timeModify + "]";
    }

}
