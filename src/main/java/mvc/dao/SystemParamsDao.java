package mvc.dao;

import mvc.model.po.SystemParamsPo;

/**
 * <p>
 * [系統參數 DAO]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/04/17
 */
public interface SystemParamsDao {
    
    boolean update(String k, String v);

    SystemParamsPo find(String k);

    static String nextUID(String uid) {
        // u0004 -> u0005
        int maxLength = 4;
        String u = uid.substring(0, 1);
        String id = (Integer.parseInt(uid.substring(1)) + 1) + "";
        int idLen = id.length();
        for (int i = 0; i < (maxLength - idLen); i++)
            id = "0" + id;
        return u + id;
    }
}
