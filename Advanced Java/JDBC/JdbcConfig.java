package JdbcDemo;
public class JdbcConfig {
    private static final String url = "";
    private static final String user = "";
    private static final String password = "";

    public JdbcConfig() {

    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
