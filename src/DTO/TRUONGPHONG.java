/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author giaphu
 */
public class TRUONGPHONG {
    private int maNV;
    private String maPB;
    private Date ngayNC;
    private String tenTP;
    
    public TRUONGPHONG(){
        
    }
     public TRUONGPHONG(int maNV, String maPB, Date ngayNC, String tenTP) {
        this.maNV = maNV;
        this.maPB = maPB;
        this.ngayNC = ngayNC;
        this.tenTP = tenTP;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public Date getNgayNC() {
        return ngayNC;
    }

    public void setNgayNC(Date ngayNC) {
        this.ngayNC = ngayNC;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }
}