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
 * [AccSPo]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/24
 */
@Entity
@Table(name = "ACC_SUBJECTS")
public class SubjectPo {
    
    @Id
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;


    @Column(name = "TIME_BUILD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuild;
    
    @Column(name = "TIME_MODIFY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModify;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Date getTimeBuild() {
        return timeBuild;
    }

    public Date getTimeModify() {
        return timeModify;
    }

    @Override
    public String toString() {
        return "AccSPo [id=" + id + ", code=" + code + ", name=" + name + ", timeBuild=" + timeBuild + ", timeModify="
                + timeModify + "]";
    }

    
}
