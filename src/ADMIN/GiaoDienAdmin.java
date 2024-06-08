package ADMIN;

import static DAO.access_TAIKHOAN.getTenNVfromTenTK;
import USER.Login.DangNhapForm;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class GiaoDienAdmin extends javax.swing.JFrame {
        private String currentUser;
    /**
     * Creates new form GiaoDienAdmin
     */
    public GiaoDienAdmin( String currentUser ) {
        initComponents();
        
        this.currentUser = currentUser;
        lbCurrentUser.setText(getTenNVfromTenTK(currentUser));
        lbCurrentUser.setHorizontalAlignment(JLabel.CENTER); 
        
        lbGDChung.setForeground(new Color(34,103,255));
        Dashboard ds = new Dashboard();
        Component oldPanel = tabController.getSelectedComponent();
        tabController.setComponentAt(tabController.indexOfComponent(oldPanel), ds);
        tabController.validate();
        tabController.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JPanel();
        lbQLNV = new javax.swing.JLabel();
        lbQuanLyPB = new javax.swing.JLabel();
        lbQuanLyCC = new javax.swing.JLabel();
        lbQLYCNP = new javax.swing.JLabel();
        lbQLYCTL = new javax.swing.JLabel();
        lbTinhLuong = new javax.swing.JLabel();
        lbGDChung = new javax.swing.JLabel();
        lbCurrentUser = new javax.swing.JLabel();
        lbDangXuat = new javax.swing.JLabel();
        lbADMIN = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tabController = new javax.swing.JTabbedPane();
        panelDashboard = new javax.swing.JPanel();
        panelQLNV = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelQLPB = new javax.swing.JPanel();
        panelQLCC = new javax.swing.JPanel();
        panelQLYCNP = new javax.swing.JPanel();
        panelQLYCUL = new javax.swing.JPanel();
        panelQLTC = new javax.swing.JPanel();
        panelTinhLuong = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 768));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setPreferredSize(new java.awt.Dimension(225, 768));

        lbQLNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/employee.png"))); // NOI18N
        lbQLNV.setText("Quản lý nhân viên");
        lbQLNV.setIconTextGap(12);
        lbQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLNVMouseClicked(evt);
            }
        });

        lbQuanLyPB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbQuanLyPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/department.png"))); // NOI18N
        lbQuanLyPB.setText("Quản lý phòng ban");
        lbQuanLyPB.setIconTextGap(12);
        lbQuanLyPB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuanLyPBMouseClicked(evt);
            }
        });

        lbQuanLyCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbQuanLyCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/timesheets.png"))); // NOI18N
        lbQuanLyCC.setText("Quản lý chấm công");
        lbQuanLyCC.setIconTextGap(12);
        lbQuanLyCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuanLyCCMouseClicked(evt);
            }
        });

        lbQLYCNP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbQLYCNP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/contract.png"))); // NOI18N
        lbQLYCNP.setText("Quản lý YCNP");
        lbQLYCNP.setIconTextGap(12);
        lbQLYCNP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLYCNPMouseClicked(evt);
            }
        });

        lbQLYCTL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbQLYCTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/contract.png"))); // NOI18N
        lbQLYCTL.setText("Quản lý YCUL");
        lbQLYCTL.setIconTextGap(12);
        lbQLYCTL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLYCTLMouseClicked(evt);
            }
        });

        lbTinhLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTinhLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/salary.png"))); // NOI18N
        lbTinhLuong.setText("Tính lương");
        lbTinhLuong.setIconTextGap(12);
        lbTinhLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTinhLuongMouseClicked(evt);
            }
        });

        lbGDChung.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGDChung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png"))); // NOI18N
        lbGDChung.setText("Màn hình chung");
        lbGDChung.setIconTextGap(12);
        lbGDChung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGDChungMouseClicked(evt);
            }
        });

        lbCurrentUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCurrentUser.setText("User");
        lbCurrentUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/account.png"))); // NOI18N
        lbDangXuat.setText("Đăng xuất");
        lbDangXuat.setIconTextGap(12);
        lbDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDangXuatMouseClicked(evt);
            }
        });

        lbADMIN.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbADMIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbADMIN.setText("ADMIN");
        lbADMIN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/admin_avatar2.png"))); // NOI18N

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addComponent(lbADMIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuBarLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuBarLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbGDChung, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQLYCTL, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQLYCNP, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuanLyCC, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuanLyPB, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCurrentUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbADMIN)
                .addGap(39, 39, 39)
                .addComponent(lbGDChung, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbQuanLyPB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbQuanLyCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbQLYCNP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbQLYCTL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        getContentPane().add(menuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabController.setBackground(new java.awt.Color(204, 204, 255));
        tabController.setPreferredSize(new java.awt.Dimension(1030, 768));

        panelDashboard.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );

        tabController.addTab("tab8", panelDashboard);

        panelQLNV.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("Form 1");

        javax.swing.GroupLayout panelQLNVLayout = new javax.swing.GroupLayout(panelQLNV);
        panelQLNV.setLayout(panelQLNVLayout);
        panelQLNVLayout.setHorizontalGroup(
            panelQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQLNVLayout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(762, Short.MAX_VALUE))
        );
        panelQLNVLayout.setVerticalGroup(
            panelQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQLNVLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(511, Short.MAX_VALUE))
        );

        tabController.addTab("tab1", panelQLNV);

        panelQLPB.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout panelQLPBLayout = new javax.swing.GroupLayout(panelQLPB);
        panelQLPB.setLayout(panelQLPBLayout);
        panelQLPBLayout.setHorizontalGroup(
            panelQLPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        panelQLPBLayout.setVerticalGroup(
            panelQLPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );

        tabController.addTab("tab2", panelQLPB);

        panelQLCC.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout panelQLCCLayout = new javax.swing.GroupLayout(panelQLCC);
        panelQLCC.setLayout(panelQLCCLayout);
        panelQLCCLayout.setHorizontalGroup(
            panelQLCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        panelQLCCLayout.setVerticalGroup(
            panelQLCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );

        tabController.addTab("tab3", panelQLCC);

        panelQLYCNP.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout panelQLYCNPLayout = new javax.swing.GroupLayout(panelQLYCNP);
        panelQLYCNP.setLayout(panelQLYCNPLayout);
        panelQLYCNPLayout.setHorizontalGroup(
            panelQLYCNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        panelQLYCNPLayout.setVerticalGroup(
            panelQLYCNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );

        tabController.addTab("tab4", panelQLYCNP);

        panelQLYCUL.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout panelQLYCULLayout = new javax.swing.GroupLayout(panelQLYCUL);
        panelQLYCUL.setLayout(panelQLYCULLayout);
        panelQLYCULLayout.setHorizontalGroup(
            panelQLYCULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        panelQLYCULLayout.setVerticalGroup(
            panelQLYCULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );

        tabController.addTab("tab5", panelQLYCUL);

        panelQLTC.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout panelQLTCLayout = new javax.swing.GroupLayout(panelQLTC);
        panelQLTC.setLayout(panelQLTCLayout);
        panelQLTCLayout.setHorizontalGroup(
            panelQLTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        panelQLTCLayout.setVerticalGroup(
            panelQLTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );

        tabController.addTab("tab6", panelQLTC);

        panelTinhLuong.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout panelTinhLuongLayout = new javax.swing.GroupLayout(panelTinhLuong);
        panelTinhLuong.setLayout(panelTinhLuongLayout);
        panelTinhLuongLayout.setHorizontalGroup(
            panelTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        panelTinhLuongLayout.setVerticalGroup(
            panelTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );

        tabController.addTab("tab7", panelTinhLuong);

        getContentPane().add(tabController, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, -42, 1060, 810));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLNVMouseClicked
        tabController.setSelectedIndex(1);
        changeLabelColor(menuBar);
        JLabel currentLabel = (JLabel)evt.getSource();
        currentLabel.setForeground(new Color(34,103,255));
        
        Component tab = tabController.getComponentAt(1);
        if(tab instanceof JPanel) 
         {
               JPanel panel = (JPanel)tab;
               QLNVForm newForm = new QLNVForm();
               Component oldPanel = tabController.getSelectedComponent();
                tabController.setComponentAt(tabController.indexOfComponent(oldPanel), newForm);
                tabController.validate();
                tabController.repaint();
         }
    }//GEN-LAST:event_lbQLNVMouseClicked

    private void lbQuanLyPBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuanLyPBMouseClicked
        tabController.setSelectedIndex(2);
        changeLabelColor(menuBar);
        JLabel currentLabel = (JLabel)evt.getSource();
        currentLabel.setForeground(new Color(34,103,255));
        
        Component tab = tabController.getComponentAt(2);
        if(tab instanceof JPanel) 
         {
               JPanel panel = (JPanel)tab;
               QLPBForm newForm = new QLPBForm();
               Component oldPanel = tabController.getSelectedComponent();
                tabController.setComponentAt(tabController.indexOfComponent(oldPanel), newForm);
                tabController.validate();
                tabController.repaint();
         }
    }//GEN-LAST:event_lbQuanLyPBMouseClicked

    private void lbQuanLyCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuanLyCCMouseClicked
        tabController.setSelectedIndex(3);
        changeLabelColor(menuBar);
        JLabel currentLabel = (JLabel)evt.getSource();
        currentLabel.setForeground(new Color(34,103,255));
        
        Component tab = tabController.getComponentAt(3);
        if(tab instanceof JPanel) 
         {
               JPanel panel = (JPanel)tab;
               ChamCong newForm = new ChamCong();
               Component oldPanel = tabController.getSelectedComponent();
                tabController.setComponentAt(tabController.indexOfComponent(oldPanel), newForm);
                tabController.validate();
                tabController.repaint();
         }
    }//GEN-LAST:event_lbQuanLyCCMouseClicked

    private void lbQLYCNPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLYCNPMouseClicked
        tabController.setSelectedIndex(4);
        changeLabelColor(menuBar);
        JLabel currentLabel = (JLabel)evt.getSource();
        currentLabel.setForeground(new Color(34,103,255));
        
        Component tab = tabController.getComponentAt(4);
        if(tab instanceof JPanel) 
         {
               JPanel panel = (JPanel)tab;
               QLYCNPForm newForm = new QLYCNPForm();
               Component oldPanel = tabController.getSelectedComponent();
                tabController.setComponentAt(tabController.indexOfComponent(oldPanel), newForm);
                tabController.validate();
                tabController.repaint();
         }
    }//GEN-LAST:event_lbQLYCNPMouseClicked

    private void lbQLYCTLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLYCTLMouseClicked
        tabController.setSelectedIndex(5);
        changeLabelColor(menuBar);
        JLabel currentLabel = (JLabel)evt.getSource();
        currentLabel.setForeground(new Color(34,103,255));
        
        Component tab = tabController.getComponentAt(5);
        if(tab instanceof JPanel) 
         {
               JPanel panel = (JPanel)tab;
               QLYCULForm newForm = new QLYCULForm();
               Component oldPanel = tabController.getSelectedComponent();
                tabController.setComponentAt(tabController.indexOfComponent(oldPanel), newForm);
                tabController.validate();
                tabController.repaint();
         }
    }//GEN-LAST:event_lbQLYCTLMouseClicked

    private void lbTinhLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTinhLuongMouseClicked
        tabController.setSelectedIndex(7);
        changeLabelColor(menuBar);
        JLabel currentLabel = (JLabel)evt.getSource();
        currentLabel.setForeground(new Color(34,103,255));
        
        Component tab = tabController.getComponentAt(7);
        if(tab instanceof JPanel) 
         {
               JPanel panel = (JPanel)tab;
               TinhLuongForm newForm = new TinhLuongForm();
               Component oldPanel = tabController.getSelectedComponent();
                tabController.setComponentAt(tabController.indexOfComponent(oldPanel), newForm);
                tabController.validate();
                tabController.repaint();
         }
    }//GEN-LAST:event_lbTinhLuongMouseClicked

    private void lbGDChungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGDChungMouseClicked
        tabController.setSelectedIndex(0);
        changeLabelColor(menuBar);
        JLabel currentLabel = (JLabel)evt.getSource();
        currentLabel.setForeground(new Color(34,103,255));
        
        Component tab = tabController.getComponentAt(0);
        if(tab instanceof JPanel) 
         {
               JPanel panel = (JPanel)tab;
               Dashboard ds = new Dashboard();
               Component oldPanel = tabController.getSelectedComponent();
                tabController.setComponentAt(tabController.indexOfComponent(oldPanel), ds);
                tabController.validate();
                tabController.repaint();
         }
    }//GEN-LAST:event_lbGDChungMouseClicked

    private void lbDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangXuatMouseClicked
        changeLabelColor(menuBar);
        JLabel currentLabel = (JLabel)evt.getSource();
        currentLabel.setForeground(new Color(34,103,255)); 
        
        int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất khỏi hệ thống ?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
        if( choice == JOptionPane.YES_OPTION)
        {
            DangNhapForm loginForm = new DangNhapForm();
            this.dispose();
            loginForm.setVisible(true);
        }
    }//GEN-LAST:event_lbDangXuatMouseClicked

    public void changeLabelColor( JPanel panel){
        for(Component c : panel.getComponents())
        {
            if( c  instanceof JLabel)
            {
                JLabel label = (JLabel)c;
                label.setForeground(new Color(0, 0, 0));
            }
        }
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienAdmin("ADMIN").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbADMIN;
    private javax.swing.JLabel lbCurrentUser;
    private javax.swing.JLabel lbDangXuat;
    private javax.swing.JLabel lbGDChung;
    private javax.swing.JLabel lbQLNV;
    private javax.swing.JLabel lbQLYCNP;
    private javax.swing.JLabel lbQLYCTL;
    private javax.swing.JLabel lbQuanLyCC;
    private javax.swing.JLabel lbQuanLyPB;
    private javax.swing.JLabel lbTinhLuong;
    private javax.swing.JPanel menuBar;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelQLCC;
    private javax.swing.JPanel panelQLNV;
    private javax.swing.JPanel panelQLPB;
    private javax.swing.JPanel panelQLTC;
    private javax.swing.JPanel panelQLYCNP;
    private javax.swing.JPanel panelQLYCUL;
    private javax.swing.JPanel panelTinhLuong;
    private javax.swing.JTabbedPane tabController;
    // End of variables declaration//GEN-END:variables
}
