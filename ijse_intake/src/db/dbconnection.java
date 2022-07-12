package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    private static dbconnection dbConnection;
    private Connection connection;

    private dbconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ijse_intake", "root", "1234");
    }

    public static dbconnection getInstance() throws SQLException, ClassNotFoundException {
        return dbConnection == null ? dbConnection=new dbconnection() :
                dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
