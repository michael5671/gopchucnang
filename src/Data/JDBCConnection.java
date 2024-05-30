package Data;

import  java.sql.*;

/**
 *
 * @author ADMIN
 */
public class JDBCConnection {
    public static Connection getJDBCConnection(){
        String url = "jdbc:oracle:thin:@localhost:1521/orcl";
        String username ="C##QLNS";
        String password = "doanck";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try{
                return DriverManager.getConnection(url, username, password);
            } catch (SQLException e){
                 e.printStackTrace();
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
           return null;
    }
}
