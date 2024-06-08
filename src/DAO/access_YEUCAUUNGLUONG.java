package DAO;

import DTO.YEUCAUUNGLUONG;
import DTO.Connect;
import USER.User;

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
        Connection conn = new Connect().connect();
        ArrayList<YEUCAUUNGLUONG> lstYEUCAUUNGLUONG = new ArrayList<>();
        try{
            String query = "SELECT * FROM YEUCAUUNGLUONG";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                YEUCAUUNGLUONG tmp = new YEUCAUUNGLUONG();
                java.sql.Date ngayUL = rs.getObject("NGAYUL", java.sql.Date.class );
                
                tmp.setMaYC(rs.getInt("MAYCUL"));
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setNgayGui(ngayUL.toLocalDate());
                tmp.setTienUng(rs.getLong("TIENUL"));
                tmp.setGhiChu(rs.getString("GHICHUUL"));
                tmp.setTrangThai(rs.getString("TRANGTHAIUL"));
                
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
        Connection conn = new Connect().connect();
        
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
                
                tmp.setMaYC(rs.getInt("MAYCUL"));
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setNgayGui(ngayUL.toLocalDate());
                tmp.setTienUng(rs.getLong("TIENUL"));
                tmp.setGhiChu(rs.getString("GHICHUUL"));
                tmp.setTrangThai(rs.getString("TRANGTHAIUL"));
                
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
        Connection conn = new Connect().connect();
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
        Connection conn = new Connect().connect();
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
        Connection conn = new Connect().connect();
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
        Connection conn = new Connect().connect();
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

    public static ArrayList<YEUCAUUNGLUONG> getYeuCauUngLuong() {
        ArrayList<YEUCAUUNGLUONG> al = new ArrayList<>();
        String sql = "SELECT * FROM YEUCAUUNGLUONG WHERE MANV=?";
        try (Connection con = Connect.connect(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, User.USERID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                al.add(new YEUCAUUNGLUONG(
                        rs.getInt("MAYCUL"),
                        rs.getInt("MANV"),
                        rs.getDate("NGAYUL").toLocalDate(),
                        rs.getInt("TIENUL"),
                        rs.getString("GHICHUUL"),
                        rs.getString("TRANGTHAIUL")
                ));
            }
            con.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e);
        }
        return al;
    }

    //Co gi check them constraint nha t ko biet dieu kien nen check so qua thoi
    public static void GuiYeuCauUngLuong(int MaNV,int Money,String LyDo){
        Calendar curentTime = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        java.sql.Date currentDate = new java.sql.Date(curentTime.getTimeInMillis());
        try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement("INSERT INTO YEUCAUUNGLUONG (MAYCUL, MANV, NGAYUL,TIENUL,GHICHUUL,TRANGTHAIUL) VALUES (?, ?, ?,?,?,?)")){

            int newMaPhieu;
            try (PreparedStatement pstmtMax = con.prepareStatement("SELECT MAX(MAYCUL) FROM YEUCAUUNGLUONG");
                 ResultSet rs = pstmtMax.executeQuery()) {
                if (rs.next()) {
                    newMaPhieu =  rs.getInt(1) + 1;
                } else {
                    newMaPhieu = 1;
                }
            }
            statement.setInt(1,newMaPhieu);
            statement.setInt(2,MaNV);
            statement.setDate(3,currentDate);
            statement.setInt(4,Money);
            statement.setString(5,LyDo);
            statement.setString(6, "Chờ phê duyệt");
            statement.executeUpdate();
        }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        }
    }

    public static void HuyYeuCau(int MaYC){
        try (Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement("BEGIN huy_yeu_cau_ung_luong(?); END;")){
            // Thiết lập tham số đầu vào
            statement.setInt(1, MaYC);
            statement.execute();
        } catch (Exception e) {
            System.err.println("Lỗi khi thực thi stored procedure: " + e.getMessage());
        }
    }
}
