package infrastructure.model.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>
 * [AccountPo] 資料庫對應
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/01
 */
@Entity
@Table(name = "ACCOUNTS")
public class AccountPo {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "M_ID")
    private Long mid;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ERROR_TIMES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date error;

    @Column(name = "TIME_LAST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeLast;

    @Column(name = "TIME_BUILD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuild;

    @Column(name = "TIME_MODIFY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModify;

    public void setId(Long id) {
        this.id = id;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setError(Date error) {
        this.error = error;
    }

    public void setTimeLast(Date timeLast) {
        this.timeLast = timeLast;
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

    public Long getMid() {
        return mid;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public Date getError() {
        return error;
    }

    public Date getTimeLast() {
        return timeLast;
    }

    public Date getTimeBuild() {
        return timeBuild;
    }

    public Date getTimeModify() {
        return timeModify;
    }

    @Override
    public String toString() {
        return "AccountPo [id=" + id + ", mid=" + mid + ", account=" + account + ", password=" + password + ", status="
                + status + ", error=" + error + ", timeLast=" + timeLast + ", timeBuild=" + timeBuild + ", timeModify="
                + timeModify + "]";
    }

}
