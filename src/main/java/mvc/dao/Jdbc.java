package mvc.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mvc.utils.BeanUtils;



/**
 * <p>
 * [JDBC 資料庫連接]  不懂 需要再看一次
 * </p>
 * 
 * 
 * @author ken
 * @since 2022/04/04
 */
public class Jdbc {
    
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    /**
     * [執行] -insert, update, delete
     **/
    public boolean execute(String sql, Object[] values) {
        connection();
        try {
            sql = checkAndSettingPs(sql, values);
            ps = conn.prepareStatement(sql);
            // 查詢: true; 更新或新增: false
            boolean result = ps.execute();
            return !result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }

    /**
     * [執行] -find
     **/
    public <T> T execute(String sql, Object[] values, Class<T> clazz) {
        connection();
        try {
            sql = checkAndSettingPs(sql, values);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Map<String, Object>> resultList = resultToList(rs);
            if (resultList == null || resultList.size() == 0)
                return null;
            T entity = BeanUtils.toBean(resultList.get(0), clazz, true);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    /**
     * [查詢]
     **/
    public <T> List<T> query(String sql, Object[] values, Class<T> clazz) {
        connection();
        try {
            List<T> list = new ArrayList<>();
            sql = checkAndSettingPs(sql, values);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Map<String, Object>> retultList = resultToList(rs);
            for (int i = 0; i < retultList.size(); i++) {
                T entity = BeanUtils.toBean(retultList.get(i), clazz, true);
                list.add(entity);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    /**
     * [連線]
     **/
    private Connection connection() {
        try {
            // 建構 Driver 並取得連結
            conn = Datasource.getInstance().getConnection();
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [關閉所有資源]
     **/
    private void closeAll() {
        try {
            Datasource.close(rs);
            Datasource.close(ps);
            Datasource.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * [檢查參數 & 設定參數]
     **/
    private String checkAndSettingPs(String sql, Object[] values) throws SQLException {
        final String SYMBOL = "[?]";
        final SimpleDateFormat FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 無參數
        if (values == null || values.length == 0)
            return sql;
        // 檢查參數數量
        int count = 0;
        for (char c : sql.toCharArray())
            if ('?' == c)
                count++;
        if (values.length != count)
            throw new IllegalArgumentException("SQL 參數與 values 數量不相同!!");
        // 設定參數
        for (int i = 0; i < count; i++) {
            Object value = values[i];
            //    sql: select * from m_user where u_id = ?
            // values: {"s001"}
            // final sql: select * from m_user where u_id = 's001'
            if (value instanceof String)
                sql = sql.replaceFirst(SYMBOL, String.format("'%s'", (String) value));
            else if (value instanceof Integer)
                sql = sql.replaceFirst(SYMBOL, String.valueOf(value));
            else if (value instanceof BigDecimal)
                sql = sql.replaceFirst(SYMBOL, ((BigDecimal) value).toPlainString());
            else if (value instanceof java.util.Date) {
                java.util.Date date = (java.util.Date) value;
                sql = sql.replaceFirst(SYMBOL,
                        String.format("TO_TIMESTAMP('%s', 'YYYY-MM-DD HH24:MI:SS')", FMT.format(date)));
            } else if (value instanceof java.sql.Date) {
                java.sql.Date sqlDate = (java.sql.Date) value;
                java.util.Date date = new java.util.Date(sqlDate.getTime());
                sql = sql.replaceFirst(SYMBOL,
                        String.format("TO_TIMESTAMP('%s', 'YYYY-MM-DD HH24:MI:SS')", FMT.format(date)));
            } else
                throw new IllegalArgumentException(value + " 無對應處理方式, 需新增判斷處理!!");
        }
        return sql;
    }

    /**
     * [取得 ListMap]
     **/ 
     
    private List<Map<String, Object>> resultToList(ResultSet rs) throws java.sql.SQLException {
        if (rs == null)
            return null;
        ResultSetMetaData md = rs.getMetaData();
        int columnCount = md.getColumnCount();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> rowData;
        while (rs.next()) {
            rowData = new HashMap<>(columnCount);
            for (int i = 1; i <= columnCount; i++)
                rowData.put(md.getColumnName(i), rs.getObject(i));
            list.add(rowData);
        }
        return list;
    }

}
