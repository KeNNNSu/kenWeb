package mvc.model.vo;


/**
 * <p>
 * [UserVo]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/04/17
 */
public class UserVo {
    
    private String uid;
    private String account;
    private String password;
    private Integer level;
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
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    @Override
    public String toString() {
        return "UserVo [uid=" + uid + ", account=" + account + ", password=" + password + ", level=" + level + "]";
    }
    
}
