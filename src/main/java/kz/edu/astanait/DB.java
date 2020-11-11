package kz.edu.astanait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static Connection connection;

    private DB() {
    }

    public static Connection getConnection() {
        if(connection==null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unik_portal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                        "root","");
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return connection;
    }
}
