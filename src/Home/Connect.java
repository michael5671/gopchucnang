/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;
import java.sql.*;

/**
 *
 * @author Phuc
 */
public class Connect{
    public static Connection connect(){
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","c##doanck","a");
            con.setAutoCommit(true);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;

    }
}
