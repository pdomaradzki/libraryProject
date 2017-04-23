import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jaizm on 17/04/2017.
 */
public class Mysql {

    private final String DB = "jdbc:mysql://5.135.218.27:3306/pawelD?useUnicode=true&characterEncoding=UTF-8";
    private final String USER = "pawelD";
    private final String USERPW = "jaizm";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    public Connection serverConnection() {
        Connection connection = null;


        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            connection = DriverManager.getConnection(DB, USER, USERPW);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
