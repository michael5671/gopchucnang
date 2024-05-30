package DAO;

import DTO.YEUCAUUNGLUONG;
import Data.JDBCConnection;
import java.util.*;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class access_YEUCAUUNGLUONG {
    
    // LAY DANH SACH YEU CAU UNG LUONG
    public static ArrayList<YEUCAUUNGLUONG> getYEUCAUUNGLUONG()
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        ArrayList<YEUCAUUNGLUONG> lstYEUCAUUNGLUONG = new ArrayList<>();
        try{
            String query = "SELECT * FROM YEUCAUUNGLUONG";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                YEUCAUUNGLUONG tmp = new YEUCAUUNGLUONG();
                java.sql.Date ngayUL = rs.getObject("NGAYUL", java.sql.Date.class );
                
                tmp.setMaYCUL(rs.getInt("MAYCUL"));
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setNgUL(ngayUL.toLocalDate());
                tmp.setTienUL(rs.getLong("TIENUL"));
                tmp.setGhiChuUL(rs.getString("GHICHUUL"));
                tmp.settThaiYCUL(rs.getString("TRANGTHAIUL"));
                
                lstYEUCAUUNGLUONG.add(tmp);
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
        return lstYEUCAUUNGLUONG;
    }
    
    // LAY DANH SACH YEU CAU UNG LUONG DA LOC
    public static ArrayList<YEUCAUUNGLUONG> getNewYEUCAUUNGLUONG(int maNV, String trangThai)
    {
        ArrayList<YEUCAUUNGLUONG> lst = new ArrayList<>();
        String query = "";
        Connection conn = new JDBCConnection().getJDBCConnection();
        
        if(maNV != 0 && trangThai.length() != 0)
            query = "SELECT * FROM YEUCAUUNGLUONG WHERE MANV = " + maNV + " AND TRANGTHAIUL = '"+trangThai+"' " ;
        else if(maNV != 0 && trangThai.length() == 0)
            query = "SELECT * FROM YEUCAUUNGLUONG WHERE MANV = " + maNV;
        else if(maNV == 0 && trangThai.length() != 0)
            query = "SELECT * FROM YEUCAUUNGLUONG WHERE TRANGTHAIUL = '"+trangThai+"' " ;
        else
            query = "SELECT * FROM YEUCAUUNGLUONG";
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
           
            while(rs.next()){
                YEUCAUUNGLUONG tmp = new YEUCAUUNGLUONG();
                java.sql.Date ngayUL = rs.getObject("NGAYUL", java.sql.Date.class );
                
                tmp.setMaYCUL(rs.getInt("MAYCUL"));
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setNgUL(ngayUL.toLocalDate());
                tmp.setTienUL(rs.getLong("TIENUL"));
                tmp.setGhiChuUL(rs.getString("GHICHUUL"));
                tmp.settThaiYCUL(rs.getString("TRANGTHAIUL"));
                
                lst.add(tmp);
            }
        }
         catch(SQLException e){
                    System.out.println("Error" + e);
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
        return lst;
    }
    
    // LAY GHI CHU TU MA YEU CAU
    public static String getGHICHUUL( String maycul )
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        String query = "SELECT * FROM YEUCAUUNGLUONG WHERE MAYCUL = ?";
        String ghiChu = "";
        try{
            PreparedStatement pSt = conn.prepareStatement(query);
            pSt.setString(1, maycul);
            ResultSet rs = pSt.executeQuery();
            while(rs.next()){
                ghiChu = rs.getString("GHICHUUL");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
        }
        return ghiChu;
    }
}
    
    // LAY TRANG THAI YEU CAU TU MA YEU CAU
    public static String getTTHAIYCUL(String mayc)
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        String query = "SELECT * FROM YEUCAUUNGLUONG WHERE MAYCUL = ?";
        String status = "";
        try{
            PreparedStatement pSt = conn.prepareStatement(query);
            pSt.setString(1, mayc);
            ResultSet rs = pSt.executeQuery();
            while(rs.next()){
                status = rs.getString("TRANGTHAIUL");
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
        return status;
    }
    
    // LAY SO TIEN UNG LUONG TU MA YEU CAU
    public static long getTIENUL( String mayc)
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        String query = "SELECT * FROM YEUCAUUNGLUONG WHERE MAYCUL = ?";
        long tienUng = 0;
        try{
            PreparedStatement pSt = conn.prepareStatement(query);
            pSt.setString(1, mayc);
            ResultSet rs = pSt.executeQuery();
            if(rs.next())
                tienUng = rs.getLong("TIENUL");
            
            conn.close();
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
        return tienUng;
    }
    
    // XU LY YEU CAU UNG LUONG
    public static void XuLyYeuCauUL( int maYC , int type)
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        String query = "call SP_XULYEUCAUUNGLUONG(?,?)";
        try{
            CallableStatement cst = conn.prepareCall(query);
            cst.setInt(1, maYC);
            cst.setInt(2, type);
            cst.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try {
                if (conn != null) 
                    conn.close(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
