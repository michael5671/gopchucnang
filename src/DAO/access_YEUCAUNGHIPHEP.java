package DAO;

import DTO.YEUCAUNGHIPHEP;
import DTO.Connect;
import USER.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author ADMIN
 */
public class access_YEUCAUNGHIPHEP {
    // LAY DANH SACH YEU CAU NGHI PHEP
    public static ArrayList<YEUCAUNGHIPHEP> getYEUCAUNGHIPHEP()
    {
        Connection conn = new Connect().connect();
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
                
                tmp.setMaYC(rs.getInt("MAYCNP"));
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setNgayGui(ngayGui.toLocalDate());
                tmp.setNgayBD(ngayBD.toLocalDate());
                tmp.setNgayKT(ngayKT.toLocalDate());
                tmp.setLyDo(rs.getString("GHICHUNP"));
                tmp.setTrangThai(rs.getString("TRANGTHAINP"));
                
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
        Connection conn = new Connect().connect();
        
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
                
                tmp.setMaYC(rs.getInt("MAYCNP"));
                tmp.setMaNV(rs.getInt("MANV"));
                tmp.setNgayGui(ngayGui.toLocalDate());
                tmp.setNgayBD(ngayBD.toLocalDate());
                tmp.setNgayKT(ngayKT.toLocalDate());
                tmp.setLyDo(rs.getString("GHICHUNP"));
                tmp.setTrangThai(rs.getString("TRANGTHAINP"));
                
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
        Connection conn = new Connect().connect();
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
        Connection conn = new Connect().connect();
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
                
                tmp.setNgayBD(tmpNGBD.toLocalDate());
                
                ngBD = tmp.getNgayBD().toString();
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
        Connection conn = new Connect().connect();
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
                
                tmp.setNgayKT(tmpNGKT.toLocalDate());
                ngKT = tmp.getNgayKT().toString();
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
        Connection conn = new Connect().connect();
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

    public static ArrayList<YEUCAUNGHIPHEP> getYeuCauNghiPhep()
    {

        ArrayList<YEUCAUNGHIPHEP> al = new ArrayList<>();
        String sql = "SELECT * FROM YEUCAUNGHIPHEP WHERE MANV=?";
        try(Connection con = Connect.connect(); PreparedStatement statement = con.prepareStatement(sql)){
            statement.setInt(1, User.USERID);
            ResultSet rs= statement.executeQuery();
            while(rs.next()){
                al.add(new YEUCAUNGHIPHEP(rs.getInt("MAYCNP"),rs.getInt("MANV"),rs.getObject("NGAYGUI", Date.class).toLocalDate(),rs.getObject("NGAYBD", Date.class).toLocalDate(),rs.getObject("NGAYKT", Date.class).toLocalDate(),rs.getString("GHICHUNP"),rs.getString("TRANGTHAINP")));
            }
            con.close();
            statement.close();
        }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        }
        return al;
    }

    //Co gi check them constraint nha t ko biet dieu kien nen check so qua thoi
    public static void GuiYeuCauNghiPhep(int MaNV, Calendar NgayBD, Calendar NgayKT, String LyDo){
        Calendar curentTime = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        Date currentDate = new Date(curentTime.getTimeInMillis());
        try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement(ThemYeuCau)){

            int newMaPhieu;
            try (PreparedStatement pstmtMax = con.prepareStatement(MaxYeuCau);
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
            statement.setDate(4,new Date(NgayBD.getTimeInMillis()));
            statement.setDate(5,new Date(NgayKT.getTimeInMillis()));
            statement.setString(6, LyDo);
            statement.setString(7, "Chờ phê duyệt");
            statement.executeUpdate();
        }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        }
    }

    public static void HuyYeuCau(int MaYC){
        try (Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement("BEGIN huy_yeu_cau_nghi_phep(?); END;")){
            // Thiết lập tham số đầu vào
            statement.setInt(1, MaYC);
            statement.execute();
        } catch (Exception e) {
            System.err.println("Lỗi khi thực thi stored procedure: " + e.getMessage());
        }
    }
    private static String ThemYeuCau = "INSERT INTO YEUCAUNGHIPHEP (MAYCNP, MANV, NGAYGUI,NGAYBD,NGAYKT,GHICHUNP,TRANGTHAINP) VALUES (?, ?, ?,?,?,?,?)";
    private static String MaxYeuCau = "SELECT MAX(MAYCNP) FROM YEUCAUNGHIPHEP";
}
