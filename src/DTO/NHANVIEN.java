package DTO;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class NHANVIEN {
    private int maNV;
    private String maPB;
    private String tenNV;
    private String CCCD;
    private LocalDate ngSinh;
    private String queQuan;
    private boolean gioiTinh;
    private String chucVu;
    private long luongCB;
    private double heSo;
    
    public NHANVIEN()
    {
        this.maNV = -1;
        this.maPB = "None";
        this.tenNV = "None";
        this.CCCD = "None";
        this.ngSinh = LocalDate.of(2000, 1, 1);
        this.queQuan = "None";
        this.gioiTinh = false;
        this.chucVu = "None";
        this.luongCB = 0;
        this.heSo = 0;
    }
    
    
    public NHANVIEN(int maNV, String maPB, String tenNV, String CCCD, LocalDate dob, String que, boolean gt, String chucVu, long luongCB, double heSo)
    {
        this.maNV = maNV;
        this.maPB = maPB;
        this.tenNV = tenNV;
        this.CCCD = CCCD;
        this.ngSinh = dob;
        this.queQuan = que;
        this.gioiTinh = gt;
        this.chucVu = chucVu;
        this.luongCB = luongCB;
        this.heSo = heSo;
    }

    /**
     * @return the maNV
     */
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the maPB
     */
    public String getMaPB() {
        return maPB;
    }

    /**
     * @param maPB the maPB to set
     */
    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    /**
     * @return the tenNV
     */
    public String getTenNV() {
        return tenNV;
    }

    /**
     * @param tenNV the tenNV to set
     */
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    /**
     * @return the CCCD
     */
    public String getCCCD() {
        return CCCD;
    }

    /**
     * @param CCCD the CCCD to set
     */
    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    /**
     * @return the ngSinh
     */
    public LocalDate getNgSinh() {
        return ngSinh;
    }

    /**
     * @param ngSinh the ngSinh to set
     */
    public void setNgSinh(LocalDate ngSinh) {
        this.ngSinh = ngSinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the gioiTinh
     */
    public boolean isGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the chucVu
     */
    public String getChucVu() {
        return chucVu;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    /**
     * @return the luongCB
     */
    public long getLuongCB() {
        return luongCB;
    }

    /**
     * @param luongCB the luongCB to set
     */
    public void setLuongCB(long luongCB) {
        this.luongCB = luongCB;
    }

    /**
     * @return the heSo
     */
    public double getHeSo() {
        return heSo;
    }

    /**
     * @param heSo the heSo to set
     */
    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }
    
    public double tinhLuongNgay() {
        return (luongCB * heSo) / 25;
    }
}
