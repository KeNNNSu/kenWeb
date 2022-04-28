package mvc.model.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>
 * [User 持久化物件] 對應資料庫名字
 * </p>
 * 
 *
 * @author ken
 * @since 2022/04/04
 */
@Entity
@Table(name = "M_USER")
public class UserPo {

//    KEY pk值
    @Id
    @Column(name = "U_ID")
    private String uid;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LEVEL_RANK")
    private int level;

    @Column(name = "CREATE_TIME")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserPo [uid=" + uid + ", account=" + account + ", password=" + password + ", level=" + level
                + ", createTime=" + createTime + "]";
    }

}
