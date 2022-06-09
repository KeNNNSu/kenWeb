package domain.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * [日記帳]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
public class JournalBook {

    private Long id;
    private Date recordDate; // 當日日期/記帳日期
    private Subject debit;
    private Subject credit;
    private BigDecimal amount;
    private String item;
    private String place;
    private String who;
    private Long accountId;
    private Date timeBuild;
    private Date timeModify;

    private IncludeCashOfSubject includeCashOfSubject;

    private JournalBook() {
        super();
    }

    private JournalBook(Long id, Date recordDate, Subject debit, Subject credit, BigDecimal amount, String item,
            Long accountId) {
        this();
        this.id = id;
        setRecordDate(recordDate);
        setDebit(debit);
        setCredit(credit);
        setAmount(amount);
        setItem(item);
        setAccountId(accountId);
        setIncludeCashOfSubject(IncludeCashOfSubject.from(debit, credit));
    }

    private JournalBook(Long id, Date recordDate, Subject debit, Subject credit, BigDecimal amount, String item) {
        this();
        this.id = id;
        setRecordDate(recordDate);
        setDebit(debit);
        setCredit(credit);
        setAmount(amount);
        setItem(item);
        setIncludeCashOfSubject(IncludeCashOfSubject.from(debit, credit));
    }

    public static JournalBook findOf(Long id, Date recordDate, Subject debit, Subject credit, BigDecimal amount,
            String item, Long accountId) {
        return new JournalBook(id, recordDate, debit, credit, amount, item, accountId);
    }

    public static JournalBook addOf(Date recordDate, Subject debit, Subject credit, BigDecimal amount, String item,
            Long accountId) {
        return new JournalBook(null, recordDate, debit, credit, amount, item, accountId);
    }

    public static JournalBook modifyOf(Date recordDate, Subject debit, Subject credit, BigDecimal amount, String item) {
        return new JournalBook(null, recordDate, debit, credit, amount, item);
    }

    public JournalBook setId(Long id) {
        this.id = id;
        return this;
    }

    public JournalBook setRecordDate(Date recordDate) {
        if (recordDate == null)
            throw new IllegalArgumentException("recordDate 不可為空!!");
        this.recordDate = recordDate;
        return this;
    }

    public JournalBook setDebit(Subject debit) {
        if (debit == null)
            throw new IllegalArgumentException("debit 不可為空!!");
        this.debit = debit;
        return this;
    }

    public JournalBook setCredit(Subject credit) {
        if (credit == null)
            throw new IllegalArgumentException("credit 不可為空!!");
        this.credit = credit;
        return this;
    }

    public JournalBook setAmount(BigDecimal amount) {
        if (amount == null)
            throw new IllegalArgumentException("amount 不可為空!!");
        this.amount = amount;
        return this;
    }

    public JournalBook setItem(String item) {
        if (item == null)
            throw new IllegalArgumentException("item 不可為空!!");
        this.item = item;
        return this;
    }

    public JournalBook setPlace(String place) {
        this.place = place;
        return this;
    }

    public JournalBook setWho(String who) {
        this.who = who;
        return this;
    }

    public JournalBook setAccountId(Long accountId) {
        if (accountId == null)
            throw new IllegalArgumentException("accountId 不可為空!!");
        this.accountId = accountId;
        return this;
    }

    public JournalBook setTimeBuild(Date timeBuild) {
        this.timeBuild = timeBuild;
        return this;
    }

    public JournalBook setTimeModify(Date timeModify) {
        this.timeModify = timeModify;
        return this;
    }

    public JournalBook setIncludeCashOfSubject(IncludeCashOfSubject includeCashOfSubject) {
        this.includeCashOfSubject = includeCashOfSubject;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public Subject getDebit() {
        return debit;
    }

    public Subject getCredit() {
        return credit;
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

    public Date getTimeBuild() {
        return timeBuild;
    }

    public Date getTimeModify() {
        return timeModify;
    }

    public IncludeCashOfSubject getIncludeCashOfSubject() {
        return includeCashOfSubject;
    }

    @Override
    public String toString() {
        return "JournalBook [id=" + id + ", recordDate=" + recordDate + ", debit=" + debit + ", credit=" + credit
                + ", amount=" + amount + ", item=" + item + ", place=" + place + ", who=" + who + ", accountId="
                + accountId + ", timeBuild=" + timeBuild + ", timeModify=" + timeModify + ", includeCashOfSubject="
                + includeCashOfSubject + "]";
    }

}
