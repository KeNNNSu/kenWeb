package domain.model.dto;

import domain.enums.AccountStatus;

/**
 * <p>
 * [帳號]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/01
 */
public class Account {

    /* ID */
    private Long id;
    /* 帳號 */
    private String account;
    /* 密碼 */
    private String password;
    /* 狀態 */
    private AccountStatus accountStatus;

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public Account setAccount(String account) {
        this.account = account;
        return this;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public Account setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
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

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", account=" + account + ", password=" + password + ", accountStatus="
                + accountStatus + "]";
    }

}
