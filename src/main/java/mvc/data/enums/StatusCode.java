package mvc.data.enums;

import java.util.HashMap;
import java.util.Map;



/**
 * <p>
 * [狀態碼]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/04/17
 */
public enum StatusCode {

    /** 成功 */
    SUCCESS(200, "成功"),

    /** 新增成功 */
    S201(201, "新增成功"),
    /** 修改成功 */
    S202(202, "修改成功"),
    /** 刪除成功 */
    S203(203, "刪除成功"),

    /** 新增失敗 */
    E401(401, "新增失敗"),
    /** 修改失敗 */
    E402(402, "修改失敗"),
    /** 刪除失敗 */
    E403(403, "刪除失敗"),

    /** 不明異常 */
    E499(499, "不明異常");

    private Integer code;
    private String msg;

    static class Holder {
        static Map<Integer, StatusCode> allMap = new HashMap<>();
    }

    private StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        Holder.allMap.put(code, this);
    }

    public static StatusCode of(Integer code) {
        return Holder.allMap.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
