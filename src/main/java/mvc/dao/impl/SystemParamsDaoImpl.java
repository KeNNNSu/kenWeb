package mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mvc.dao.Jdbc;
import mvc.dao.SystemParamsDao;
import mvc.model.po.SystemParamsPo;

/**
 * <p>
 * [系統參數 DAO 實作]
 * </p>
 * 
 
 * 
 * @author ken
 * @since 2022/04/17
 */
@SuppressWarnings("unused")
public class SystemParamsDaoImpl  implements SystemParamsDao{
    
    private final String T_SYSTEM_PARAMS = "SYSTEM_PARAMS";
    private final String C_K = "K";
    private final String C_V = "V";
    private final String C_COMMENT = "SYS_COMMENT";
    
    private Jdbc jdbc = new Jdbc();

    @Override
    public boolean update(String k, String v) {
        String sql = String.format("UPDATE %s SET %s = ? WHERE %s = ?", T_SYSTEM_PARAMS, C_V, C_K);
        List<Object> objList = new ArrayList<>();
        objList.add(v);
        objList.add(k);
        Object[] values = objList.toArray(new Object[objList.size()]);
        return jdbc.execute(sql, values);
    }

    @Override
    public SystemParamsPo find(String k) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", T_SYSTEM_PARAMS, C_K);
        List<Object> objList = new ArrayList<>();
        objList.add(k);
        Object[] values = objList.toArray(new Object[objList.size()]);
        return jdbc.execute(sql, values, SystemParamsPo.class);
    }
    
    
}

