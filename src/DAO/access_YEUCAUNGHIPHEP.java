package DAO;

import DTO.YEUCAUNGHIPHEP;
import Data.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class access_YEUCAUNGHIPHEP {
    // LAY DANH SACH YEU CAU NGHI PHEP
    public static ArrayList<YEUCAUNGHIPHEP> getYEUCAUNGHIPHEP()
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        ArrayList<YEUCAUNGHIPHEP> lstYEUCAUNGHIPHEP = new ArrayList<>();
        try{
            String query = "SELECT * FROM YEUCAUNGHIPHEP";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                YEUCAUNGHIPHEP tmp = new YEUCAUNGHIPHEP();
                java.sql.Date ngayGui = rs.getObject("NGAYGUI", java.sql.Date.class);
                java.sql.Date ngayBD = rs.getObject("NGAYBD", java.sql.Date.class);
                java.sql.Date ngayKT = rs.getObject("NGAYKT", java.sql.Date.class);
                
                tmp.setMaYCNP(rs.getInt("MAYCNP"));
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setNgGui(ngayGui.toLocalDate());
                tmp.setNgBD(ngayBD.toLocalDate());
                tmp.setNgKT(ngayKT.toLocalDate());
                tmp.setGhiChuNP(rs.getString("GHICHUNP"));
                tmp.settThaiYCNP(rs.getString("TRANGTHAINP"));
                
                lstYEUCAUNGHIPHEP.add(tmp);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        return lstYEUCAUNGHIPHEP;
    }
    
    //LAY DANH SACH YEU CAU NGHI PHEP DA LOC
    public static ArrayList<YEUCAUNGHIPHEP> getNewYEUCAUNGHIPHEP(int maNV, String trangThai)
    {
        ArrayList<YEUCAUNGHIPHEP> lst = new ArrayList<>();
        String query = "";
        Connection conn = new JDBCConnection().getJDBCConnection();
        
        if(maNV != 0 && trangThai.length() != 0)
            query = "SELECT * FROM YEUCAUNGHIPHEP WHERE MANV = " + maNV + " AND TRANGTHAINP = '"+trangThai+"' " ;
        else if(maNV != 0 && trangThai.length() == 0)
            query = "SELECT * FROM YEUCAUNGHIPHEP WHERE MANV = " + maNV;
        else if(maNV == 0 && trangThai.length() != 0)
            query = "SELECT * FROM YEUCAUNGHIPHEP WHERE TRANGTHAINP = '"+trangThai+"' " ;
        else
            query = "SELECT * FROM YEUCAUNGHIPHEP";
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
           
            while(rs.next()){
                YEUCAUNGHIPHEP tmp = new YEUCAUNGHIPHEP();
                java.sql.Date ngayGui = rs.getObject("NGAYGUI", java.sql.Date.class);
                java.sql.Date ngayBD = rs.getObject("NGAYBD", java.sql.Date.class);
                java.sql.Date ngayKT = rs.getObject("NGAYKT", java.sql.Date.class);
                
                tmp.setMaYCNP(rs.getInt("MAYCNP"));
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setNgGui(ngayGui.toLocalDate());
                tmp.setNgBD(ngayBD.toLocalDate());
                tmp.setNgKT(ngayKT.toLocalDate());
                tmp.setGhiChuNP(rs.getString("GHICHUNP"));
                tmp.settThaiYCNP(rs.getString("TRANGTHAINP"));
                
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
    public static String getGHICHUNP(String maycnp)
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        String query = "SELECT * FROM YEUCAUNGHIPHEP WHERE MAYCNP = ?";
        String ghiChu = "";
        try{
            PreparedStatement pSt = conn.prepareStatement(query);
            pSt.setString(1, maycnp);
            ResultSet rs = pSt.executeQuery();
             while(rs.next()){
                ghiChu = rs.getString("GHICHUNP");
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
    
    // LAY THOI GIAN BAT DAU NGHI TU MA YEU CAU
    public static String getNgayBD( String mayc )
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        String query = "SELECT * FROM YEUCAUNGHIPHEP WHERE MAYCNP = ?";
        String ngBD = "";
        try{
            PreparedStatement pSt = conn.prepareStatement(query);
            pSt.setString(1, mayc);
            ResultSet rs = pSt.executeQuery();
            if(rs.next())
            {
                YEUCAUNGHIPHEP tmp = new YEUCAUNGHIPHEP();
                java.sql.Date tmpNGBD = rs.getObject("NGAYBD", java.sql.Date.class);
                
                tmp.setNgBD(tmpNGBD.toLocalDate());
                
                ngBD = tmp.getNgBD().toString();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return ngBD;
    }
    
    // LAY THOI GIAN KET THUC  NGHI TU MA YEU CAU
    public static String getNgayKT( String mayc )
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        String query = "SELECT * FROM YEUCAUNGHIPHEP WHERE MAYCNP = ?";
        String ngKT = "";
        try{
            PreparedStatement pSt = conn.prepareStatement(query);
            pSt.setString(1, mayc);
            ResultSet rs = pSt.executeQuery();
            if(rs.next())
            {
                YEUCAUNGHIPHEP tmp = new YEUCAUNGHIPHEP();
                java.sql.Date tmpNGKT = rs.getObject("NGAYKT", java.sql.Date.class);
                
                tmp.setNgKT(tmpNGKT.toLocalDate());
                ngKT = tmp.getNgKT().toString();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return ngKT;
    }
    
    // XU LY YEU CAU NGHI PHEP
    public static void XuLyYeuCauNP(int maYC, int type)
    {
        Connection conn = new JDBCConnection().getJDBCConnection();
        String query = "call SP_XULYEUCAUNGHIPHEP(?,?)";
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
            try{
                if(conn != null)
                    conn.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
