/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.security.MessageDigest;
import javax.swing.JOptionPane;
import model.NhanVien;

import view.QuanLySanPham;
import javax.swing.JFrame;
import service.impl.NhanVienImpl;
import service.NhanVienService;

/**
 *
 * @author HP
 */
public class Login1 extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */

    NhanVienService nhanVienService = new NhanVienImpl();

    
    


    public Login1() {
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

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lbnMesMa = new javax.swing.JLabel();
        lbnMesPass = new javax.swing.JLabel();
        lbnMes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 130, 30));

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Exit");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 110, 30));
        jPanel2.add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 160, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên đăng nhập");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 160, -1));
        jPanel2.add(lbnMesMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 160, -1));
        jPanel2.add(lbnMesPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 160, -1));

        lbnMes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(lbnMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 210, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    public static String doHashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] result = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
        }
        return "";
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String maNv = txtMa.getText();
        if (maNv.trim().isEmpty()) {
            lbnMesMa.setText("Mã nhân viên trống");
            lbnMesMa.setForeground(Color.red);
            return;
        } else {
            lbnMesMa.setText("");
        }

        String pass = new String(txtPass.getPassword());
        if (pass.trim().isEmpty()) {
            lbnMesPass.setText("Mật khẩu trống");
            lbnMesPass.setForeground(Color.red);
            return;
        } else {
            lbnMesPass.setText("");
        }

        NhanVien nhanVien = nhanVienService.getNhanVien(maNv);
        if (nhanVien != null) {
            if (nhanVien.getPass().equalsIgnoreCase((pass))) {
                if (nhanVien.getChucVu().getId() == 1) {
                    this.dispose();
                    new Main().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn là quản lí");
                    this.dispose();
                    new Main().setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không khớp");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại");
            return;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbnMes;
    private javax.swing.JLabel lbnMesMa;
    private javax.swing.JLabel lbnMesPass;
    private javax.swing.JTextField txtMa;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
