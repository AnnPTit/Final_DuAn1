package view;

import customModel.HoaDonThanhToan;
import customModel.ThongKeThang;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.ModelCard;
import service.IHDCTService;
import service.impl.HDCTImpl;
import utilities.ExportSoHDTT;
import utilities.ExportThongKeThang;

/**
 *
 * @author fallinluv2003
 */
public class ThongKeDoanhThu extends javax.swing.JPanel {
    
    private IHDCTService hdctSer = new HDCTImpl();
    
    public ThongKeDoanhThu() {
        initComponents();
        initCardData();
        List<HoaDonThanhToan> hoaDon = hdctSer.getHoaDonThanhToan();
        List<ThongKeThang> thongKe = hdctSer.getThongKeThang();
        loadTableThongKeThang(thongKe);
        loadTableDoanhSo(hoaDon);
    }
    
    private void initCardData() {
        if (hdctSer.doanhThuHomNay() == null) {
            BigDecimal doanhThu = new BigDecimal(0);
            card1.setData(new ModelCard("Doanh thu/Ngày", doanhThu, 60, null));
        } else {
            card1.setData(new ModelCard("Doanh thu/Ngày", hdctSer.doanhThuHomNay(), 60, null));
        }
        
        if (hdctSer.doanhThuTheoThang() == null) {
            BigDecimal doanhThu = new BigDecimal(0);
            card2.setData(new ModelCard("Doanh thu tháng này", doanhThu, 0, null));
        } else {
            card2.setData(new ModelCard("Doanh thu tháng này", hdctSer.doanhThuTheoThang(), 0, null));
        }
        card3.setData(new ModelCard("Doanh thu cả năm", hdctSer.doanhThuTheoNam(), 95, null));
    }
    
    void loadTableDoanhSo(List<HoaDonThanhToan> list) {
        DefaultTableModel model = (DefaultTableModel) tbHoaDonThanhToan.getModel();
        model.setRowCount(0);
        for (HoaDonThanhToan x : list) {
            model.addRow(new Object[]{
                x.getNgayThanhToan(), x.getDoanhThu(), x.getHoaDonThanhToan()
            });
        }
    }
    
    void loadTableThongKeThang(List<ThongKeThang> list) {
        DefaultTableModel model = (DefaultTableModel) tbThongKeThang.getModel();
        model.setRowCount(0);
        for (ThongKeThang x : list) {
            model.addRow(new Object[]{
                x.getThang(), x.getSoLuongBanRa(), x.getDoanhThu()
            });
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

        jPanel1 = new javax.swing.JPanel();
        card1 = new component.Card();
        card2 = new component.Card();
        card3 = new component.Card();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDonThanhToan = new swing.table.Table();
        txtDateStart = new com.toedter.calendar.JDateChooser();
        txtDateEnd = new com.toedter.calendar.JDateChooser();
        btnLoc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExportExcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThongKeThang = new swing.table.Table();
        btnExportDoanhThu = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        card1.setBackground(new java.awt.Color(0, 204, 255));
        card1.setColorGradient(new java.awt.Color(102, 51, 255));

        card2.setBackground(new java.awt.Color(255, 51, 102));
        card2.setColorGradient(new java.awt.Color(255, 153, 153));

        card3.setBackground(new java.awt.Color(51, 255, 153));
        card3.setColorGradient(new java.awt.Color(0, 153, 153));

        tbHoaDonThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        tbHoaDonThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ngày thanh toán", "Doanh thu", "Số hóa đơn thanh toán"
            }
        ));
        jScrollPane2.setViewportView(tbHoaDonThanhToan);

        txtDateStart.setDateFormatString(org.openide.util.NbBundle.getMessage(ThongKeDoanhThu.class, "ThongKeDoanhThu.txtDateStart.dateFormatString")); // NOI18N

        txtDateEnd.setDateFormatString(org.openide.util.NbBundle.getMessage(ThongKeDoanhThu.class, "ThongKeDoanhThu.txtDateEnd.dateFormatString")); // NOI18N

        btnLoc.setBackground(new java.awt.Color(0, 153, 204));
        btnLoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnLoc, org.openide.util.NbBundle.getMessage(ThongKeDoanhThu.class, "ThongKeDoanhThu.btnLoc.text")); // NOI18N
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ThongKeDoanhThu.class, "ThongKeDoanhThu.jLabel1.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ThongKeDoanhThu.class, "ThongKeDoanhThu.jLabel2.text")); // NOI18N

        btnExportExcel.setBackground(new java.awt.Color(0, 102, 51));
        btnExportExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportExcel.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnExportExcel, org.openide.util.NbBundle.getMessage(ThongKeDoanhThu.class, "ThongKeDoanhThu.btnExportExcel.text")); // NOI18N
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        tbThongKeThang.setBackground(new java.awt.Color(255, 255, 255));
        tbThongKeThang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tháng", "Số lượng bán ra", "Doanh thu"
            }
        ));
        jScrollPane1.setViewportView(tbThongKeThang);

        btnExportDoanhThu.setBackground(new java.awt.Color(0, 102, 51));
        btnExportDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnExportDoanhThu, org.openide.util.NbBundle.getMessage(ThongKeDoanhThu.class, "ThongKeDoanhThu.btnExportDoanhThu.text")); // NOI18N
        btnExportDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportDoanhThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExportDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnLoc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2)
                                .addComponent(jScrollPane1)))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btnExportDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDateStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDateEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        //     List<HoaDonThanhToan> list = hdctSer.getHoaDonThanhToan();

        Date start = txtDateStart.getDate();
        Date end = txtDateEnd.getDate();
        String pattern = "yyyy-MM-dd ";
        DateFormat df = new SimpleDateFormat(pattern);
        String st = df.format(start);
        String en = df.format(end);
        List<HoaDonThanhToan> tt = hdctSer.filterDate(st, en);
        loadTableDoanhSo(tt);

//        hdctSer.filterDate(start, end);
        //  JOptionPane.showMessageDialog(this, "Hmm");
//        loadTableDoanhSo(list);
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export Excel");
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                int xn = JOptionPane.showConfirmDialog(this, "Export file ?");
                if (xn == JOptionPane.YES_OPTION) {
                    ExportSoHDTT.writeExcel(hdctSer.getHoaDonThanhToan(), fileToSave.getAbsolutePath() + filter.getDescription());
                    JOptionPane.showMessageDialog(this, "Export success");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Export thất bại");
            }
            System.out.println("Save as file: " + fileToSave.getAbsolutePath() + filter.getDescription());
        }
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void btnExportDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportDoanhThuActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export Excel");
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                int xn = JOptionPane.showConfirmDialog(this, "Export file ?");
                if (xn == JOptionPane.YES_OPTION) {
                    ExportThongKeThang.writeExcel(hdctSer.getThongKeThang(), fileToSave.getAbsolutePath() + filter.getDescription());
                    JOptionPane.showMessageDialog(this, "Export success");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Export thất bại");
            }
            System.out.println("Save as file: " + fileToSave.getAbsolutePath() + filter.getDescription());
        }
    }//GEN-LAST:event_btnExportDoanhThuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportDoanhThu;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnLoc;
    private component.Card card1;
    private component.Card card2;
    private component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.table.Table tbHoaDonThanhToan;
    private swing.table.Table tbThongKeThang;
    private com.toedter.calendar.JDateChooser txtDateEnd;
    private com.toedter.calendar.JDateChooser txtDateStart;
    // End of variables declaration//GEN-END:variables
}
