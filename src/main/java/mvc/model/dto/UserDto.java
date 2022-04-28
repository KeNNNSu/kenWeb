package mvc.model.dto;

import mvc.data.enums.Level;

/**
 * <p>
 * [UserDto] -User
 * </p>
 * 
 * 
 * @author ken
 * @since 2022/04/04
 */
public class UserDto {

    private String uid;
    private String account;
    private String password;
    private Level level;

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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "UserDto [uid=" + uid + ", account=" + account + ", password=" + password + ", level=" + level + "]";
    }

}
