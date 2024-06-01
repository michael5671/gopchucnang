/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PHONGBAN;
import DTO.TRUONGPHONG;
import Data.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author giaphu
 */
public class access_PHONGBAN {
    private Connection conn = new JDBCConnection().getJDBCConnection();
    public access_PHONGBAN() {
        
    }
    public ArrayList<PHONGBAN> getPHONGBAN() {
        ArrayList<PHONGBAN> listPB = new ArrayList<>();
        String sql = "SELECT PB.MAPB, PB.TENPB, PB.NGAYTL, TP.MANV, NV.TENNV " +
                     "FROM PHONGBAN PB " +
                     "LEFT JOIN TRUONGPHONG TP ON PB.MAPB = TP.MAPB " +
                     "LEFT JOIN NHANVIEN NV ON TP.MANV = NV.MANV";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PHONGBAN pb = new PHONGBAN();
                pb.setMaPB(rs.getString("MAPB"));
                pb.setTenPB(rs.getString("TENPB"));
                pb.setNgayTL(rs.getDate("NGAYTL"));

                TRUONGPHONG tp = new TRUONGPHONG();
                tp.setMaNV(rs.getInt("MANV"));
                tp.setTenTP(rs.getString("TENNV"));
                pb.setTruongPhong(tp);

                listPB.add(pb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPB;
    }
    public ArrayList<PHONGBAN> searchPHONGBAN(String searchName) throws SQLException {
        ArrayList<PHONGBAN> lstPHONGBAN = new ArrayList<>();
        String sql = "SELECT MAPB, TENPB, NGAYTL FROM PHONGBAN WHERE UPPER(TENPB) LIKE UPPER(?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + searchName + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    PHONGBAN pb = new PHONGBAN();
                    pb.setMaPB(rs.getString("MAPB"));
                    pb.setTenPB(rs.getString("TENPB"));
                    pb.setNgayTL(rs.getDate("NGAYTL"));
                    lstPHONGBAN.add(pb);
                }
            }
        }
        return lstPHONGBAN;
    }
    public void insertPHONGBAN(String tenPB, Date ngayTL) {
        String sql = "{call INSERTPHONGBAN(?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, tenPB);
            cs.setDate(2, ngayTL);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePHONGBAN(String maPB, String tenPB, Date ngayTL) {
        String sql = "{call UPDATEPHONGBAN(?, ?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, maPB);
            cs.setString(2, tenPB);
            cs.setDate(3, ngayTL);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePHONGBAN(String maPB) throws SQLException {
        String sql = "{call DELETEPHONGBAN(?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, maPB);
            cs.executeUpdate();
        }
    }
}
