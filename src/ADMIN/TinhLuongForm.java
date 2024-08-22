/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN;
import Component.ScrollPaneWin11;
import Component.myButton;
import Component.myTable;
import DAO.access_BANGLUONG;
import DAO.access_NHANVIEN;
import java.io.*;
import DTO.BANGLUONG;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ADMIN
 */
public class TinhLuongForm extends javax.swing.JPanel {
    private access_BANGLUONG bangLuongDAO;
    /**
     * Creates new form TinhLuongForm
     */
    public TinhLuongForm() {
        initComponents();
        bangLuongDAO  = new access_BANGLUONG();
        loadBangLuongTable();
    }
    private void loadBangLuongTable(){
        try {
            ArrayList<BANGLUONG> bangLuongList = bangLuongDAO.getAllBangLuong();
            DefaultTableModel model = (DefaultTableModel) DsLuong.getModel();
            model.setRowCount(0); // Xóa các dòng hiện tại

            for (BANGLUONG bangLuong : bangLuongList) {
                Object[] row = new Object[]{
                    bangLuong.getMaBL(),
                    bangLuong.getMaNV(),
                    bangLuong.getTenNV(),
                    bangLuong.getNam(),
                    bangLuong.getThang(),
                    bangLuong.getTongTienUL(),
                 
                    bangLuong.getFormattedLuongTL()
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollPaneWin111 = new Component.ScrollPaneWin11();
        DsLuong = new Component.myTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        MaNVtxtField = new javax.swing.JTextField();
        add = new Component.myButton();
        addALLbtn = new Component.myButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ThangtxtField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        MaNVtxtField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NamtxtField3 = new javax.swing.JTextField();
        find = new Component.myButton();
        exportbtn = new Component.myButton();
        ThangExport = new javax.swing.JTextField();
        NamExport = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1055, 768));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 100));
        jLabel1.setText("Bảng lương nhân viên");

        scrollPaneWin111.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        DsLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã bảng lương", "Mã nhân viên", "Tên Nhân viên", "Năm", "Tháng", "Tổng Tiền UL", "Lương thực lãnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneWin111.setViewportView(DsLuong);
        if (DsLuong.getColumnModel().getColumnCount() > 0) {
            DsLuong.getColumnModel().getColumn(0).setResizable(false);
            DsLuong.getColumnModel().getColumn(1).setResizable(false);
            DsLuong.getColumnModel().getColumn(2).setResizable(false);
            DsLuong.getColumnModel().getColumn(3).setResizable(false);
            DsLuong.getColumnModel().getColumn(4).setResizable(false);
            DsLuong.getColumnModel().getColumn(5).setResizable(false);
            DsLuong.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Thêm bảng lương", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        MaNVtxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaNVtxtFieldActionPerformed(evt);
            }
        });

        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Thêm bảng lương cho nhân viên này");
        add.setColor(new java.awt.Color(0, 102, 0));
        add.setColorClick(new java.awt.Color(0, 153, 102));
        add.setColorOver(new java.awt.Color(0, 153, 51));
        add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        addALLbtn.setForeground(new java.awt.Color(255, 255, 255));
        addALLbtn.setText("Thêm bảng lương cho tất cả nhân viên");
        addALLbtn.setColor(new java.awt.Color(0, 102, 0));
        addALLbtn.setColorClick(new java.awt.Color(0, 153, 102));
        addALLbtn.setColorOver(new java.awt.Color(0, 153, 51));
        addALLbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addALLbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addALLbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(MaNVtxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addALLbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(MaNVtxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addALLbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Tra cứu bảng lương", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        ThangtxtField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThangtxtField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tháng");

        MaNVtxtField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaNVtxtField2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Năm");

        NamtxtField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamtxtField3ActionPerformed(evt);
            }
        });

        find.setForeground(new java.awt.Color(255, 255, 255));
        find.setText("Tìm kiếm");
        find.setColor(new java.awt.Color(0, 102, 0));
        find.setColorClick(new java.awt.Color(0, 153, 102));
        find.setColorOver(new java.awt.Color(0, 153, 51));
        find.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(MaNVtxtField2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NamtxtField3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ThangtxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(MaNVtxtField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ThangtxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NamtxtField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        exportbtn.setForeground(new java.awt.Color(255, 255, 255));
        exportbtn.setText("Xuất bảng lương");
        exportbtn.setColor(new java.awt.Color(0, 102, 0));
        exportbtn.setColorClick(new java.awt.Color(0, 153, 102));
        exportbtn.setColorOver(new java.awt.Color(0, 153, 51));
        exportbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportbtnActionPerformed(evt);
            }
        });

        ThangExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThangExportActionPerformed(evt);
            }
        });
        ThangExport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ThangExportKeyTyped(evt);
            }
        });

        NamExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamExportActionPerformed(evt);
            }
        });
        NamExport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NamExportKeyTyped(evt);
            }
        });

        jLabel6.setText("Tháng");

        jLabel7.setText("Năm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(19, 19, 19)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(NamExport, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(ThangExport))
                                .addGap(27, 27, 27)
                                .addComponent(exportbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exportbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ThangExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NamExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))))
                .addGap(35, 35, 35)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MaNVtxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaNVtxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaNVtxtFieldActionPerformed

    private void ThangtxtField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThangtxtField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThangtxtField1ActionPerformed

    private void MaNVtxtField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaNVtxtField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaNVtxtField2ActionPerformed

    private void NamtxtField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamtxtField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamtxtField3ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            int maNV = Integer.parseInt(MaNVtxtField.getText());

            // Lấy thời gian hiện tại
            LocalDate currentDate = LocalDate.now();
            int nam = currentDate.getYear();
            int thang = currentDate.getMonthValue();

            double[] luongCoBanVaHeSo = bangLuongDAO.getLuongCoBanVaHeSo(maNV);
            double luongCB = luongCoBanVaHeSo[0];
            double heSo = luongCoBanVaHeSo[1];

            // Tính lương ngày
            double luongNgay = (luongCB * heSo) / 25;

            // Lấy tổng tiền ứng lương đã duyệt của nhân viên trong tháng
            long tongTienUL = bangLuongDAO.getTongTienUL(maNV, nam, thang);

            // Lấy số ngày công của nhân viên trong tháng
            int soNgayCong = bangLuongDAO.getSoNgayCong(maNV, nam, thang);

            // Tính lương thực lãnh
            double luongTL = (luongNgay * soNgayCong) - tongTienUL;

            BANGLUONG bangLuong = new BANGLUONG();
            bangLuong.setMaNV(maNV);
            bangLuong.setNam(nam);
            bangLuong.setThang(thang);
            bangLuong.setTongTienUL(tongTienUL);
            bangLuong.setLuongTL(luongTL);

            bangLuongDAO.addBangLuong(bangLuong);

            JOptionPane.showMessageDialog(this, "Thêm bảng lương thành công!");
            loadBangLuongTable(); // Load lại bảng lương sau khi thêm
                } catch (SQLException e) {
               if (e.getErrorCode() == 20001) { // Mã lỗi từ trigger
                   JOptionPane.showMessageDialog(this, "Nhân viên này đã có bảng lương trong tháng và năm này.", "Lỗi", JOptionPane.ERROR_MESSAGE);
               } else {
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Lỗi khi thêm bảng lương: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
           }
    }//GEN-LAST:event_addActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        try {
            Integer maNV = null;
            Integer thang = null;
            Integer nam = null;

            if (!MaNVtxtField2.getText().isEmpty()) {
                maNV = Integer.parseInt(MaNVtxtField2.getText());
            }
            if (!ThangtxtField1.getText().isEmpty()) {
                thang = Integer.parseInt(ThangtxtField1.getText());
            }
            if (!NamtxtField3.getText().isEmpty()) {
                nam = Integer.parseInt(NamtxtField3.getText());
            }

            ArrayList<BANGLUONG> bangLuongList = bangLuongDAO.findBangLuong(maNV, thang, nam);
            DefaultTableModel model = (DefaultTableModel) DsLuong.getModel();
            model.setRowCount(0); // Xóa các dòng hiện tại

            for (BANGLUONG bangLuong : bangLuongList) {
                Object[] row = new Object[]{
                    bangLuong.getMaBL(),
                    bangLuong.getMaNV(),
                    bangLuong.getTenNV(),
                    bangLuong.getNam(),
                    bangLuong.getThang(),
                    bangLuong.getTongTienUL(),
                    bangLuong.getLuongTL(),
                    bangLuong.getFormattedLuongTL()
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm bảng lương: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_findActionPerformed

    private void addALLbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addALLbtnActionPerformed
        ArrayList<Integer> al = access_NHANVIEN.getALLMaNV();
        
        for(int i =0;i<al.size();i++){
        try {
            int maNV = al.get(i);

            // Lấy thời gian hiện tại
            LocalDate currentDate = LocalDate.now();
            int nam = currentDate.getYear();
            int thang = currentDate.getMonthValue();

            double[] luongCoBanVaHeSo = bangLuongDAO.getLuongCoBanVaHeSo(maNV);
            double luongCB = luongCoBanVaHeSo[0];
            double heSo = luongCoBanVaHeSo[1];

            // Tính lương ngày
            double luongNgay = (luongCB * heSo) / 25;

            // Lấy tổng tiền ứng lương đã duyệt của nhân viên trong tháng
            long tongTienUL = bangLuongDAO.getTongTienUL(maNV, nam, thang);

            // Lấy số ngày công của nhân viên trong tháng
            int soNgayCong = bangLuongDAO.getSoNgayCong(maNV, nam, thang);

            // Tính lương thực lãnh
            double luongTL = (luongNgay * soNgayCong) - tongTienUL;

            BANGLUONG bangLuong = new BANGLUONG();
            bangLuong.setMaNV(maNV);
            bangLuong.setNam(nam);
            bangLuong.setThang(thang);
            bangLuong.setTongTienUL(tongTienUL);
            bangLuong.setLuongTL(luongTL);

            bangLuongDAO.addBangLuong(bangLuong);

            loadBangLuongTable(); // Load lại bảng lương sau khi thêm
                } catch (SQLException e) {
               if (e.getErrorCode() == 20001) { // Mã lỗi từ trigger
                   JOptionPane.showMessageDialog(this, "Nhân viên này đã có bảng lương trong tháng và năm này.", "Lỗi", JOptionPane.ERROR_MESSAGE);
               } else {
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Lỗi khi thêm bảng lương: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
           }
        }
       JOptionPane.showMessageDialog(this, "Thêm bảng lương thành công!");

    }//GEN-LAST:event_addALLbtnActionPerformed

    private void exportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportbtnActionPerformed
        int Thang=Integer.parseInt(ThangExport.getText());
        int Nam=Integer.parseInt(NamExport.getText());
        if(Thang<0||Thang>12){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tháng phù hợp", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            ArrayList<BANGLUONG> al = access_BANGLUONG.getBANGLUONG(Thang,Nam);
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Bảng lương");
            Row headerRow = sheet.createRow(0);
            
            Cell cell = headerRow.createCell(0);
            cell.setCellValue("Mã bảng lương");
            cell = headerRow.createCell(1);
            cell.setCellValue("Mã nhân viên");
            cell = headerRow.createCell(2);
            cell.setCellValue("Tên nhân viên");      
            cell = headerRow.createCell(3);
            cell.setCellValue("Tháng");      
            cell = headerRow.createCell(4);
            cell.setCellValue("Lương ứng trước");      
            cell = headerRow.createCell(5);
            cell.setCellValue("Lương thực lãnh");
            for(int i =0;i<al.size();i++){
                   Row row = sheet.createRow(i+1);
                   row.createCell(0).setCellValue(al.get(i).getMaBL());
                   row.createCell(1).setCellValue(al.get(i).getMaNV());
                   row.createCell(2).setCellValue(al.get(i).getTenNV());
                   row.createCell(3).setCellValue(al.get(i).getFormattedDate());
                   row.createCell(4).setCellValue(al.get(i).getTongTienUL());
                   row.createCell(5).setCellValue(al.get(i).getLuongTL());
            }
            try (FileOutputStream outputStream = new FileOutputStream("D:/bangluong.xlsx")) {
                workbook.write(outputStream);           
                JOptionPane.showMessageDialog(this, "Xuất bảng lương thành công tại"+" D:/bangluong.xlsx", "Thành công", JOptionPane.INFORMATION_MESSAGE);

            }
            catch(Exception e){
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_exportbtnActionPerformed

    private void ThangExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThangExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThangExportActionPerformed

    private void NamExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamExportActionPerformed

    private void ThangExportKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ThangExportKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ThangExportKeyTyped

    private void NamExportKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NamExportKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
                }    }//GEN-LAST:event_NamExportKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.myTable DsLuong;
    private javax.swing.JTextField MaNVtxtField;
    private javax.swing.JTextField MaNVtxtField2;
    private javax.swing.JTextField NamExport;
    private javax.swing.JTextField NamtxtField3;
    private javax.swing.JTextField ThangExport;
    private javax.swing.JTextField ThangtxtField1;
    private Component.myButton add;
    private Component.myButton addALLbtn;
    private Component.myButton exportbtn;
    private Component.myButton find;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Component.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
