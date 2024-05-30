package DTO;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class YEUCAUNGHIPHEP {
    private int maYCNP;
    private int maNV;
    private LocalDate ngGui;
    private LocalDate ngBD;
    private LocalDate ngKT;
    private String ghiChuNP;
    private String tThaiYCNP;
    
    public YEUCAUNGHIPHEP()
    {
        this.maYCNP = -1;
        this.maNV = -1;
        this.ngGui = LocalDate.of(2000,1, 1);
        this.ngBD = LocalDate.of(2000,1, 1);
        this.ngKT = LocalDate.of(2000,1, 1);
        this.ghiChuNP = "None.";
        this.tThaiYCNP = "Chua phe duyet";
    }
    
    public YEUCAUNGHIPHEP(int ma, int nv, LocalDate ngGui, LocalDate ngBD, LocalDate ngKT, String ghiChu, String trangThai)
    {
        this.maYCNP = ma;
        this.maNV = nv;
        this.ngGui = ngGui;
        this.ngBD = ngBD;
        this.ngKT = ngKT;
        this.ghiChuNP = ghiChu;
        this.tThaiYCNP = trangThai;
    }

    /**
     * @return the maYCNP
     */
    public int getMaYCNP() {
        return maYCNP;
    }

    /**
     * @param maYCNP the maYCNP to set
     */
    public void setMaYCNP(int maYCNP) {
        this.maYCNP = maYCNP;
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
     * @return the ngGui
     */
    public LocalDate getNgGui() {
        return ngGui;
    }

    /**
     * @param ngGui the ngGui to set
     */
    public void setNgGui(LocalDate ngGui) {
        this.ngGui = ngGui;
    }

    /**
     * @return the ngBD
     */
    public LocalDate getNgBD() {
        return ngBD;
    }

    /**
     * @param ngBD the ngBD to set
     */
    public void setNgBD(LocalDate ngBD) {
        this.ngBD = ngBD;
    }

    /**
     * @return the ngKT
     */
    public LocalDate getNgKT() {
        return ngKT;
    }

    /**
     * @param ngKT the ngKT to set
     */
    public void setNgKT(LocalDate ngKT) {
        this.ngKT = ngKT;
    }

    /**
     * @return the ghiChuNP
     */
    public String getGhiChuNP() {
        return ghiChuNP;
    }

    /**
     * @param ghiChuNP the ghiChuNP to set
     */
    public void setGhiChuNP(String ghiChuNP) {
        this.ghiChuNP = ghiChuNP;
    }

    /**
     * @return the tThaiYCNP
     */
    public String gettThaiYCNP() {
        return tThaiYCNP;
    }

    /**
     * @param tThaiYCNP the tThaiYCNP to set
     */
    public void settThaiYCNP(String tThaiYCNP) {
        this.tThaiYCNP = tThaiYCNP;
    }
}
