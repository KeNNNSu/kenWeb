package mvc.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mvc.dao.Jdbc;
import mvc.dao.UserDao;
import mvc.model.po.UserPo;

/**
 * <p>
 * [User 資料存取層] -實作類
 * </p>
 * 
 * 
 * 
 * @author ken
 * @since 2022/04/04
 */
public class UserDaoImpl implements UserDao {

    private final String T_USER = "M_USER";
    private final String C_UID = "U_ID";
    private final String C_ACCOUNT = "ACCOUNT";
    private final String C_PASSWORD = "PASSWORD";
    private final String C_LEVEL = "LEVEL_RANK";
    private final String C_CREATE_TIME = "CREATE_TIME";

    private Jdbc jdbc = new Jdbc();

    @Override
    public boolean insert(UserPo userPo) {
        String sql = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)", T_USER, C_UID,
                C_ACCOUNT, C_PASSWORD, C_LEVEL, C_CREATE_TIME);
        List<Object> objList = new ArrayList<>();
        objList.add(userPo.getUid());
        objList.add(userPo.getAccount());
        objList.add(userPo.getPassword());
        objList.add(userPo.getLevel());
        objList.add(new Date());
        Object[] values = objList.toArray(new Object[objList.size()]);
        return jdbc.execute(sql, values);
    }

    @Override
    public List<UserPo> findAll() {
        String sql = String.format("SELECT * FROM %s", T_USER);
        Object[] values = null;
        return jdbc.query(sql, values, UserPo.class);
    }

    @Override
    public UserPo findByUid(String uid) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", T_USER, C_UID);
        List<Object> objList = new ArrayList<>();
        objList.add(uid);
        Object[] values = objList.toArray(new Object[objList.size()]);
        return jdbc.execute(sql, values, UserPo.class);
    }

    @Override
    public UserPo findByAccount(String account) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", T_USER, C_ACCOUNT);
        List<Object> objList = new ArrayList<>();
        objList.add(account);
        Object[] values = objList.toArray(new Object[objList.size()]);
        return jdbc.execute(sql, values, UserPo.class);
    }

    @Override
    public boolean update(String uid, UserPo userPo) {
        String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?", T_USER, C_ACCOUNT, C_PASSWORD,
                C_LEVEL, C_UID);
        List<Object> objList = new ArrayList<>();
        objList.add(userPo.getAccount());
        objList.add(userPo.getPassword());
        objList.add(userPo.getLevel());
        objList.add(uid);
        Object[] values = objList.toArray(new Object[objList.size()]);
        return jdbc.execute(sql, values);
    }

    @Override
    public boolean delete(String uid) {
        String sql = String.format("DELETE  FROM %s WHERE %s = ?", T_USER, C_UID);
        List<Object> objList = new ArrayList<>();
        objList.add(uid);
        Object[] values = objList.toArray(new Object[objList.size()]);
        return jdbc.execute(sql, values);
    }

}
