package DTO;

/**
 *
 * @author ADMIN
 */
public class TAIKHOAN {
    private String tenTK;
    private int maNV;
    private String matKhau;
    private int loaiTK;
    
    public TAIKHOAN()
    {
        tenTK = "None";
        maNV =  0;
        matKhau = "None";
        loaiTK = 2;
    }
    
    public TAIKHOAN(String tenTK, int maNV, String matKhau, int loaiTK)
    {
        this.tenTK = tenTK;
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
    }

    /**
     * @return the tenTK
     */
    public String getTenTK() {
        return tenTK;
    }

    /**
     * @param tenTK the tenTK to set
     */
    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
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
     * @return the matKhau
     */
    public String getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    /**
     * @return the loaiTK
     */
    public int getLoaiTK() {
        return loaiTK;
    }

    /**
     * @param loaiTK the loaiTK to set
     */
    public void setLoaiTK(int loaiTK) {
        this.loaiTK = loaiTK;
    }
}
