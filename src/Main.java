import USER.Login.*;

/**
 *
 * @author ADMIN
 */
public class Main {
        public static void main(String[] args)
        {
            DangNhapForm foDangNhap = new DangNhapForm();
            foDangNhap.setVisible(true);
            
            // Chua gon cac Control
            foDangNhap.pack();
            foDangNhap.setLocationRelativeTo(null);
        }
}
