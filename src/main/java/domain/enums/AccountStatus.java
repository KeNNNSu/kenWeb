package domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * [AccountStatus]
 * </p>
 * 
 * 
 * @author ken
 * @since 2022/05/03
 */
public enum AccountStatus {

    DISABLE(0, "停用"), ENABLE(1, "啟用中"), LOCK(4, "已鎖定");

    private int value;
    private String comment;
    
    static class Holder {
        private static Map<String, AccountStatus> all = new HashMap<>();
    }

    private AccountStatus(int value, String comment) {
        this.value = value;
        this.comment = comment;
        Holder.all.put(value + "", this);
    }
    
    public static AccountStatus of(String valueStr) {
//        for (AccountStatus status : AccountStatus.values())
//            if ((status.getValue() + "").equals(valueStr))
//                return status;
//        return null;
        return Holder.all.get(valueStr);
    }

    public int getValue() {
        return value;
    }

    public String getComment() {
        return comment;
    }

}
