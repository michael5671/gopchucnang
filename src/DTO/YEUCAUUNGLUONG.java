package DTO;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class YEUCAUUNGLUONG {
    
    private int maYCUL;
    private int maNV;
    private LocalDate ngUL;
    private long tienUL;
    private String ghiChuUL;
    private String tThaiYCUL;
    //private LocalDate ngPheDuyet;
    
    public YEUCAUUNGLUONG()
    {
        this.maYCUL = -1;
        this.maNV = -1;
        this.ngUL = LocalDate.of(2000,1, 1);
        this.tienUL = 0;
        this.ghiChuUL = "None.";
        this.tThaiYCUL = "Chua phe duyet";
        //this.ngPheDuyet = LocalDate.of(2000, 1, 1);
    }
    
    public YEUCAUUNGLUONG(int ma, int nv, LocalDate ngayGui, long tien, String ghichu, String trangThai)
    {
        this.maYCUL = ma;
        this.maNV = nv;
        this.ngUL = ngayGui;
        this.tienUL = tien;
        this.ghiChuUL = ghichu;
        this.tThaiYCUL = trangThai;
       // this.ngPheDuyet = ngPheDuyet;
    }

    /**
     * @return the maYCUL
     */
    public int getMaYCUL() {
        return maYCUL;
    }

    /**
     * @param maYCUL the maYCUL to set
     */
    public void setMaYCUL(int maYCUL) {
        this.maYCUL = maYCUL;
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
     * @return the ngUL
     */
    public LocalDate getNgUL() {
        return ngUL;
    }

    /**
     * @param ngUL the ngUL to set
     */
    public void setNgUL(LocalDate ngUL) {
        this.ngUL = ngUL;
    }

    /**
     * @return the tienUL
     */
    public long getTienUL() {
        return tienUL;
    }

    /**
     * @param tienUL the tienUL to set
     */
    public void setTienUL(long tienUL) {
        this.tienUL = tienUL;
    }

    /**
     * @return the ghiChuUL
     */
    public String getGhiChuUL() {
        return ghiChuUL;
    }

    /**
     * @param ghiChuUL the ghiChuUL to set
     */
    public void setGhiChuUL(String ghiChuUL) {
        this.ghiChuUL = ghiChuUL;
    }

    /**
     * @return the tThaiYCUL
     */
    public String gettThaiYCUL() {
        return tThaiYCUL;
    }

    /**
     * @param tThaiYCUL the tThaiYCUL to set
     */
    public void settThaiYCUL(String tThaiYCUL) {
        this.tThaiYCUL = tThaiYCUL;
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
    
}
