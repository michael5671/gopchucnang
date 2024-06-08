package DTO;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class YEUCAUUNGLUONG {
    
    private int MaYC;
    private int MaNV;
    private LocalDate NgayGui;
    private long TienUng;
    private String GhiChu;
    private String TrangThai;
    //private LocalDate ngPheDuyet;
    
    public YEUCAUUNGLUONG()
    {
        this.MaYC = -1;
        this.MaNV = -1;
        this.NgayGui = LocalDate.of(2000,1, 1);
        this.TienUng = 0;
        this.GhiChu = "None.";
        this.TrangThai = "Chua phe duyet";
        //this.ngPheDuyet = LocalDate.of(2000, 1, 1);
    }
    
    public YEUCAUUNGLUONG(int ma, int nv, LocalDate ngayGui, long tien, String ghichu, String trangThai)
    {
        this.MaYC = ma;
        this.MaNV = nv;
        this.NgayGui = ngayGui;
        this.TienUng = tien;
        this.GhiChu = ghichu;
        this.TrangThai = trangThai;
       // this.ngPheDuyet = ngPheDuyet;
    }

    /**
     * @return the maYCUL
     */
    public int getMaYC() {
        return MaYC;
    }

    /**
     * @param maYC the maYCUL to set
     */
    public void setMaYC(int maYC) {
        this.MaYC = maYC;
    }

    /**
     * @return the maNV
     */
    public int getMaNV() {
        return MaNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.MaNV = maNV;
    }

    /**
     * @return the ngUL
     */
    public LocalDate getNgayGui() {
        return NgayGui;
    }

    /**
     * @param ngayGui the ngUL to set
     */
    public void setNgayGui(LocalDate ngayGui) {
        this.NgayGui = ngayGui;
    }

    /**
     * @return the tienUL
     */
    public long getTienUng() {
        return TienUng;
    }

    /**
     * @param tienUng the tienUL to set
     */
    public void setTienUng(long tienUng) {
        this.TienUng = tienUng;
    }

    /**
     * @return the ghiChuUL
     */
    public String getGhiChu() {
        return GhiChu;
    }

    /**
     * @param ghiChu the ghiChuUL to set
     */
    public void setGhiChu(String ghiChu) {
        this.GhiChu = ghiChu;
    }

    /**
     * @return the tThaiYCUL
     */
    public String getTrangThai() {
        return TrangThai;
    }

    /**
     * @param trangThai the tThaiYCUL to set
     */
    public void setTrangThai(String trangThai) {
        this.TrangThai = trangThai;
    }

    /**
     * @return the ngPheDuyet
     */
    /*
    public LocalDate getNgPheDuyet() {
        return ngPheDuyet;
    }
    */
    
    /**
     * @param ngPheDuyet the ngPheDuyet to set
     */
    
    /*
    public void setNgPheDuyet(LocalDate ngPheDuyet) {
        this.ngPheDuyet = ngPheDuyet;
    }
*/
    public String getStringNgayGui() {
        return NgayGui.getDayOfMonth() + "/" + NgayGui.getMonthValue() + "/" + NgayGui.getYear();
    }


}
