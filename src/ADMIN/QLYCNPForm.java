package ADMIN;

import static DAO.access_NHANVIEN.getMaFromTen;
import static DAO.access_NHANVIEN.getTenFromMa;
import static DAO.access_YEUCAUNGHIPHEP.XuLyYeuCauNP;
import static DAO.access_YEUCAUNGHIPHEP.getGHICHUNP;
import static DAO.access_YEUCAUNGHIPHEP.getNewYEUCAUNGHIPHEP;
import static DAO.access_YEUCAUNGHIPHEP.getNgayBD;
import static DAO.access_YEUCAUNGHIPHEP.getNgayKT;
import static DAO.access_YEUCAUNGHIPHEP.getYEUCAUNGHIPHEP;

import Component.ScrollPaneWin11;
import Component.myButton;
import Component.myTable;
import DTO.YEUCAUNGHIPHEP;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLYCNPForm extends javax.swing.JPanel {
    private DefaultTableModel defaultTable;
    /**
     * Creates new form QLYCNPForm
     */
    public QLYCNPForm() {
        initComponents();
        initDSYCNP();
    }
    
    public void initDSYCNP()
    {
        ArrayList<YEUCAUNGHIPHEP> dsYEUCAUNGHIPHEP = getYEUCAUNGHIPHEP();
        defaultTable = new DefaultTableModel();

        String[] columnNames  = {"Mã yêu cầu", "Tên nhân viên", "Ngày gửi", "Trạng thái"};
        defaultTable.setColumnIdentifiers(columnNames);
        for(YEUCAUNGHIPHEP tmp : dsYEUCAUNGHIPHEP)
        {
            defaultTable.addRow(new Object[]{
                tmp.getMaYC(),
                getTenFromMa(Integer.toString(tmp.getMaNV())),
                tmp.getNgayGui(),
                tmp.getTrangThai()
            });
        }
        tbDSYCNP.setModel(defaultTable);
    }
    
    // Lay thong tin yeu cau duoc click
    public void getChiTietYeuCauUL( DefaultTableModel defaultTable ,int rowIndex )
    {
        String currentStatus = defaultTable.getValueAt(rowIndex, 3).toString();
        String maYCNP = defaultTable.getValueAt(rowIndex, 0).toString();
        String ngBD = getNgayBD(maYCNP);
        String ngKT = getNgayKT(maYCNP);
        
        lbTenNV.setText(defaultTable.getValueAt(rowIndex, 1).toString());
        lbNgayGui.setText(defaultTable.getValueAt(rowIndex, 2).toString());
        lbNgayBD.setText(ngBD);
        lbNgayKT.setText(ngKT);
        lbTrangThai.setText(defaultTable.getValueAt(rowIndex, 3).toString());
        
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        lbTrangThai.setFont(font);
        if(currentStatus.equals("Từ chối"))
            lbTrangThai.setForeground(Color.RED);
        else if( currentStatus.equals("Đã phê duyệt"))
            lbTrangThai.setForeground(Color.GREEN);
        else if(currentStatus.equals("Đã hủy"))
            lbTrangThai.setForeground(Color.GRAY);
        else
            lbTrangThai.setForeground(Color.BLACK);
            
        txtGhiChu.setText(getGHICHUNP(defaultTable.getValueAt(rowIndex, 0).toString()));
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
        panelThongTinYC = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextPane();
        lbTenNV = new javax.swing.JLabel();
        lbNgayGui = new javax.swing.JLabel();
        lbNgayBD = new javax.swing.JLabel();
        lbNgayKT = new javax.swing.JLabel();
        lbTrangThai = new javax.swing.JLabel();
        btnPheDuyet = new myButton();
        btnTuChoi = new myButton();
        pnTraCuuYCNP = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtSearchTenNV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        btnSearch = new myButton();
        scrollPaneWin111 = new ScrollPaneWin11();
        tbDSYCNP = new myTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1055, 768));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 100));
        jLabel1.setText("Danh sách yêu cầu nghỉ phép");

        panelThongTinYC.setBackground(new java.awt.Color(255, 255, 255));
        panelThongTinYC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 100), 3), "Thông tin yêu cầu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N
        panelThongTinYC.setForeground(new java.awt.Color(255, 255, 255));
        panelThongTinYC.setPreferredSize(new java.awt.Dimension(260, 350));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Tên nhân viên");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Ngày gửi");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Ngày bắt đầu nghỉ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Ngày kết thúc nghỉ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Ghi chú");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Trạng thái");

        txtGhiChu.setEditable(false);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGhiChu.setPreferredSize(new java.awt.Dimension(60, 24));
        jScrollPane2.setViewportView(txtGhiChu);

        lbTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTenNV.setText(" ");

        lbNgayGui.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNgayGui.setText(" ");

        lbNgayBD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNgayBD.setText(" ");

        lbNgayKT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNgayKT.setText(" ");

        lbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTrangThai.setText(" ");

        javax.swing.GroupLayout panelThongTinYCLayout = new javax.swing.GroupLayout(panelThongTinYC);
        panelThongTinYC.setLayout(panelThongTinYCLayout);
        panelThongTinYCLayout.setHorizontalGroup(
            panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongTinYCLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThongTinYCLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(panelThongTinYCLayout.createSequentialGroup()
                        .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17))
                        .addGap(51, 51, 51)
                        .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgayGui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelThongTinYCLayout.createSequentialGroup()
                        .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelThongTinYCLayout.setVerticalGroup(
            panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongTinYCLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbTenNV))
                .addGap(18, 18, 18)
                .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbNgayGui))
                .addGap(18, 18, 18)
                .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbNgayBD))
                .addGap(18, 18, 18)
                .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbNgayKT))
                .addGap(18, 18, 18)
                .addGroup(panelThongTinYCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbTrangThai))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnPheDuyet.setBorder(null);
        btnPheDuyet.setForeground(new java.awt.Color(255, 255, 255));
        btnPheDuyet.setText("Phê duyệt");
        btnPheDuyet.setColor(new java.awt.Color(0, 175, 121));
        btnPheDuyet.setColorClick(new java.awt.Color(51, 102, 0));
        btnPheDuyet.setColorOver(new java.awt.Color(100, 210, 147));
        btnPheDuyet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPheDuyet.setRadius(15);
        btnPheDuyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPheDuyetActionPerformed(evt);
            }
        });

        btnTuChoi.setBorder(null);
        btnTuChoi.setForeground(new java.awt.Color(255, 255, 255));
        btnTuChoi.setText("Từ chối");
        btnTuChoi.setColor(new java.awt.Color(204, 0, 51));
        btnTuChoi.setColorClick(new java.awt.Color(153, 0, 51));
        btnTuChoi.setColorOver(new java.awt.Color(255, 85, 105));
        btnTuChoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTuChoi.setRadius(15);
        btnTuChoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTuChoiActionPerformed(evt);
            }
        });

        pnTraCuuYCNP.setBackground(new java.awt.Color(255, 255, 255));
        pnTraCuuYCNP.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 100), 3, true), "Tra cứu yêu cầu nghỉ phép", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Tên nhân viên");

        txtSearchTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchTenNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Trạng thái");

        cbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã phê duyệt", "Từ chối", "Chờ phê duyệt", "Đã hủy" }));
        cbTrangThai.setBorder(null);

        btnSearch.setBorder(null);
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/recruitment2.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setColor(new java.awt.Color(102, 153, 255));
        btnSearch.setColorClick(new java.awt.Color(153, 255, 255));
        btnSearch.setColorOver(new java.awt.Color(51, 51, 255));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setRadius(15);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTraCuuYCNPLayout = new javax.swing.GroupLayout(pnTraCuuYCNP);
        pnTraCuuYCNP.setLayout(pnTraCuuYCNPLayout);
        pnTraCuuYCNPLayout.setHorizontalGroup(
            pnTraCuuYCNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTraCuuYCNPLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtSearchTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        pnTraCuuYCNPLayout.setVerticalGroup(
            pnTraCuuYCNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTraCuuYCNPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnTraCuuYCNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSearchTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        scrollPaneWin111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 100), 3));

        tbDSYCNP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDSYCNP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDSYCNPMouseClicked(evt);
            }
        });
        scrollPaneWin111.setViewportView(tbDSYCNP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(pnTraCuuYCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnPheDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnTuChoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelThongTinYC, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(pnTraCuuYCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(panelThongTinYC, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPheDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTuChoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        DefaultTableModel defaultTable = new DefaultTableModel();
        String[] columnNames = {"Mã yêu cầu ", "Nhân viên", "Ngày gửi yêu cầu", "Trạng thái"};
        defaultTable.setColumnIdentifiers(columnNames);
   
        String tenNV = txtSearchTenNV.getText();
        int maNV = getMaFromTen(tenNV);
        String trangThai = cbTrangThai.getSelectedItem().toString();
        if(trangThai.equals("Tất cả"))
        {
            trangThai = "";
        }  
        ArrayList<YEUCAUNGHIPHEP> newList = getNewYEUCAUNGHIPHEP(maNV, trangThai);
        for(YEUCAUNGHIPHEP tmp : newList)
        {
            defaultTable.addRow( new Object[]{
               // tmp.getMaYCUL() + " - " + tmp.getMaNV(),
                tmp.getMaYC(),
                getTenFromMa(Integer.toString(tmp.getMaNV())),
                tmp.getNgayGui(),
                tmp.getTrangThai()
            });
        }
        tbDSYCNP.setModel(defaultTable);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPheDuyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPheDuyetActionPerformed
        int rowIndex = tbDSYCNP.getSelectedRow();
        if(rowIndex == -1)
            return;
        
        DefaultTableModel defaultTable = (DefaultTableModel)tbDSYCNP.getModel();
        String currentStatus = defaultTable.getValueAt(rowIndex, 3).toString();
        if(!currentStatus.equals("Chờ phê duyệt"))
        {
            JOptionPane.showMessageDialog(null, "Yêu cầu đã khóa xử lý!", "Khổng thể xử lý yêu cầu", JOptionPane.ERROR_MESSAGE);
        }
         else
        {
             int choice = JOptionPane.showConfirmDialog(null, "Bạn hoàn toàn chắc với quyết định xử lý ?", "Xác nhận xử lý", JOptionPane.YES_NO_OPTION);
             if( choice == JOptionPane.YES_OPTION)
             {
                 String strMaYCNP = defaultTable.getValueAt(rowIndex, 0).toString();
                 int mayc = Integer.valueOf(strMaYCNP);
                 XuLyYeuCauNP(mayc, 1);
                 
                 defaultTable = (DefaultTableModel)tbDSYCNP.getModel();
                 defaultTable.setRowCount(0);
                 initDSYCNP();
             }
             else
                 return;
        }
    }//GEN-LAST:event_btnPheDuyetActionPerformed

    private void btnTuChoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTuChoiActionPerformed
        int rowIndex = tbDSYCNP.getSelectedRow();
        if(rowIndex == -1)
            return;
        
        DefaultTableModel defaultTable = (DefaultTableModel)tbDSYCNP.getModel();
        String currentStatus = defaultTable.getValueAt(rowIndex, 3).toString();
        if(!currentStatus.equals("Chờ phê duyệt"))
        {
            JOptionPane.showMessageDialog(null, "Yêu cầu đã khóa xử lý!", "Khổng thể xử lý yêu cầu", JOptionPane.ERROR_MESSAGE);
        }
         else
        {
             int choice = JOptionPane.showConfirmDialog(null, "Bạn hoàn toàn chắc với quyết định xử lý ?", "Xác nhận xử lý", JOptionPane.YES_NO_OPTION);
             if( choice == JOptionPane.YES_OPTION)
             {
                 String strMaYCNP = defaultTable.getValueAt(rowIndex, 0).toString();
                 int mayc = Integer.valueOf(strMaYCNP);
                 XuLyYeuCauNP(mayc, 0);
                 
                 defaultTable = (DefaultTableModel)tbDSYCNP.getModel();
                 defaultTable.setRowCount(0);
                 initDSYCNP();
             }
             else
                 return;
        }
    }//GEN-LAST:event_btnTuChoiActionPerformed

    private void tbDSYCNPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDSYCNPMouseClicked
        int rowIndex = tbDSYCNP.getSelectedRow();
        DefaultTableModel defaultTable = (DefaultTableModel)tbDSYCNP.getModel();
        getChiTietYeuCauUL(defaultTable, rowIndex);
    }//GEN-LAST:event_tbDSYCNPMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private myButton btnPheDuyet;
    private myButton btnSearch;
    private myButton btnTuChoi;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbNgayBD;
    private javax.swing.JLabel lbNgayGui;
    private javax.swing.JLabel lbNgayKT;
    private javax.swing.JLabel lbTenNV;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JPanel panelThongTinYC;
    private javax.swing.JPanel pnTraCuuYCNP;
    private ScrollPaneWin11 scrollPaneWin111;
    private myTable tbDSYCNP;
    private javax.swing.JTextPane txtGhiChu;
    private javax.swing.JTextField txtSearchTenNV;
    // End of variables declaration//GEN-END:variables
}
