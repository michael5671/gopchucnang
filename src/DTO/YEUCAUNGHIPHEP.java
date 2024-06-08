package DTO;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class YEUCAUNGHIPHEP {
    private int MaYC;
    private int MaNV;
    private LocalDate NgayGui;
    private LocalDate NgayBD;
    private LocalDate NgayKT;
    private String LyDo;
    private String TrangThai;
    
    public YEUCAUNGHIPHEP()
    {
        this.MaYC = -1;
        this.MaNV = -1;
        this.NgayGui = LocalDate.of(2000,1, 1);
        this.NgayBD = LocalDate.of(2000,1, 1);
        this.NgayKT = LocalDate.of(2000,1, 1);
        this.LyDo = "None.";
        this.TrangThai = "Chua phe duyet";
    }
    
    public YEUCAUNGHIPHEP(int ma, int nv, LocalDate NgayGui, LocalDate NgayBD, LocalDate NgayKT, String ghiChu, String trangThai)
    {
        this.MaYC = ma;
        this.MaNV = nv;
        this.NgayGui = NgayGui;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.LyDo = ghiChu;
        this.TrangThai = trangThai;
    }

    /**
     * @return the maYCNP
     */
    public int getMaYC() {
        return MaYC;
    }

    /**
     * @param maYC the maYCNP to set
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
     * @return the ngGui
     */
    public LocalDate getNgayGui() {
        return NgayGui;
    }

    /**
     * @param ngayGui the ngGui to set
     */
    public void setNgayGui(LocalDate ngayGui) {
        this.NgayGui = ngayGui;
    }

    /**
     * @return the ngBD
     */
    public LocalDate getNgayBD() {
        return NgayBD;
    }

    /**
     * @param ngayBD the ngBD to set
     */
    public void setNgayBD(LocalDate ngayBD) {
        this.NgayBD = ngayBD;
    }

    /**
     * @return the ngKT
     */
    public LocalDate getNgayKT() {
        return NgayKT;
    }

    /**
     * @param ngayKT the ngKT to set
     */
    public void setNgayKT(LocalDate ngayKT) {
        this.NgayKT = ngayKT;
    }

    /**
     * @return the ghiChuNP
     */
    public String getLyDo() {
        return LyDo;
    }

    /**
     * @param lyDo the ghiChuNP to set
     */
    public void setLyDo(String lyDo) {
        this.LyDo = lyDo;
    }

    /**
     * @return the tThaiYCNP
     */
    public String getTrangThai() {
        return TrangThai;
    }

    /**
     * @param trangThai the tThaiYCNP to set
     */
    public void setTrangThai(String trangThai) {
        this.TrangThai = trangThai;
    }
    public String getStringNgayBD(){
        return NgayBD.getDayOfMonth()+"/"+NgayBD.getMonthValue()+"/"+NgayBD.getYear();
    }
    public String getStringNgayKT(){
        return NgayKT.getDayOfMonth()+"/"+NgayKT.getMonthValue()+"/"+NgayKT.getYear();
    }
    public String getStringNgayGui(){
        return NgayGui.getDayOfMonth()+"/"+NgayGui.getMonthValue()+"/"+NgayGui.getYear();
    }

    private static String ThemYeuCau = "INSERT INTO YEUCAUNGHIPHEP (MAYCNP, MANV, NGAYGUI,NGAYBD,NGAYKT,GHICHUNP,TRANGTHAINP) VALUES (?, ?, ?,?,?,?,?)";
    private static String MaxYeuCau = "SELECT MAX(MAYCNP) FROM YEUCAUNGHIPHEP";
}
