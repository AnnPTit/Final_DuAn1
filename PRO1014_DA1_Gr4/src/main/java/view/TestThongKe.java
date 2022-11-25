package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDonChiTiet;
import service.impl.HDCTImpl;
import service.IHDCTService;

/**
 *
 * @author fallinluv2003
 */
public class TestThongKe extends javax.swing.JFrame {

    private IHDCTService hdctSer = new HDCTImpl();
    private List<HoaDonChiTiet> hdct = new ArrayList<>();

    public TestThongKe() {
        initComponents();
        tableDoanhSo(hdct);
    }

    // Thêm TestThongKe
    void tableDoanhSo(List<HoaDonChiTiet> list) {
        DefaultTableModel model = (DefaultTableModel) tbDoanhSo.getModel();
        model.setRowCount(0);
 
        list = new HDCTImpl().getAll();
        for (HoaDonChiTiet x : list) {
            model.addRow(x.toDoanhSo());
        }
//        for (int i = 0; i < list.size(); i++) {
//            int soLuong = 0; // de anh suy nghi them :)) 
//            soLuong = list.get(i).getSoLuong();
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(i).getChiTietSanPham().getId() == list.get(j).getChiTietSanPham().getId()) {
//                    soLuong = soLuong + list.get(j).getSoLuong();
//                    list.get(i).setSoLuong(soLuong);
//                    model.addRow(new Object[]{
//                        list.get(i).getChiTietSanPham().getMa(),
//                        list.get(i).getChiTietSanPham().getSanPham().getTenSP(),
//                        list.get(i).getSoLuong()
//                    });
//                }
//            }
//
//        }
//        for (HoaDonChiTiet hoaDonChiTiet : list) {
//            String ma = hoaDonChiTiet.getChiTietSanPham().getMa();
//            int soLuong = hoaDonChiTiet.getSoLuong();
//            for (HoaDonChiTiet hoaDonChiTiet1 : list) {
//                if (hoaDonChiTiet1.getChiTietSanPham().getMa().equalsIgnoreCase(ma)) {
//                    soLuong = soLuong + hoaDonChiTiet1.getSoLuong();
//                    hoaDonChiTiet.setSoLuong(soLuong);
//                }
//                model.addRow(new Object[]{
//                hoaDonChiTiet.getChiTietSanPham().getMa(),
//                hoaDonChiTiet.getChiTietSanPham().getSanPham().getTenSP(),
//                hoaDonChiTiet.getSoLuong()
//            });
//            }
//        }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDoanhSo = new com.raven.suportSwing.TableColumn();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbDoanhSo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán ra", "Doanh thu"
            }
        ));
        jScrollPane1.setViewportView(tbDoanhSo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TestThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.suportSwing.TableColumn tbDoanhSo;
    // End of variables declaration//GEN-END:variables

}
