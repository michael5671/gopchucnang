package Object;

import Home.Connect;
import Home.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class YeuCauUngLuong {
    private int MaYC, MaNV;
    private LocalDate NgayGui;
    private int TienUng;
    private String GhiChu, TrangThai;

    public YeuCauUngLuong(int MaYC, int MaNV, LocalDate NgayGui, int TienUng, String GhiChu, String TrangThai) {
        this.MaYC = MaYC;
        this.MaNV = MaNV;
        this.NgayGui = NgayGui;
        this.TienUng = TienUng;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
    }

    // Getters
    public int getMaYC() {
        return MaYC;
    }

    public int getMaNV() {
        return MaNV;
    }

    public int getTienUng() {
        return TienUng;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public String getNgayGui() {
        return NgayGui.getDayOfMonth() + "/" + NgayGui.getMonthValue() + "/" + NgayGui.getYear();
    }

    public static ArrayList<YeuCauUngLuong> getYeuCauUngLuong() {
        ArrayList<YeuCauUngLuong> al = new ArrayList<>();
        String sql = "SELECT * FROM YEUCAUUNGLUONG WHERE MANV=?";
        try (Connection con = Connect.connect(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, User.USERID); 
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                al.add(new YeuCauUngLuong(
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
            statement.setInt(4,Money);
            statement.setString(5,LyDo);
            statement.setString(6, "Chưa phê duyệt");
            statement.executeUpdate();
        }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        } 
    }
    
    private static String ThemYeuCau = "INSERT INTO YEUCAUUNGLUONG (MAYCUL, MANV, NGAYUL,TIENUL,GHICHUUL,TRANGTHAIUL) VALUES (?, ?, ?,?,?,?)";
    private static String MaxYeuCau = "SELECT MAX(MAYCUL) FROM YEUCAUUNGLUONG";
}
