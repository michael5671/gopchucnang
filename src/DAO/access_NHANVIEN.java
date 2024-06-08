package DAO;

import DTO.NHANVIEN;
import DTO.Connect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class access_NHANVIEN {
    // LAY TOAN BO DANH SACH NHAN VIEN
    public static ArrayList<NHANVIEN> getNHANVIEN()
    {
        Connection conn = new Connect().connect();
        ArrayList<NHANVIEN> lstNHANVIEN = new ArrayList<>();
        try{
            String query = "SELECT * FROM NHANVIEN";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                NHANVIEN tmp = new NHANVIEN();
                java.sql.Date dob = rs.getObject("NGSINH", java.sql.Date.class);
                
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setMaPB(rs.getString("MAPB"));
                tmp.setTenNV(rs.getString("TENNV"));
                tmp.setCCCD(rs.getString("CCCD"));
                tmp.setQueQuan(rs.getString("QUEQUAN"));
                int gioiTinh = rs.getInt("GIOITINH");
                tmp.setGioiTinh(gioiTinh != 0);
                tmp.setChucVu(rs.getString("CHUCVU"));
                tmp.setLuongCB(rs.getLong("LUONGCB"));
                tmp.setHeSo(rs.getDouble("HESO"));
                
                tmp.setNgSinh(dob.toLocalDate());
                
                lstNHANVIEN.add(tmp);
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
         return lstNHANVIEN;
    }
    
    // LAY TEN NHAN VIEN TU MANV
    public static String getTenFromMa(String manv)
    {
        Connection conn = new Connect().connect();
        String query = "SELECT * FROM NHANVIEN WHERE MANV = ?";
        String ten = "";
        try{
            PreparedStatement pSt  = conn.prepareStatement(query);
            pSt.setString(1,manv);
            ResultSet rs = pSt.executeQuery();
            if(rs.next()){
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
    
    // LAY MA NHAN VIEN TU TENNV
    public static int getMaFromTen(String tenNV)
    {
        int maNV = 0;
        Connection conn = new Connect().connect();
        String query = "SELECT * FROM NHANVIEN WHERE TENNV = '"+tenNV+"' ";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                maNV = rs.getInt("MANV");
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
        return maNV;
    }
}
