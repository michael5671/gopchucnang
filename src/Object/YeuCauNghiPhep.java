/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import Home.Connect;
import Home.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Phuc
 */
public class YeuCauNghiPhep {
    private int MaYC,MaNV;
    private LocalDate NgayGui,NgayBD, NgayKT;
    private String LyDo,TrangThai;

    public YeuCauNghiPhep(int MaYC, int MaNV,LocalDate NgayGui, LocalDate NgayBD, LocalDate NgayKT, String LyDo, String TrangThai) {
        this.MaYC = MaYC;
        this.MaNV = MaNV;
        this.NgayGui=NgayGui;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.LyDo = LyDo;
        this.TrangThai = TrangThai;
    }

    public int getMaYC() {
        return MaYC;
    }

    public int getMaNV() {
        return MaNV;
    }

    public String getLyDo() {
        return LyDo;
    }

    public String getTrangThai() {
        return TrangThai;
    }
    public String getNgayBD(){
        return NgayBD.getDayOfMonth()+"/"+NgayBD.getMonthValue()+"/"+NgayBD.getYear();
    }
    public String getNgayKT(){
        return NgayKT.getDayOfMonth()+"/"+NgayKT.getMonthValue()+"/"+NgayKT.getYear();
    }
    public String getNgayGui(){
        return NgayGui.getDayOfMonth()+"/"+NgayGui.getMonthValue()+"/"+NgayGui.getYear();
    }
    
    public static ArrayList<YeuCauNghiPhep> getYeuCauNghiPhep()
    {
        
        ArrayList<YeuCauNghiPhep> al = new ArrayList<>();
        String sql = "SELECT * FROM YEUCAUNGHIPHEP WHERE MANV=?";
        try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement(sql)){
            statement.setInt(1,User.USERID);
            ResultSet rs= statement.executeQuery();
            while(rs.next()){
                al.add(new YeuCauNghiPhep(rs.getInt("MAYCNP"),rs.getInt("MANV"),rs.getObject("NGAYGUI", java.sql.Date.class).toLocalDate(),rs.getObject("NGAYBD", java.sql.Date.class).toLocalDate(),rs.getObject("NGAYKT", java.sql.Date.class).toLocalDate(),rs.getString("GHICHUNP"),rs.getString("TRANGTHAINP")));
            }
            con.close();
            statement.close();
            }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        }
        return al;
    }
    //Co gi check them constraint nha t ko biet dieu kien nen check so qua thoi
    public static void GuiYeuCauNghiPhep(int MaNV,Calendar NgayBD, Calendar NgayKT, String LyDo){
        Calendar curentTime = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        java.sql.Date currentDate = new java.sql.Date(curentTime.getTimeInMillis());
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
            statement.setDate(4,new java.sql.Date(NgayBD.getTimeInMillis()));
            statement.setDate(5,new java.sql.Date(NgayKT.getTimeInMillis()));
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
