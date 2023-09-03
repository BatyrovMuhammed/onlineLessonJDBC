package org.example.comfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfig {

    //    2-
    public final Connection connection;

    public JDBCConfig() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/home",
                "postgres",
                "1234"
        );
    }
    public Connection getConnection(){
        return connection;
}


//1-
//    private static final String url = "jdbc:postgresql://localhost:5432/home";
//    private static final String userName = "postgres";
//    private static final String password = "1234";
//
//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//           connection = DriverManager.getConnection(url, userName, password);
//            System.out.println("SUCCESSFUL!!!");
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//        return connection;
//    }
}
