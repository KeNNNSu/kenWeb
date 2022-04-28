package mvc.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * [系統參數]
 * </p>

 * 
 * @author ken
 * @since 2022/04/17
 */
@Entity
@Table(name = "SYSTEM_PARAMS")
public class SystemParamsPo {

    @Column(name = "K")
    private String k;
    @Column(name = "V")
    private String v;
    @Column(name = "SYS_COMMENT")
    private String comment;

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "SystemParamsPo [k=" + k + ", v=" + v + ", comment=" + comment + "]";
    }

}
