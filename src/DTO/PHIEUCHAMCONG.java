/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.time.LocalDate;

import USER.User;
import java.sql.PreparedStatement;
/**
 *
 * @author Phuc
 */
public class PHIEUCHAMCONG {
    private int MAPCC,MaNV;
    private LocalDate TGChamCong;
    public PHIEUCHAMCONG(int MAPCC, int MaNV, LocalDate TGChamCong) {
        this.MAPCC = MAPCC;
        this.MaNV = MaNV;
        this.TGChamCong = TGChamCong;
    }

    public int getMAPCC() {
        return MAPCC;
    }

    public void setMAPCC(int MAPCC) {
        this.MAPCC = MAPCC;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }
    public int getNgay(){
        return TGChamCong.getDayOfMonth();
    }
    public int getThang(){
        return TGChamCong.getMonthValue();
    }
    public int getNam(){
        return TGChamCong.getYear();
    }
    public LocalDate getTGChamCong() {
        return TGChamCong;
    }
    public void setTGChamCong(LocalDate TGChamCong) {
        this.TGChamCong = TGChamCong;
    }
    public static ArrayList<PHIEUCHAMCONG> getPhieuChamCong()
    {
        
        ArrayList<PHIEUCHAMCONG> al = new ArrayList<>();
        String sql = "SELECT * FROM PHIEUCHAMCONG WHERE MANV=?";
        try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement(sql)){
            statement.setInt(1,User.USERID);
            ResultSet rs= statement.executeQuery();
            while(rs.next()){
                al.add(new PHIEUCHAMCONG(rs.getInt(1),rs.getInt(2),rs.getObject("NGAYCC", java.sql.Date.class).toLocalDate()));
            }
            con.close();
            statement.close();
            }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        }
        return al;
    }
     public static ArrayList<PHIEUCHAMCONG> getPhieuChamCong(int MaKC, int Thang, int Nam)
    {
        
            ArrayList<PHIEUCHAMCONG> al = new ArrayList<>();

        String sql = "SELECT * FROM PHIEUCHAMCONG WHERE 1=1";
        if (MaKC != 0) {
            sql = sql.concat(" AND MAPCC = " + MaKC); //
        }
        if (Thang != 0) {
            sql = sql.concat(" AND EXTRACT(MONTH FROM NGAYCC) = " + Thang);
        }
        if (Nam != 0) {
            sql = sql.concat(" AND EXTRACT(YEAR FROM NGAYCC) = " + Nam);
        }
            try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement(sql)){
                ResultSet rs= statement.executeQuery();
                while(rs.next()){
                    al.add(new PHIEUCHAMCONG(rs.getInt(1),rs.getInt(2),rs.getObject("NGAYCC", java.sql.Date.class).toLocalDate()));
                }
                con.close();
                statement.close();
                }catch(SQLException e1){
                System.out.println("Loi"+ e1);
            }
            return al;
        }
            public static ArrayList<PHIEUCHAMCONG> getAllPhieuChamCong()
        {

            ArrayList<PHIEUCHAMCONG> al = new ArrayList<>();
            String sql = "SELECT * FROM PHIEUCHAMCONG";
            try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement(sql)){
                ResultSet rs= statement.executeQuery();
                while(rs.next()){
                    al.add(new PHIEUCHAMCONG(rs.getInt(1),rs.getInt(2),rs.getObject("NGAYCC", java.sql.Date.class).toLocalDate()));
                }
                con.close();
                statement.close();
                }catch(SQLException e1){
                System.out.println("Loi"+ e1);
            }
            return al;
    }
    public static boolean TinhTrangChamCong(int MaNV,int Ngay,int Thang, int Nam){
        try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement(TinhTrangQuery)){
            statement.setInt(1,MaNV);
            statement.setInt(2,Ngay);
            statement.setInt(3,Thang);
            statement.setInt(4,Nam);
            ResultSet rs= statement.executeQuery();
            return rs.next();
        }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        }
        return false;
    }
        public static void XoaPhieu(int MAPCC){
        String sql= "DELETE FROM PHIEUCHAMCONG WHERE MAPCC = ?";
        try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement(sql)){
            statement.setInt(1,MAPCC);
            statement.executeUpdate();
        }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        }        

    }
    public static void ChamCongHomNay(int MaNV){
        try(Connection con = Connect.connect();PreparedStatement statement = con.prepareStatement("call them_phieu_cham_cong(?)")){
            statement.setInt(1,MaNV);
            statement.executeUpdate();
        }catch(SQLException e1){
            System.out.println("Loi"+ e1);
        }
    }
    private static String TinhTrangQuery = "SELECT * FROM PHIEUCHAMCONG WHERE MANV=? AND EXTRACT(DAY FROM NGAYCC) = ? AND EXTRACT(MONTH FROM NGAYCC) = ? AND EXTRACT(YEAR FROM NGAYCC) = ?";
    private static String ThemPhieu = "INSERT INTO PHIEUCHAMCONG (MAPCC, MANV, NGAYCC) VALUES (?, ?, ?)";
    private static String MaxMAPCC = "SELECT MAX(MAPCC) FROM PHIEUCHAMCONG";
}
