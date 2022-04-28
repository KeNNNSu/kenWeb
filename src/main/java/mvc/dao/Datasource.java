package mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * <p>
 * [數據管理類] -管理與資料庫的連線
 * </p>
 *
 * @author ken
 * @since 2022/04/06
 */
public class Datasource {
    /**
     * [設置驅動類別: 設定路徑]
     * - 找到 ojdbc8-19.3.0.0.jar> 右鍵> Build Path> Add to Build Path
     * - 找到 Driver.class> 右鍵> Copy Qualified Name 取得 Driver.class 路徑(要去掉 ".class")
     */
    public final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    /**
     * [設置資料庫: 連結位置]
     * - 使用本機(localhost), IP位置 (CMD:ipconfig)
     */
    public final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
//                                  jdbc:oracle:thin:@127.0.0.1/orcl

    /**
     * [設置資料庫使用者]
     * - root/admin 等等是最高權限(盡量不要使用), 開發時應有其他權限帳號
     */
    public final String JDBC_USER = "ken";

    /**
     * [設置資料庫使用者密碼]
     */
    public final String JDBC_PASS = "oracle";

    // 建構 Datasource
    private static Datasource datasource = new Datasource();

    public static Datasource build() {
        return datasource;
    }

    /** 建構子: 使用單例模式 */

    // 私有化建構子
    private Datasource () {}

    // 提供資料庫連接
    public static Datasource getInstance() {
        return build();
    }

    /** 建立資料庫連接 */

    // 取得連接物件
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        // 型態：Connection (import java.sql.Connection)
        Connection conn = null;

        // 調用 Class.forName() 方法加載驅動程序
        Class.forName(JDBC_DRIVER); // throws ClassNotFoundException

        // 進行連接
        conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS); // throws SQLException

        // 回傳連接後連線串流
        return conn;
    }

    /** 關閉連接 */

    /*
     * [關閉連接情況有三]
     * 1. 檔案
     * 2. 網路
     * 3. 資料庫
     * 
     * [有開有關, 先開後關]
     * - 開：port1 -> port2 -> port3 -> port4 -> database
     * - 關：port1 <- port2 <- port3 <- port4 <- database
     * 
     * p.s. 如果先關 port1; port2, port3, port4 沒關, 會佔住電腦記憶體, 除非重新開機
     */

    // 關閉資料庫連接
    public static void close(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    // 關閉 sql 語法的傳送
    public static void close(Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }
    }

    // 關閉 sql 語法的傳送
    public static void close(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    // 關閉回傳數據
    public static void close(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

}
