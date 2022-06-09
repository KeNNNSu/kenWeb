package domain.model.dto;

/**
 * <p>
 * [科目]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/24
 */
public class Subject {

    /** 序號 */
    private Long id;
    /** 科目代號 */
    private String code;
    /** 科目名稱 */
    private String name;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Subject setId(Long id) {
        this.id = id;
        return this;
    }

    public Subject setCode(String code) {
        this.code = code;
        return this;
    }

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AccS [id=" + id + ", code=" + code + ", name=" + name + "]";
    }

}
