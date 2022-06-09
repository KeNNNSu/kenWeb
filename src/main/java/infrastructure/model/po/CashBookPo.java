package infrastructure.model.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>
 * [CashBookPo]
 * </p>
 * 
 * @author ken
 * @since 2022/06/01
 */
@Entity
@Table(name = "ACC_CASH")
public class CashBookPo {

    @Id
    @Column(name = "JOURNAL_ID")
    private Long journalId;

    @Column(name = "INCREASE")
    private BigDecimal inrease;

    @Column(name = "REDUCE")
    private BigDecimal reduce;

    @Column(name = "TIME_BUILD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuild;

    @Column(name = "TIME_MODIFY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModify;

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public void setInrease(BigDecimal inrease) {
        this.inrease = inrease;
    }

    public void setReduce(BigDecimal reduce) {
        this.reduce = reduce;
    }

    public void setTimeBuild(Date timeBuild) {
        this.timeBuild = timeBuild;
    }

    public void setTimeModify(Date timeModify) {
        this.timeModify = timeModify;
    }

    public Long getJournalId() {
        return journalId;
    }

    public BigDecimal getInrease() {
        return inrease;
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
        return "CashBookPo [journalId=" + journalId + ", inrease=" + inrease + ", reduce=" + reduce + ", timeBuild="
                + timeBuild + ", timeModify=" + timeModify + "]";
    }

}
