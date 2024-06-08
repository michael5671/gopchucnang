/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.BANGLUONG;
import  java.sql.*;
import DTO.Connect;
 
/**
 *
 * @author giaphu
 */
import java.util.ArrayList;
public class access_BANGLUONG {
    private Connection connection;
    
    public access_BANGLUONG() {
        this.connection = Connect.connect();
    }
    public void addBangLuong(BANGLUONG bangLuong) throws SQLException {
        String query = "{CALL add_bangluong(?, ?, ?, ?, ?)}";
        CallableStatement cstmt = connection.prepareCall(query);
        cstmt.setInt(1, bangLuong.getMaNV());
        cstmt.setInt(2, bangLuong.getNam());
        cstmt.setInt(3, bangLuong.getThang());
        cstmt.setLong(4, bangLuong.getTongTienUL());
        cstmt.setLong(5, bangLuong.getLuongTL());
        cstmt.execute();
        cstmt.close();
    }
    public ArrayList<BANGLUONG> getAllBangLuong() throws SQLException {
        ArrayList<BANGLUONG> bangLuongList = new ArrayList<>();
        String query = "SELECT b.MABL, b.MANV, b.NAM, b.THANG, b.TONGTIENUL, b.LUONGTL, n.TENNV " +
                       "FROM BANGLUONG b " +
                       "JOIN NHANVIEN n ON b.MANV = n.MANV";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            BANGLUONG bangLuong = new BANGLUONG();
            bangLuong.setMaBL(rs.getInt("MABL"));
            bangLuong.setMaNV(rs.getInt("MANV"));
            bangLuong.setNam(rs.getInt("NAM"));
            bangLuong.setThang(rs.getInt("THANG"));
            bangLuong.setTongTienUL(rs.getLong("TONGTIENUL"));
            bangLuong.setLuongTL(rs.getLong("LUONGTL"));
            bangLuong.setTenNV(rs.getString("TENNV"));
            bangLuongList.add(bangLuong);
        }

        rs.close();
        stmt.close();
        return bangLuongList;
    }
 
    public long[] getLuongCoBanVaHeSo(int maNV) throws SQLException {
        String query = "SELECT LUONGCB, HESO FROM NHANVIEN WHERE MANV = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, maNV);
        ResultSet rs = pstmt.executeQuery();
        long[] result = new long[2];
        if (rs.next()) {
            result[0] = rs.getLong("LUONGCB");
            result[1] = rs.getLong("HESO");
        }
        rs.close();
        pstmt.close();
        return result;
    }

    public long getTongTienUL(int maNV, int nam, int thang) throws SQLException {
        String query = "SELECT SUM(TIENUL) AS TONGTIENUL FROM YEUCAUUNGLUONG WHERE MANV = ? AND EXTRACT(YEAR FROM NGAYUL) = ? AND EXTRACT(MONTH FROM NGAYUL) = ? AND TRANGTHAIUL = 'Đã phê duyệt'";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, maNV);
        pstmt.setInt(2, nam);
        pstmt.setInt(3, thang);
        ResultSet rs = pstmt.executeQuery();
        long tongTienUL = 0;
        if (rs.next()) {
            tongTienUL = rs.getLong("TONGTIENUL");
        }
        rs.close();
        pstmt.close();
        return tongTienUL;
    }

    public int getSoNgayCong(int maNV, int nam, int thang) throws SQLException {
        String query = "SELECT COUNT(*) AS SONGAYCONG FROM PHIEUCHAMCONG WHERE MANV = ? AND EXTRACT(YEAR FROM NGAYCC) = ? AND EXTRACT(MONTH FROM NGAYCC) = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, maNV);
        pstmt.setInt(2, nam);
        pstmt.setInt(3, thang);
        ResultSet rs = pstmt.executeQuery();
        int soNgayCong = 0;
        if (rs.next()) {
            soNgayCong = rs.getInt("SONGAYCONG");
        }
        rs.close();
        pstmt.close();
        return soNgayCong;
    }
    public ArrayList<BANGLUONG> findBangLuong(Integer maNV, Integer thang, Integer nam) throws SQLException {
        ArrayList<BANGLUONG> bangLuongList = new ArrayList<>();
    Connection connection = Connect.connect();
    StringBuilder query = new StringBuilder("SELECT * FROM BANGLUONG WHERE 1=1");

    if (maNV != null) {
        query.append(" AND MANV = ?");
    }
    if (thang != null) {
        query.append(" AND THANG = ?");
    }
    if (nam != null) {
        query.append(" AND NAM = ?");
    }

    PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
    int paramIndex = 1;

    if (maNV != null) {
        preparedStatement.setInt(paramIndex++, maNV);
    }
    if (thang != null) {
        preparedStatement.setInt(paramIndex++, thang);
    }
    if (nam != null) {
        preparedStatement.setInt(paramIndex++, nam);
    }

    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
        BANGLUONG bangLuong = new BANGLUONG();
        bangLuong.setMaBL(resultSet.getInt("MABL"));
        bangLuong.setMaNV(resultSet.getInt("MANV"));
        bangLuong.setNam(resultSet.getInt("NAM"));
        bangLuong.setThang(resultSet.getInt("THANG"));
        bangLuong.setTongTienUL(resultSet.getLong("TONGTIENUL"));
        bangLuong.setLuongTL(resultSet.getLong("LUONGTL"));
        bangLuongList.add(bangLuong);
    }
    return bangLuongList;
    }

}
