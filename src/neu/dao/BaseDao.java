//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package neu.dao;

import neu.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {
    protected Connection conn;
    protected PreparedStatement stmt;
    protected ResultSet rst;

    public BaseDao() {
    }

    protected final void getConnection() throws SQLException {
        this.conn = DBUtil.getConnection();
    }

    protected final void closeAll() {
        DBUtil.close(this.conn, this.stmt, this.rst);
    }

    protected final List<Map<String, String>> exeucteQuery(String sql, String... args) {
        ArrayList list = new ArrayList();

        try {
            this.getConnection();
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for(int i = 0; i < args.length; ++i) {
                    stmt.setString(i + 1, args[i]);
                }
            }

            ResultSet rst = stmt.executeQuery();
            ResultSetMetaData meta = rst.getMetaData();
            int c = meta.getColumnCount();

            while(rst.next()) {
                Map<String, String> item = new HashMap();

                for(int i = 0; i < c; ++i) {
                    String name = meta.getColumnLabel(i + 1);
                    String value = rst.getString(i + 1);
                    item.put(name, value);
                }

                list.add(item);
            }
        } catch (SQLException var15) {
            throw new RuntimeException("数据库查询异常", var15);
        } finally {
            this.closeAll();
        }

        return list;
    }

    protected final int executeUpdate(String sql, String... args) {
        boolean var3 = false;

        int row;
        try {
            this.getConnection();
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for(int i = 0; i < args.length; ++i) {
                    stmt.setString(i + 1, args[i]);
                }
            }

            row = stmt.executeUpdate();
        } catch (SQLException var9) {
            throw new RuntimeException("执行修改操作异常", var9);
        } finally {
            this.closeAll();
        }

        return row;
    }
}
