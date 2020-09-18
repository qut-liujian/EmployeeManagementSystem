//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package neu.util;

import java.util.ResourceBundle;

public class ProUtil {
    private static ResourceBundle rb = ResourceBundle.getBundle("db");

    public ProUtil() {
    }

    public static String getDrier() {
        String str = rb.getString("driver");
        return str;
    }

    public static String getUrl() {
        String str = rb.getString("url");
        return str;
    }

    public static String getUser() {
        String str = rb.getString("user");
        return str;
    }

    public static String getPassword() {
        String str = rb.getString("password");
        return str;
    }
}
