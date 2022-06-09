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
 * [JournalBookPo]
 * </p>
 *
 * @author ken
 * @since 2022/05/30
 */
@Entity
@Table(name = "ACC_JOURNALS")
public class JournalBookPo {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TIME_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeDate;

    @Column(name = "DEBIT")
    private Long debit;

    @Column(name = "CREDIT")
    private Long credit;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "PLACE")
    private String place;

    @Column(name = "WHO")
    private String who;

    @Column(name = "A_ID")
    private Long accontId;

    @Column(name = "TIME_BUILD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuild;

    @Column(name = "TIME_MODIFY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModify;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    public void setDebit(Long debit) {
        this.debit = debit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
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

    public void setAccontId(Long accontId) {
        this.accontId = accontId;
    }

    public void setTimeBuild(Date timeBuild) {
        this.timeBuild = timeBuild;
    }

    public void setTimeModify(Date timeModify) {
        this.timeModify = timeModify;
    }

    public Long getId() {
        return id;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public Long getDebit() {
        return debit;
    }

    public Long getCredit() {
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

    public Long getAccontId() {
        return accontId;
    }

    public Date getTimeBuild() {
        return timeBuild;
    }

    public Date getTimeModify() {
        return timeModify;
    }

    @Override
    public String toString() {
        return "JournalPo [id=" + id + ", timeDate=" + timeDate + ", debit=" + debit + ", credit=" + credit
                + ", amount=" + amount + ", item=" + item + ", place=" + place + ", who=" + who + ", accontId="
                + accontId + ", timeBuild=" + timeBuild + ", timeModify=" + timeModify + "]";
    }

}
