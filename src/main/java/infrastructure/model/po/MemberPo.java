package infrastructure.model.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * [MemberPo]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
@Entity
@Table(name = "MEMBERS")
public class MemberPo {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "TIME_MODIFY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModify;

    @Column(name = "TIME_BUILD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuild;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTimeModify(Date timeModify) {
        this.timeModify = timeModify;
    }

    public void setTimeBuild(Date timeBuild) {
        this.timeBuild = timeBuild;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getTimeModify() {
        return timeModify;
    }

    public Date getTimeBuild() {
        return timeBuild;
    }

    @Override
    public String toString() {
        return "MemberPo [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", timeModify="
                + timeModify + ", timeBuild=" + timeBuild + "]";
    }

}
