package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.DanhMuc;
import model.GioHang;
import model.GioHangChiTiet;
import model.HoaDonBan;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KhuyenMai;
import model.Mau;
import model.NSX;
import model.NhanVien;
import service.CTSPService;
import service.IGioHangService;
import service.IHoaDonService;
import service.impl.CTSPImpl;
import service.impl.ChatLieuImpl;
import service.impl.DanhMucImpl;
import service.impl.GioHangImpl;
import service.impl.HoaDonBanSer;
import service.impl.KhuyenMaiSer;
import service.impl.MauSacImpl;
import service.impl.NSXImpl;
import service.impl.NhanVienImpl;
import service.impl.SanPhamImp;
import utilities.Auth;
import utilities.DataGlobal;

public class QuanLyBanHang extends javax.swing.JPanel {

    DefaultTableModel hoaDonModel = new DefaultTableModel();
    DefaultTableModel chiTietSpModel = new DefaultTableModel();
    DefaultTableModel gioHangModel = new DefaultTableModel();
    CTSPService cTSPService = new CTSPImpl();
    List<ChiTietSanPham> listCtSp = new ArrayList<>();
    List<HoaDonBan> listHoaDonBan = new ArrayList<>();
    List<GioHangChiTiet> listGioHangChiTiet = new ArrayList<>();
    IHoaDonService hoaDonBanService = new HoaDonBanSer();
    IGioHangService gioHangService = new GioHangImpl();
    DefaultComboBoxModel<DanhMuc> cbDM = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<ChatLieu> cbCL = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<Mau> cbMau = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<NSX> cbNSX = new DefaultComboBoxModel<>();
    int soLuong = 0;

    public QuanLyBanHang() {
        initComponents();
        chiTietSpModel = (DefaultTableModel) tblSanPham.getModel();
        hoaDonModel = (DefaultTableModel) tblHoaDon.getModel();
        gioHangModel = (DefaultTableModel) tblGioHang.getModel();
        listCtSp = cTSPService.getAll();
        listHoaDonBan = hoaDonBanService.getListHoaDonBan();
        loadTableHoaDon(listHoaDonBan);
        loadTableCTSP(listCtSp);
        btnThanhToan.setEnabled(false);
        loadAllCB();
    }

    private void loadTableCTSP(List<ChiTietSanPham> list) {
        chiTietSpModel.setNumRows(0);
        for (ChiTietSanPham ctsp : list) {
            chiTietSpModel.addRow(new Object[]{
                ctsp.getSanPham().getMaSP(),
                ctsp.getSanPham().getTenSP(),
                ctsp.getNhaSanXuat().getTenNSX(),
                ctsp.getDanhMuc().getTenDM(),
                ctsp.getChatLieu().getTenCL(),
                ctsp.getMauSac().getTenMau(),
                ctsp.getSoLuongTon(),
                ctsp.getGiaBan(),
                ctsp.getMoTa()
            });
        }
    }

    private void loadTableHoaDon(List<HoaDonBan> list) {
        hoaDonModel.setNumRows(0);
        for (HoaDonBan hd : list) {
            hoaDonModel.addRow(new Object[]{
                hd.getMaHDB(), hd.getNhanVien().getTenNV(), hd.getKhachHang().getTenKH(), hd.getNgayTao()
            });
        }
    }

    private void loadTableGioHang(List<GioHangChiTiet> list) {
        gioHangModel.setNumRows(0);
        double giaBan = 0;
        double donGia = 0;
        double tongTien = 0;

        for (GioHangChiTiet ghct : list) {
            giaBan = (ghct.getChiTietSanPham().getGiaBan()).doubleValue();
            donGia = giaBan * ghct.getSoLuong();
            tongTien = tongTien + donGia;
            gioHangModel.addRow(new Object[]{
                ghct.getChiTietSanPham().getMa(), ghct.getChiTietSanPham().getSanPham().getTenSP(), ghct.getSoLuong(), ghct.getChiTietSanPham().getGiaBan(),
                donGia
            }
            );
        }
        lbnTongTien.setText(String.valueOf(tongTien));
        lbnTongTien.setForeground(Color.red);
    }

//    void loadCbSanPham() {
//        cbbSanPham.setModel((DefaultComboBoxModel) cbSP);
//        cbSP.removeAllElements();
//        for (SanPham sp : new SanPhamImp().getAll()) {
//            cbSP.addElement(sp);
//        }
//    }
    void loadCbDanhMuc() {
        cbbDanhMuc.setModel((DefaultComboBoxModel) cbDM);
        cbDM.removeAllElements();
        for (DanhMuc dm : new DanhMucImpl().getAll()) {
            cbDM.addElement(dm);
        }
    }

    void loadCbChatLieu() {
        cbbCL.setModel((DefaultComboBoxModel) cbCL);
        cbCL.removeAllElements();
        for (ChatLieu cl : new ChatLieuImpl().getAll()) {
            cbCL.addElement(cl);
        }
    }

    void loadCbMauSac() {
        cbbMau.setModel((DefaultComboBoxModel) cbMau);
        cbMau.removeAllElements();
        for (Mau mau : new MauSacImpl().getAll()) {
            cbMau.addElement(mau);
        }
    }

    void loadCbNSX() {
        cbbNSX.setModel((DefaultComboBoxModel) cbNSX);
        cbNSX.removeAllElements();
        for (NSX nsx : new NSXImpl().getAll()) {
            cbNSX.addElement(nsx);
        }
    }

    public void loadAllCB() {
        loadCbChatLieu();
        loadCbDanhMuc();
        loadCbMauSac();
        loadCbNSX();

    }

    void searchByName() {
        DefaultTableModel tb = (DefaultTableModel) tblSanPham.getModel();
        tb.setRowCount(0);

        List<ChiTietSanPham> ct = cTSPService.getAll();
        for (ChiTietSanPham ctsp : ct) {
            if (ctsp.getSanPham().getTenSP().toLowerCase().contains(txtSearch.getText().trim().toLowerCase())) {
                tb.addRow(new Object[]{
                    ctsp.getSanPham().getMaSP(),
                    ctsp.getSanPham().getTenSP(),
                    ctsp.getNhaSanXuat().getTenNSX(),
                    ctsp.getDanhMuc().getTenDM(),
                    ctsp.getChatLieu().getTenCL(),
                    ctsp.getMauSac().getTenMau(),
                    ctsp.getSoLuongTon(),
                    ctsp.getGiaBan(),
                    ctsp.getMoTa()
                });
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbbNSX = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbbCL = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbbMau = new javax.swing.JComboBox<>();
        btnThemVaoGioHang = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbnMaKh = new javax.swing.JLabel();
        lbnTenKh = new javax.swing.JLabel();
        btnThayDoi = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbnMaHD = new javax.swing.JLabel();
        lbnNgayTao = new javax.swing.JLabel();
        lbnTongTien = new javax.swing.JLabel();
        lbnTienThua = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHoaDonw = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbnKhuyenMai = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1470, 781));

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel7ComponentAdded(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel8.text_1")); // NOI18N

        txtSearch.setText(org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.txtSearch.text_1")); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel9.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel10.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel11.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel12.text_1")); // NOI18N

        btnThemVaoGioHang.setBackground(new java.awt.Color(0, 153, 204));
        btnThemVaoGioHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemVaoGioHang.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnThemVaoGioHang, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.btnThemVaoGioHang.text_1")); // NOI18N
        btnThemVaoGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoGioHangActionPerformed(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Nsx", "Danh Mục", "Chất liệu", "Màu", "Số Lượng Tồn", "Đơn Giá", "Mô Tả"
            }
        ));
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemVaoGioHang)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(cbbCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnThemVaoGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel7.text_1")); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên Nhân Viên", "Tên Khách Hàng", "Ngày Tạo"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel14.text_1")); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/vodien.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel15, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel15.text_1")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7))
                            .addComponent(jLabel14)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel15)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên Sản phẩm", "Số lượng ", "Đơn giá ", "Thành tiền"
            }
        ));
        jScrollPane4.setViewportView(tblGioHang);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel16, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel16.text_1")); // NOI18N

        jButton8.setBackground(new java.awt.Color(0, 153, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jButton8, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jButton8.text_1")); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 153, 204));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jButton9, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jButton9.text_1")); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel1.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel2.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbnMaKh, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.lbnMaKh.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbnTenKh, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.lbnTenKh.text_1")); // NOI18N

        btnThayDoi.setBackground(new java.awt.Color(0, 153, 204));
        btnThayDoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThayDoi.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnThayDoi, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.btnThayDoi.text_1")); // NOI18N
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });

        btnChon.setBackground(new java.awt.Color(0, 153, 204));
        btnChon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChon.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnChon, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.btnChon.text_1")); // NOI18N
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThayDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbnMaKh)
                    .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbnTenKh)
                    .addComponent(btnThayDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel3.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel4.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel5.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel6.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel13.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbnMaHD, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.lbnMaHD.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbnNgayTao, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.lbnNgayTao.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbnTongTien, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.lbnTongTien.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbnTienThua, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.lbnTienThua.text_1")); // NOI18N

        txtTienKhachDua.setText(org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.txtTienKhachDua.text_1")); // NOI18N
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jButton1.text_1")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jButton4, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jButton4.text_1")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(0, 153, 204));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnThanhToan, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.btnThanhToan.text_1")); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHoaDonw.setBackground(new java.awt.Color(0, 153, 204));
        btnTaoHoaDonw.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHoaDonw.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnTaoHoaDonw, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.btnTaoHoaDonw.text_1")); // NOI18N
        btnTaoHoaDonw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonwActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jButton2.text_1")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lbnKhuyenMai, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.lbnKhuyenMai.text_1")); // NOI18N

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jButton3.text_1")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel17, org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jLabel17.text")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13)
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbnTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(lbnNgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbnMaHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbnTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnTaoHoaDonw)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbnMaHD))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbnNgayTao))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbnTongTien))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbnTienThua))
                .addGap(47, 47, 47)
                .addComponent(btnTaoHoaDonw, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(QuanLyBanHang.class, "QuanLyBanHang.jPanel2.TabConstraints.tabTitle_1"), jPanel2); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 137, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1358, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        searchByName();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnThemVaoGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoGioHangActionPerformed
        // TODO add your handling code here:

        if (Auth.getKh() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng", "ERORR", JOptionPane.ERROR_MESSAGE);
            return;
        } // check thông tin khách hàng

        int row = tblSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần thêm !", "ERORR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp = listCtSp.get(row);
        int soLuong, soLuongTon = 0;

        String m = JOptionPane.showInputDialog("Số sản phẩm muốn mua :");
        try {
            soLuong = Integer.valueOf(m);
            System.out.println(soLuong);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng số");
            return;
        } //get số lượng

        soLuongTon = (int) tblSanPham.getValueAt(row, 6);
        if (soLuong > soLuongTon || soLuong < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng > 0 & Số lượng < Số lượng tồn ");
            return;
        } // check input

        GioHang gioHang = gioHangService.getGioHangByKH(Auth.getKh().getId());
        listGioHangChiTiet = gioHangService.getGioHangChiTiet(gioHang.getId());
        //        for (GioHangChiTiet ghct : listGioHangChiTiet) {
        //            if (ghct.getChiTietSanPham().getMa().equalsIgnoreCase(ctsp.getMa())) {
        //                ghct.setSoLuong(ghct.getSoLuong() + soLuong);
        //            }
        //            if (ghct.getSoLuong() > soLuongTon) {
        //                JOptionPane.showMessageDialog(this, "Vượt quá số lượng");
        //                return;
        //            }
        //        }

        //================================================================================
        //        GioHang gioHang = new GioHang();
        //        gioHang = gioHangService.getGioHangByKH(Auth.getKh().getId());
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setGioHang(gioHang);
        gioHangChiTiet.setChiTietSanPham(ctsp);
        gioHangChiTiet.setSoLuong(soLuong);
        gioHangChiTiet.setTrangThai(1);
        if (listGioHangChiTiet.size() == 0) {
            try {
                gioHangService.addGHCT(gioHangChiTiet);
                JOptionPane.showMessageDialog(this, "Thành công !");
            } catch (Exception e) {
                System.out.println("Lỗi");
                return;
            }
        }

        boolean isValid = true;
        boolean update = true;
        for (GioHangChiTiet gioHangChiTiet1 : listGioHangChiTiet) {
            if (gioHangChiTiet1.getChiTietSanPham().getMa().equalsIgnoreCase(gioHangChiTiet.getChiTietSanPham().getMa())) {
                int sl = gioHangChiTiet1.getSoLuong();
                sl = (gioHangChiTiet1.getSoLuong() + soLuong);
                gioHangService.updateSoLuongGioHang(gioHangChiTiet1.getId(), sl);
                update = false;
                if (sl > (int) tblSanPham.getValueAt(row, 6)) {
                    JOptionPane.showMessageDialog(this, "Vượt quá số lượng !", "ERORR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } else {
                isValid = false;
            }
        }
        if (isValid == false && update == true) {
            try {
                gioHangService.addGHCT(gioHangChiTiet);
                JOptionPane.showMessageDialog(this, "Thành công !");
            } catch (Exception e) {
                System.out.println("Lỗi");
                return;
            }
        }
        loadTableGioHang(gioHangService.getGioHangChiTiet(gioHang.getId()));
    }//GEN-LAST:event_btnThemVaoGioHangActionPerformed

    private void jPanel7ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel7ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7ComponentAdded

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        listHoaDonBan = hoaDonBanService.getListHoaDonBan();
        int row = tblHoaDon.getSelectedRow();

        HoaDonBan hoaDonBan = listHoaDonBan.get(row);
        // lbnTongTien.setText("00");
        lbnMaHD.setText(hoaDonBan.getMaHDB());
        lbnNgayTao.setText(String.valueOf(hoaDonBan.getNgayTao()));
        lbnMaHD.setForeground(Color.red);
        lbnNgayTao.setForeground(Color.red);
        lbnMaKh.setText(hoaDonBan.getKhachHang().getMaKH());
        lbnTenKh.setText(hoaDonBan.getKhachHang().getTenKH());
        lbnMaKh.setForeground(Color.red);
        lbnTenKh.setForeground(Color.red);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (Auth.getKh() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng !");
            return;
        }
        GioHang gioHang = gioHangService.getGioHangByKH(Auth.getKh().getId());
        listGioHangChiTiet = gioHangService.getGioHangChiTiet(gioHang.getId());
        int row = tblGioHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa !");
            return;
        }
        GioHangChiTiet ghct = listGioHangChiTiet.get(row);
        String result = gioHangService.deleteGhct(ghct);
        JOptionPane.showMessageDialog(this, result);
        loadTableGioHang(gioHangService.getGioHangChiTiet(gioHang.getId()));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (Auth.getKh() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng");
            return;
        }
        GioHang gioHang = gioHangService.getGioHangByKH(Auth.getKh().getId());
        listGioHangChiTiet = gioHangService.getGioHangChiTiet(gioHang.getId());
        for (GioHangChiTiet gioHangChiTiet : listGioHangChiTiet) {
            gioHangService.deleteGhct(gioHangChiTiet);
        }
        loadTableGioHang(gioHangService.getGioHangChiTiet(gioHang.getId()));
        JOptionPane.showMessageDialog(this, "Thành công !");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed
        // TODO add your handling code here:
        KhachHang kh = Auth.getKh();
        if (kh == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng !");
            return;
        }
        System.out.println(kh);
        lbnMaKh.setText(kh.getMaKH());
        lbnMaKh.setForeground(Color.red);
        lbnTenKh.setText(kh.getTenKH());
        lbnTenKh.setForeground(Color.red);

        GioHang gioHang = gioHangService.getGioHangByKH(kh.getId());
        listGioHangChiTiet = gioHangService.getGioHangChiTiet(gioHang.getId());
        loadTableGioHang(listGioHangChiTiet);
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            return;
        }
        HoaDonBan hdb = listHoaDonBan.get(row);
        hdb.setKhachHang(kh);

        hoaDonBanService.updateKH(hdb);
        System.out.println("Thành công ");
        loadTableHoaDon(hoaDonBanService.getListHoaDonBan());
    }//GEN-LAST:event_btnThayDoiActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        DsKH dkh = new DsKH();
        dkh.setVisible(true);
    }//GEN-LAST:event_btnChonActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:
        String tienKhachDua = txtTienKhachDua.getText();

        if (txtTienKhachDua.getText().trim().isBlank()) {
            lbnTienThua.setText("");
            return;
        }
        try {
            double tienKH = Double.valueOf(tienKhachDua);
            double tongTien = Double.valueOf(lbnTongTien.getText());
            double tienThua = tienKH - tongTien;
            lbnTienThua.setText(String.valueOf(tienThua));
            if (lbnTienThua.getText().trim().isEmpty()) {
                btnThanhToan.setEnabled(false);
            } else {
                btnThanhToan.setEnabled(true);
            }
            if (tienThua < 0) {
                btnThanhToan.setEnabled(false);
            } else {
                btnThanhToan.setEnabled(true);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
            return;
            // e.printStackTrace();
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn ");
            return;
        }
        HoaDonBan hoaDonBan = listHoaDonBan.get(row);
        hoaDonBanService.updateTrangThaiHoaDon(hoaDonBan.getId(), 0);
        JOptionPane.showMessageDialog(this, "Thành công" + hoaDonBan.getMaHDB());
        loadTableHoaDon(hoaDonBanService.getListHoaDonBan());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        lbnMaKh.setText("");
        lbnTenKh.setText("");
        lbnMaHD.setText("");
        lbnNgayTao.setText("");
        lbnKhuyenMai.setText("");
        lbnTienThua.setText("0");
        lbnTongTien.setText("0");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        listHoaDonBan = hoaDonBanService.getListHoaDonBan();
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán");
            return;
        }
        HoaDonBan hdb = listHoaDonBan.get(row);

        GioHang gioHang = gioHangService.getGioHangByKH(Auth.getKh().getId());
        listGioHangChiTiet = gioHangService.getGioHangChiTiet(gioHang.getId());
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();

        for (GioHangChiTiet gioHangChiTiet : listGioHangChiTiet) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDonBan(hdb);
            hoaDonChiTiet.setChiTietSanPham(gioHangChiTiet.getChiTietSanPham());
            hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
            hoaDonChiTiet.setTrangThai(2);
            listHDCT.add(hoaDonChiTiet);
        }
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
            hoaDonBanService.addHoaDonChiTiet(hoaDonChiTiet);
        }

        gioHangService.updateTrangThaiGHCT(gioHang.getId(), 2);
        //hoaDonBanService.updateTrangThaiHoaDon(hdb.getId(), 2);
        Date ngayThanhToan = new Date();
        hdb.setNgayThanhToan(ngayThanhToan);
        KhuyenMai km = DataGlobal.getKhuyenMai();
        hdb.setKhuyenMai(km);
        hdb.setTrangThai(2);
        hoaDonBanService.updateTrangThaiHoaDon(hdb.getId(), 2);
        loadTableGioHang(gioHangService.getGioHangChiTiet(gioHang.getId()));

        JOptionPane.showMessageDialog(this, "Thành công");
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHoaDonwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonwActionPerformed
        HoaDonBan hdb = new HoaDonBan();
        NhanVien nhanVien = new NhanVien();
        nhanVien = Auth.getNv();
        if (nhanVien == null) {
            nhanVien = new NhanVienImpl().getNhanVien("NV00");
        }
        KhachHang khachHang = new KhachHang();
        khachHang = Auth.getKh();
        if (khachHang == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng");
            return;
        }
        String maHD = null;
        listHoaDonBan = hoaDonBanService.getListHoaDonBan();
        if (listHoaDonBan.size() == 0) {
            maHD = "HD01";
        } else {
            HoaDonBan hdb1 = listHoaDonBan.get(0);
            maHD = "HD" + (hdb1.getId() + 1);
        }
        hdb.setNhanVien(nhanVien);
        hdb.setKhachHang(khachHang);
        hdb.setMaHDB(maHD);
        hdb.setKhuyenMai(null);
        hdb.setNgayTao(new Date());
        hdb.setNgayThanhToan(null);
        hdb.setNguoiNhan(khachHang.getTenKH());
        hdb.setSdt(khachHang.getSdt());
        hdb.setDiaChi(khachHang.getDiaChi());
        hdb.setTrangThai(1);

        try {
            String result = hoaDonBanService.insert(hdb);
            JOptionPane.showMessageDialog(this, result);

        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        listHoaDonBan = hoaDonBanService.getListHoaDonBan();
        loadTableHoaDon(listHoaDonBan);
        lbnMaHD.setText(maHD);
        lbnMaHD.setForeground(Color.red);
        lbnNgayTao.setText(String.valueOf(hdb.getNgayTao()));
        lbnNgayTao.setForeground(Color.red);
    }//GEN-LAST:event_btnTaoHoaDonwActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        double totalHoaDon = Double.valueOf(lbnTongTien.getText());

        List<KhuyenMai> list = new ArrayList<>();
        list = new KhuyenMaiSer().getKhuyenMaiMap(totalHoaDon);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Tổng hóa đơn của bạn chưa đạt giá trị tối thiểu ");
            return;
        }

        DataGlobal.setTotalHoaDon(totalHoaDon);
        new DsKhuyenMaiOk().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (DataGlobal.getKhuyenMai() == null) {
            return;
        }
        if (txtTienKhachDua.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa");
            return;
        }
        lbnKhuyenMai.setText(DataGlobal.getKhuyenMai().getTenkm());
        double tongTien = Double.valueOf(lbnTongTien.getText());
        double phamTramGiam = DataGlobal.getKhuyenMai().getPhantramgiam();
        double tongTienSauKM = tongTien - (tongTien * phamTramGiam) / 100;
        lbnTongTien.setText(String.valueOf(tongTienSauKM));
        lbnTienThua.setText(String.valueOf(Double.valueOf(txtTienKhachDua.getText()) - tongTienSauKM));
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnTaoHoaDonw;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JButton btnThemVaoGioHang;
    private javax.swing.JComboBox<String> cbbCL;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbnKhuyenMai;
    private javax.swing.JLabel lbnMaHD;
    private javax.swing.JLabel lbnMaKh;
    private javax.swing.JLabel lbnNgayTao;
    private javax.swing.JLabel lbnTenKh;
    private javax.swing.JLabel lbnTienThua;
    private javax.swing.JLabel lbnTongTien;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
