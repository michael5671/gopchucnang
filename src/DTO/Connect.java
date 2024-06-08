package DTO;

import  java.sql.*;

/**
 *
 * @author ADMIN
 */
public class Connect {
    public static Connection connect(){
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","phucdeptrai5","123456");
            con.setAutoCommit(true);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
