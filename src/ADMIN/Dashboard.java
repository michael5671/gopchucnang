/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN;

import DTO.Connect;

import java.sql.Connection;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author ADMIN
 */
public class Dashboard extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    
        Calendar c;
    Connection con;
    String[] ngay = {"","Chủ nhật","Thứ hai","Thứ ba","Thứ tư","Thứ năm","Thứ sáu","Thứ bảy"};

    public Dashboard( ) {
                c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        con = Connect.connect();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbChao = new javax.swing.JLabel();
        LbBuoiIcon = new javax.swing.JLabel();
        LbNgayThangNam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1055, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LbChao.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        LbChao.setText(getBuoi());
        add(LbChao, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 95, -1, 66));

        LbBuoiIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(getBuoiIcon())));
        add(LbBuoiIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 80, -1, -1));

        LbNgayThangNam.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        LbNgayThangNam.setText(ngay[c.get(Calendar.DAY_OF_WEEK)]+", ngày " +c.get(Calendar.DATE)+" Tháng " + (c.get(Calendar.MONTH)+1)+" năm "+ c.get(Calendar.YEAR));
        add(LbNgayThangNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 167, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/admin_wallpaper1.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 10, 1270, 720));
    }// </editor-fold>//GEN-END:initComponents
    private String getBuoi(){
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if(hour>6&&hour<=11) return "Chào buổi sáng";
        else if(hour>11&&hour<=14) return "Chào buổi trưa";
        else if(hour>14&&hour<18) return "Chào buổi chiều";
        else  return "Chào buổi tối";
    }
    private String getBuoiIcon(){
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if(hour>6&&hour<18) return "/Resources/mattroipng.png";
        else return "/Resources/mattrang.png";
    }
    public static void main(String args[]) {

                new Dashboard().setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbBuoiIcon;
    private javax.swing.JLabel LbChao;
    private javax.swing.JLabel LbNgayThangNam;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
