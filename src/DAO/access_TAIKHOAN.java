package DAO;

import DTO.Connect;

import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class access_TAIKHOAN {
    
    
    // KIEM TRA TAI KHOAN CO TRONG CSDL 
    // 0 là khong co, 1 la ADMIN, 2 la nhan vien
    public static int getThongTinKiemTraTaiKhoan(String username, String password)
    {
        int loaiTK = -1;
        Connection conn = new Connect().connect();
        String query = "SELECT * FROM TAIKHOAN WHERE TENTK = '"+username+"' AND MATKHAU = '"+password+"' ";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                loaiTK = rs.getInt("LOAITK");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
            }
            catch(SQLException e){
            e.printStackTrace();
        }
        return loaiTK;
    }
}
    public static int getMaNV(String username){
        String query = "SELECT TIM_MANV(?) FROM DUAL";
        try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement(query)){
            statement.setString(1, username);
            ResultSet s= statement.executeQuery();
            if(s.next()){
                return s.getInt(1);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return -1;
    }
    // LAY TEN NHAN VIEN TU TEN TAI KHOAN
    public static String getTenNVfromTenTK( String tenTK )
    {
        Connection conn = Connect.connect();
        String query = "SELECT TENNV FROM TAIKHOAN TK, NHANVIEN NV WHERE TK.MANV = NV.MANV AND TENTK = '"+tenTK+"' ";
        String ten ="User";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                ten = rs.getString("TENNV");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
            }
            catch(SQLException e){
            e.printStackTrace();
            }
        }
        return ten;
    }

}
