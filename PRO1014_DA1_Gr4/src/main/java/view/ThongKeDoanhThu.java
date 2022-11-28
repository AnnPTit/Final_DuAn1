package view;

import customModel.HoaDonThanhToan;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ModelCard;
import service.IHDCTService;
import service.impl.HDCTImpl;

/**
 *
 * @author fallinluv2003
 */
public class ThongKeDoanhThu extends javax.swing.JPanel {

    private IHDCTService hdctSer = new HDCTImpl();
    
    public ThongKeDoanhThu() {
        initComponents();
        List<HoaDonThanhToan> list = hdctSer.getHoaDonThanhToan();
        loadTableDoanhSo(list);
        initCardData();
    }
    
    private void initCardData() {
        card1.setData(new ModelCard("Doanh thu hôm nay", hdctSer.doanhThuHomNay(), 20, null));
        card2.setData(new ModelCard("Doanh thu tháng này", hdctSer.doanhThuTheoThang(), 0, null));
        card3.setData(new ModelCard("Doanh thu cả năm", hdctSer.doanhThuTheoNam(), 95, null));
    }

    void loadTableDoanhSo(List<HoaDonThanhToan> list) {
        DefaultTableModel model = (DefaultTableModel) tbHoaDonThanhToan.getModel();
        model.setRowCount(0);
        for (HoaDonThanhToan x : list) {
            model.addRow(new Object[]{
                x.getNgayThanhToan(),x.getDoanhThu(),x.getHoaDonThanhToan()
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new swing.table.Table();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDonThanhToan = new swing.table.Table();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        card1.setBackground(new java.awt.Color(0, 204, 255));
        card1.setColorGradient(new java.awt.Color(102, 51, 255));

        card2.setBackground(new java.awt.Color(255, 51, 102));
        card2.setColorGradient(new java.awt.Color(255, 153, 153));

        card3.setBackground(new java.awt.Color(51, 255, 153));
        card3.setColorGradient(new java.awt.Color(0, 153, 153));

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table1);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Card card1;
    private component.Card card2;
    private component.Card card3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.table.Table table1;
    private swing.table.Table tbHoaDonThanhToan;
    // End of variables declaration//GEN-END:variables
}
