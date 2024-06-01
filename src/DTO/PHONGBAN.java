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
public class PHONGBAN {
    private String maPB;
    private String tenPB;
    private Date ngayTL;
    private TRUONGPHONG truongPhong;

    public PHONGBAN() {
    }

    public PHONGBAN(String maPB, String tenPB, Date ngayTL, TRUONGPHONG truongPhong) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.ngayTL = ngayTL;
        this.truongPhong = truongPhong;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public Date getNgayTL() {
        return ngayTL;
    }

    public void setNgayTL(Date ngayTL) {
        this.ngayTL = ngayTL;
    }

    public TRUONGPHONG getTruongPhong() {
        return truongPhong;
    }

    public void setTruongPhong(TRUONGPHONG truongPhong) {
        this.truongPhong = truongPhong;
    }
}
