package application.model.vo;

/**
 * <p>
 * [SubjectVo]
 * </p>
 * 
 * @author ken
 * @since 2022/05/24
 */
public class SubjectVo {
    
    /** 序號 */
    private Long id;
    /** 科目代號 */
    private String code;
    /** 科目名稱 */
    private String name;
    
    public SubjectVo setId(Long id) {
        this.id = id;
        return this;
    }
    public SubjectVo setCode(String code) {
        this.code = code;
        return this;
    }
    public SubjectVo setName(String name) {
        this.name = name;
        return this;
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
    @Override
    public String toString() {
        return "AccSVo [id=" + id + ", code=" + code + ", name=" + name + "]";
    }
    

}
