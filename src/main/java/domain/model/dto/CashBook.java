package domain.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * [現金帳]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
public class CashBook {

    private Long journalId;
    private BigDecimal increase;
    private BigDecimal reduce;
    private Date timeBuild;
    private Date timeModify;

    private CashBook() {
        super();
    }

    private CashBook(Long journalId, BigDecimal increase, BigDecimal reduce) {
        super();
        setJournalId(journalId);
        setIncrease(increase);
        setReduce(reduce);
    }
    
    public static CashBook from(JournalBook journalBook) {
        BigDecimal increase = BigDecimal.ZERO; // new BigDecimal(0);
        BigDecimal reduce = BigDecimal.ZERO;
        IncludeCashOfSubject includeCashOfSubject = journalBook.getIncludeCashOfSubject();
        if (includeCashOfSubject.isIncludeCash()) {
            if (includeCashOfSubject.isIncludeCashOfDebit())
                increase = journalBook.getAmount();
            if (includeCashOfSubject.isIncludeCashOfCredit())
                reduce = journalBook.getAmount();
        }
        return new CashBook(journalBook.getId(), increase, reduce);
    }

    public CashBook setJournalId(Long journalId) {
        if (journalId == null)
            throw new IllegalArgumentException("journalId 不可為空!!");
        this.journalId = journalId;
        return this;
    }

    public CashBook setIncrease(BigDecimal increase) {
        if (increase == null)
            throw new IllegalArgumentException("increase 不可為空!!");
        this.increase = increase;
        return this;
    }

    public CashBook setReduce(BigDecimal reduce) {
        if (reduce == null)
            throw new IllegalArgumentException("reduce 不可為空!!");
        this.reduce = reduce;
        return this;
    }

    public CashBook setTimeBuild(Date timeBuild) {
        this.timeBuild = timeBuild;
        return this;
    }

    public CashBook setTimeModify(Date timeModify) {
        this.timeModify = timeModify;
        return this;
    }

    public Long getJournalId() {
        return journalId;
    }

    public BigDecimal getIncrease() {
        return increase;
    }

    public BigDecimal getReduce() {
        return reduce;
    }

    public Date getTimeBuild() {
        return timeBuild;
    }

    public Date getTimeModify() {
        return timeModify;
    }

    @Override
    public String toString() {
        return "CashBook [journalId=" + journalId + ", increase=" + increase + ", reduce=" + reduce + ", timeBuild="
                + timeBuild + ", timeModify=" + timeModify + "]";
    }

}
