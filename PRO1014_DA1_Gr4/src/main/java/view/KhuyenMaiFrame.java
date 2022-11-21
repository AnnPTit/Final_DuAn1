/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhuyenMai;
//import service.KhuyenMaiInter;
//import service.imple.KhuyenMaiSer;

/**
 *
 * @author T450s
 */
public class KhuyenMaiFrame extends javax.swing.JFrame {

//    private KhuyenMaiInter kms = new KhuyenMaiSer();
//
//    private LayNgayFrame lnf = new LayNgayFrame();

    /**
     * Creates new form KhuyenMaiFrame
     */
    public KhuyenMaiFrame() {
        initComponents();
        rdoCo.setSelected(true);
        cbbTrangThai.setSelectedIndex(0);
    }

    public void loadTable(int tt) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblKhuyenMai.getModel();
        dtm.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
//        for (KhuyenMai km : kms.getAll(tt)) {
//            Object rowData[] = {
//                km.getId(),
//                km.getMakm(),
//                km.getTenkm(),
//                sdf.format(km.getNgayTao()),
//                km.getPhantramgiam(),
//                km.getMinhoadon(),
//                sdf.format(km.getNgayhethan()),
//                km.getGhichu(),
//                km.getTrangthai()
//            };
//            dtm.addRow(rowData);
//        }
    }

    public KhuyenMai getForm() {

        boolean isValid = true;
//        String maKm = this.txtMaKm.getText().trim();
        String tenKm = this.txtTenKm.getText().trim();
        if (tenKm.length() == 0) {
            //JOptionPane.showMessageDialog(this, " Ban de trong ten khuyen mai");
            lbnMesTenKM.setText("Bạn để trống tên khuyến mãi");
            lbnMesTenKM.setForeground(Color.red);
            txtTenKm.requestFocus();
            isValid = false;
        } else {
            lbnMesTenKM.setText("");
        }
        String ngayHet = this.txtNgayHetHan.getText().trim();
        if (ngayHet.length() == 0) {
            lblMesNgayHet.setText("Bạn bỏ trống ngày hết hạn");
            lblMesNgayHet.setForeground(Color.red);
            txtNgayHetHan.requestFocus();
            isValid = false;
        } else {
            lblMesNgayHet.setText("");
        }
        String moTa = this.txtGhiChu.getText().trim();
        if (moTa.length() == 0) {
            lblMesMoTa.setText("Bạn bỏ trống mô tả ");
            lblMesMoTa.setForeground(Color.red);
            isValid = false;
        } else {
            lblMesMoTa.setText("");
        }
        String ngayTao = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

        String dieuKien = this.txtDieuKien.getText().trim();
        int DkapDung = 0;
        String phanGiam = this.txtPhanTramGiam.getText().trim();
        int phtramGiam = 0;
        if (dieuKien.length() == 0) {
            lblMesDK.setText("Bạn để trống điều kiện");
            lblMesDK.setForeground(Color.red);
            txtDieuKien.requestFocus();
            isValid = false;
        }
        if (phanGiam.length() == 0) {
            lblMesPTram.setText("Bạn để trống phần trăm giảm");
            lblMesPTram.setForeground(Color.red);
            isValid = false;
        } else {
            try {
                //phtramGiam = Integer.valueOf(phanGiam);
                DkapDung = Integer.valueOf(dieuKien);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                lblMesDK.setText("Sai định dạng số");
                lblMesDK.setForeground(Color.red);
                txtDieuKien.requestFocus();
                isValid = false;
                return null;
            }

            if (DkapDung <= 0) {
                lblMesDK.setText("Điều kiện nhỏ hơn 0");
                lblMesDK.setForeground(Color.red);
                txtDieuKien.requestFocus();
                isValid = false;
                return null;
            } else {
                lblMesDK.setText("");
            }

            try {
                phtramGiam = Integer.valueOf(phanGiam);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                lblMesPTram.setText("Sai định dạng số");
                lblMesPTram.setForeground(Color.red);
                txtPhanTramGiam.requestFocus();
                isValid = false;
                return null;

            }

            if (phtramGiam <= 0) {
                lblMesPTram.setText("Phần trăm số nhỏ hơn 0");
                lblMesPTram.setForeground(Color.red);
                txtPhanTramGiam.requestFocus();
                isValid = false;
                return null;
            } else {
                lblMesPTram.setText("");
            }

        }

        int tthai = 1;
//        String maKm = "KM00" + (kms.getList().size() + 1);
//        if (rdoCo.isSelected()) {
//            tthai = 1;
//        } else {
//            tthai = 0;
//        }

        Date ngtao, ngHet;
        ngtao = Date.valueOf(ngayTao);
        try {

            ngHet = Date.valueOf(ngayHet);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Sai dinh dang ngay");
            return null;
        }

        if (isValid == false) {
            return null;
        } else {
//            KhuyenMai km = new KhuyenMai(0, maKm, tenKm, ngtao, phtramGiam, DkapDung, ngHet, moTa, tthai);
            return null;
        }

    }

    public void clearForm() {
        lblId.setText("-");
        txtMaKm.setText("");
        txtTenKm.setText("");
        txtNgayTao.setText("");
        txtPhanTramGiam.setText("");
        txtDieuKien.setText("");
        txtNgayHetHan.setText("");
        txtGhiChu.setText("");
        rdoCo.setSelected(true);
        tblKhuyenMai.clearSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKm = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhanTramGiam = new javax.swing.JTextField();
        txtDieuKien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayHetHan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        rdoCo = new javax.swing.JRadioButton();
        rdoKo = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cbbTrangThai = new javax.swing.JComboBox<>();
        lbnMesTenKM = new javax.swing.JLabel();
        lblMesDK = new javax.swing.JLabel();
        lblMesPTram = new javax.swing.JLabel();
        lblMesMoTa = new javax.swing.JLabel();
        lblMesNgayHet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id");

        lblId.setText("-");

        jLabel2.setText("Mã Km");

        jLabel3.setText("Tên Km");

        jLabel4.setText("Ngày Tạo");

        jLabel5.setText("Phần trăm giảm");

        jLabel6.setText("Điều kiện áp dụng");

        jLabel7.setText("Ngày Hết Hạn");

        jLabel8.setText("Ghi chú");

        rdoCo.setBackground(new java.awt.Color(255, 51, 255));
        buttonGroup1.add(rdoCo);
        rdoCo.setForeground(new java.awt.Color(255, 255, 51));
        rdoCo.setText("Hoạt Động");

        rdoKo.setBackground(new java.awt.Color(255, 0, 255));
        buttonGroup1.add(rdoKo);
        rdoKo.setForeground(new java.awt.Color(255, 255, 51));
        rdoKo.setText("Không Hoạt Động");

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Xóa Form");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ma Km", "Ten Km", "Ngay Tao", "Phan Tram Giam", "Dieu Kien", "Ngay Het", "Ghi Chu", "Trang Thai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setForeground(new java.awt.Color(51, 255, 204));
        jButton5.setText("Áp ngày");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 51, 255));
        jButton7.setForeground(new java.awt.Color(51, 255, 204));
        jButton7.setText("Chọn ngày");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn khuyến mãi", "Hết khuyến mãi" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTenKm, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtPhanTramGiam)
                                                    .addComponent(txtNgayHetHan, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                                            .addComponent(lblMesNgayHet, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(380, 380, 380)
                                        .addComponent(lblMesMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rdoCo)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jButton5)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jButton7)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(4, 4, 4)
                                                        .addComponent(rdoKo)
                                                        .addGap(38, 38, 38)
                                                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel8))
                                                        .addGap(146, 146, 146))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(197, 197, 197)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4)))
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMaKm, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(62, 62, 62))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblMesPTram, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMesDK, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(149, 149, 149)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lbnMesTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblId)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(lbnMesTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMesPTram, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMesMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdoCo)
                                    .addComponent(rdoKo)
                                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblMesNgayHet, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMesDK, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        int row = this.tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Moi ban chon lai dong");
            return;
        }
        lblId.setText(this.tblKhuyenMai.getValueAt(row, 0).toString());
        txtMaKm.setText(this.tblKhuyenMai.getValueAt(row, 1).toString());
        txtTenKm.setText(this.tblKhuyenMai.getValueAt(row, 2).toString());
        txtNgayTao.setText(this.tblKhuyenMai.getValueAt(row, 3).toString());
        txtPhanTramGiam.setText(this.tblKhuyenMai.getValueAt(row, 4).toString());
        txtDieuKien.setText(this.tblKhuyenMai.getValueAt(row, 5).toString());
        txtNgayHetHan.setText(this.tblKhuyenMai.getValueAt(row, 6).toString());
        txtGhiChu.setText(this.tblKhuyenMai.getValueAt(row, 7).toString());
        String tt = this.tblKhuyenMai.getValueAt(row, 8).toString();
        int trangt = Integer.valueOf(tt);
        if (trangt == 1) {
            rdoCo.setSelected(true);
        } else {
            rdoKo.setSelected(true);
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        KhuyenMai km = this.getForm();
        if (km == null) {
            // JOptionPane.showMessageDialog(this, "Moi ban check lai form");
            return;
        }
//        kms.add(km);
        JOptionPane.showMessageDialog(this, "Them thanh cong");
        loadTable(1);
        clearForm();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = this.tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Moi ban chon lai dong");
            return;
        }
        String id = this.tblKhuyenMai.getValueAt(row, 0).toString();
        int idm = Integer.valueOf(id);

        int chooser = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa");
        if (chooser == 0) {
//            this.kms.remove(idm);
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
            loadTable(1);
            clearForm();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = this.tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Moi ban chon lai dong");
            return;
        }
        String id = this.tblKhuyenMai.getValueAt(row, 0).toString();

        KhuyenMai km = this.getForm();
        if (km == null) {
            JOptionPane.showMessageDialog(this, "Moi ban check lai form");
            return;
        }
        int idm = Integer.valueOf(id);
        int chooser = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa");
        if (chooser == 0) {
//            kms.update(km, idm);
            JOptionPane.showMessageDialog(this, "Sua thanh cong");
            loadTable(1);
            clearForm();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
//        lnf.setVisible(true);
//        lnf.setBounds(290, 200, 500, 500);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        txtNgayHetHan.setText(lnf.getDate());
//        lnf.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        int index = cbbTrangThai.getSelectedIndex();
        System.out.println(index);
        int tt =0;
        if(index==0){
            tt=1;
        }else{
            tt=0;
        }
        loadTable(tt);
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-foldBan defaultstate="collapsed"Ban desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with theBan default look and feel.
         * ForBan details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhuyenMaiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMesDK;
    private javax.swing.JLabel lblMesMoTa;
    private javax.swing.JLabel lblMesNgayHet;
    private javax.swing.JLabel lblMesPTram;
    private javax.swing.JLabel lbnMesTenKM;
    private javax.swing.JRadioButton rdoCo;
    private javax.swing.JRadioButton rdoKo;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaKm;
    private javax.swing.JTextField txtNgayHetHan;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtPhanTramGiam;
    private javax.swing.JTextField txtTenKm;
    // End of variables declaration//GEN-END:variables
}
