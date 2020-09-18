

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package neu.util;

import java.sql.*;

public class DBUtil {
    private static String driver = ProUtil.getDrier();
    private static String url = ProUtil.getUrl();
    private static String user = ProUtil.getUser();
    private static String password = ProUtil.getPassword();

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException var1) {
            var1.printStackTrace();
        }

    }

    public DBUtil() {
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rst) {
        if (rst != null) {
            try {
                rst.close();
            } catch (SQLException var27) {
                var27.printStackTrace();
            } finally {
                rst = null;
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException var25) {
                var25.printStackTrace();
            } finally {
                stmt = null;
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException var23) {
                var23.printStackTrace();
            } finally {
                conn = null;
            }
        }

    }
}
