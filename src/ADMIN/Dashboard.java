/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN;

import Home.Connect;
import Home.Home;
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

        HomePanel = new javax.swing.JPanel();
        LbChao = new javax.swing.JLabel();
        LbNgayThangNam = new javax.swing.JLabel();
        LbBuoiIcon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1055, 768));

        HomePanel.setBackground(new java.awt.Color(255, 255, 255));
        HomePanel.setPreferredSize(new java.awt.Dimension(1280, 655));

        LbChao.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        LbChao.setText(getBuoi());

        LbNgayThangNam.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        LbNgayThangNam.setText(ngay[c.get(Calendar.DAY_OF_WEEK)]+", ngày " +c.get(Calendar.DATE)+" Tháng " + (c.get(Calendar.MONTH)+1)+" năm "+ c.get(Calendar.YEAR));

        LbBuoiIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(getBuoiIcon())));

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbNgayThangNam)
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addComponent(LbChao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbBuoiIcon)))
                .addContainerGap(391, Short.MAX_VALUE))
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(LbChao, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LbBuoiIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbNgayThangNam)
                .addContainerGap(473, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(HomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(HomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addContainerGap())
        );
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
        if(hour>6&&hour<18) return "/Home/mattroipng.png";
        else return "/Home/mattrang.png";
    }
    public static void main(String args[]) {

                new Dashboard().setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomePanel;
    private javax.swing.JLabel LbBuoiIcon;
    private javax.swing.JLabel LbChao;
    private javax.swing.JLabel LbNgayThangNam;
    // End of variables declaration//GEN-END:variables
}
