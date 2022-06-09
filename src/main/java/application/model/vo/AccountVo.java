package application.model.vo;

/**
 * <p>
 * [AccountVo]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/01
 */
public class AccountVo {

    /* ID */
    private Long id;
    /* 帳號 */
    private String account;
    /* 密碼 */
    private String password;
    /* 狀態 */
    private String status;

    public AccountVo setId(Long id) {
        this.id = id;
        return this;
    }

    public AccountVo setAccount(String account) {
        this.account = account;
        return this;
    }

    public AccountVo setPassword(String password) {
        this.password = password;
        return this;
    }

    public AccountVo setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "AccountVo [id=" + id + ", account=" + account + ", password=" + password + ", status=" + status + "]";
    }

}
