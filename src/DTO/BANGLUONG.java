/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author giaphu
 */
public class BANGLUONG {
    private int maBL;
    private int maNV;
    private int nam;
    private int thang;
    private long tongTienUL;
    private long luongTL;
    private String tenNV;

    public BANGLUONG(int maBL, int maNV, int nam, int thang, long tongTienUL, long luongTL, String tenNV) {
        this.maBL = maBL;
        this.maNV = maNV;
        this.nam = nam;
        this.thang = thang;
        this.tongTienUL = tongTienUL;
        this.luongTL = luongTL;
        this.tenNV = tenNV;
    }

    public BANGLUONG() {
    }

    public int getMaBL() {
        return maBL;
    }

    public void setMaBL(int maBL) {
        this.maBL = maBL;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public long getTongTienUL() {
        return tongTienUL;
    }

    public void setTongTienUL(long tongTienUL) {
        this.tongTienUL = tongTienUL;
    }

    public long getLuongTL() {
        return luongTL;
    }

    public void setLuongTL(long luongTL) {
        this.luongTL = luongTL;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
    
    public String getFormattedLuongTL() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(luongTL);
    }
}
