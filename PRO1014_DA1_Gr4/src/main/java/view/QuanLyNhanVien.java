package view;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import model.KhachHang;
import model.NhanVien;
import pagination.Page;
import pagination.style.PaginationItemRenderStyle1;
import service.impl.ChucVuImpl;
import service.impl.NhanVienImpl;
import service.INhanVienService;

/**
 *
 * @author fallinluv2003
 */
public class QuanLyNhanVien extends javax.swing.JPanel {

    private INhanVienService nvSer = new NhanVienImpl();
    private List<NhanVien> nv = new ArrayList<>();
    private DefaultComboBoxModel<ChucVu> cbCV = new DefaultComboBoxModel<>();
    private List<NhanVien> listNV;

    Integer pageSize = 5;
    Integer totalProducts = 0;
    private Page paging = new Page();

    public QuanLyNhanVien() {
        initComponents();

        loadCbbChucVu();
        loadPagination();
        pagination11.setPaginationItemRender(new PaginationItemRenderStyle1());
        pagination11.setPagegination(1, paging.getTotalPage());
    }

    public void loadPagination() {
        String search = txtSearch.getText();

        totalProducts = nvSer.filterNhanVien(search).size();

        int total = (int) Math.ceil(totalProducts / pageSize) + 1;
        paging.setTotalPage(total);
        pagination11.setPagegination(1, paging.getTotalPage());

        if (paging.getTotalPage() < paging.getCurrent()) {
            pagination11.setPagegination(paging.getTotalPage(), paging.getTotalPage());
            loadTable(nvSer.pageListNhanVien(paging.getTotalPage(), pageSize, search));
        } else {
            pagination11.setPagegination(paging.getCurrent(), paging.getTotalPage());
            loadTable(nvSer.pageListNhanVien(paging.getCurrent(), pageSize, search));
        }

        pagination11.addEventPagination((int page) -> {
            loadTable(nvSer.pageListNhanVien(page, pageSize, search));
            paging.setCurrent(page);
        });
    }

    public void loadTable(List<NhanVien> nv) {
        DefaultTableModel dtm = (DefaultTableModel) tbNhanVien.getModel();
        dtm.setRowCount(0);

        for (NhanVien x : nv) {
            Object[] rowData = {
                x.getId(), x.getMaNV(), x.getPass(), x.getTenNV(), x.getChucVu(),
                x.getNgaySinh(), x.getGioiTinh() == true ? "Nam" : "Nữ", x.getDiaChi(),
                x.getSdt(), x.getEmail(), x.getTrangThai() == 1 ? "Đang làm việc" : "Nghỉ việc"
            };
            dtm.addRow(rowData);
        }
    }

    void loadNhanVien(List<NhanVien> list) {
        DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
        model.setRowCount(0);
        list = new NhanVienImpl().getAll();
        for (NhanVien x : list) {
            model.addRow(x.toDataRow());
        }
    }

    void loadCbbChucVu() {
        cbbChucVu.setModel((DefaultComboBoxModel) cbCV);
        cbCV.removeAllElements();
        for (ChucVu cv : new ChucVuImpl().getAll()) {
            cbCV.addElement(cv);
        }
    }

    public void clear() {
        txtMa.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtPass.setText("");
        txtSDT.setText("");
        txtTen.setText("");
        this.cbbChucVu.setSelectedIndex(0);
        buttonGroup1.clearSelection();
    }

    NhanVien getData() {
        NhanVien nv = new NhanVien();
        String maNv = "";
        maNv = "NV" + (nvSer.getAllNhanVien().size() + 1);
        nv.setMaNV(maNv);
        //nv.setMaNV(txtMa.getText());
        nv.setTenNV(txtTen.getText());
        ChucVu cv = (ChucVu) cbbChucVu.getSelectedItem();
        nv.setChucVu(cv);
        nv.setNgaySinh(txtDate.getText());
        nv.setTrangThai(1);
        if (rdoNam.isSelected()) {
            nv.setGioiTinh(true);
        } else {
            nv.setGioiTinh(false);
        }
        nv.setDiaChi(txtDiaChi.getText());
        nv.setEmail(txtEmail.getText());
        nv.setSdt(txtSDT.getText());
        nv.setPass(String.valueOf(txtPass.getPassword()));
        return nv;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtDate = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        pagination11 = new pagination.Pagination();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhanVien = new swing.table.Table();
        jPanel5 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();

        date.setDateFormat(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.date.dateFormat")); // NOI18N
        date.setTextRefernce(txtDate);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        txtMa.setEditable(false);
        txtMa.setText(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.txtMa.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel3.text")); // NOI18N

        txtTen.setText(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.txtTen.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel4.text")); // NOI18N

        txtPass.setText(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.txtPass.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel6.text")); // NOI18N

        txtDiaChi.setText(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.txtDiaChi.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel7.text")); // NOI18N

        txtSDT.setText(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.txtSDT.text")); // NOI18N
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel8.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel9.text")); // NOI18N

        txtEmail.setText(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.txtEmail.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jLabel10.text")); // NOI18N

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(rdoNam, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.rdoNam.text")); // NOI18N

        buttonGroup1.add(rdoNu);
        org.openide.awt.Mnemonics.setLocalizedText(rdoNu, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.rdoNu.text")); // NOI18N

        btnThem.setBackground(new java.awt.Color(0, 153, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnThem, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.btnThem.text")); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 153, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnSua, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.btnSua.text")); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 153, 204));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnClear, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.btnClear.text")); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 153, 204));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnXoa, org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.btnXoa.text")); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txtMa)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.Alignment.LEADING, 0, 141, Short.MAX_VALUE)
                            .addComponent(txtPass)
                            .addComponent(txtDiaChi))))
                .addGap(101, 101, 101)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(101, 101, 101)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252)
                        .addComponent(pagination11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(37, 37, 37)
                                .addComponent(rdoNu))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pagination11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(rdoNu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdoNam, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Mã NV", "Mật khẩu", "Tên NV", "Chức vụ", "Ngày sinh", "Giới tính", "Địa chỉ", "Điện thoại", "Email", "Trạng thái"
            }
        ));
        tbNhanVien.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbNhanVien);
        if (tbNhanVien.getColumnModel().getColumnCount() > 0) {
            tbNhanVien.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title0")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title1")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title2")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title3")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title4")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title5")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title6")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title7")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(8).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title8")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(9).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title9")); // NOI18N
            tbNhanVien.getColumnModel().getColumn(10).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.tbNhanVien.columnModel.title10")); // NOI18N
        }

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.setText(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.txtSearch.text")); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1547, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jPanel2.AccessibleContext.accessibleName")); // NOI18N
        jPanel5.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(QuanLyNhanVien.class, "QuanLyNhanVien.jPanel5.AccessibleContext.accessibleName")); // NOI18N

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1535, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (validateForm()) {
            String result = new NhanVienImpl().add(getData());
            JOptionPane.showMessageDialog(this, result);
            loadPagination();
            clear();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tbNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin trong bảng");
            return;
        }

        Integer id = (Integer) tbNhanVien.getValueAt(row, 0);
        NhanVien a = getData();
        a.setMaNV((String) tbNhanVien.getValueAt(row, 1));

        if (validateForm()) {
            String result = new NhanVienImpl().update(a, id);
            JOptionPane.showMessageDialog(this, result);
            loadPagination();
            clear();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        int row = tbNhanVien.getSelectedRow();
        listNV = nvSer.pageListNhanVien(paging.getCurrent(), pageSize, txtSearch.getText());
        NhanVien nv = listNV.get(row);
        txtMa.setText(nv.getMaNV());
        txtPass.setText(nv.getPass());
        txtTen.setText(nv.getTenNV());
        cbCV.setSelectedItem(nv.getChucVu());
        txtDate.setText(nv.getNgaySinh());
        txtDiaChi.setText(nv.getDiaChi());
        txtSDT.setText(nv.getSdt());
        txtEmail.setText(nv.getEmail());

        Boolean gioiTinh = nv.getGioiTinh();
        if (gioiTinh == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tbNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin trong bảng");
            return;
        }

        Integer id = (Integer) tbNhanVien.getValueAt(row, 0);

        String result = new NhanVienImpl().updateTrangThai(id);
        JOptionPane.showMessageDialog(this, result);
        loadPagination();
        clear();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        loadPagination();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    void searchByPhone() {
        DefaultTableModel tb = (DefaultTableModel) tbNhanVien.getModel();
        tb.setRowCount(0);

        List<NhanVien> nv = nvSer.getAll();
        for (NhanVien x : nv) {
            if (x.getSdt().toLowerCase().contains(txtSearch.getText().trim().toLowerCase())) {
                tb.addRow(x.toDataRow());
            }
        }
    }

    public boolean validateForm() {
//        String ma = txtMa.getText().trim();
        String ten = txtTen.getText();
        String pass = String.valueOf(txtPass.getPassword());
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String ngaySinh = txtDate.getText();
        String email = txtEmail.getText();

        Pattern sodienthoai = Pattern.compile("^0+[1-9]{9}$");
        Matcher matcherFirst = sodienthoai.matcher(sdt);

        Pattern maiL = Pattern.compile("^(.+)@(.+)$");
        Matcher matcherEmail = maiL.matcher(email);

        if (ten.isBlank() || pass.isBlank() || diaChi.isBlank()
                || sdt.isBlank() || ngaySinh.isBlank() || email.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        }

        if (!matcherFirst.matches()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải 10 số");
            return false;
        }

        if (!matcherEmail.matches()) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");
            return false;
        }

        return true;
    }

//    public boolean checkDuplicateMa() {
//        String ma = this.txtMa.getText().trim();
//        NhanVien nv = nvSer.getNhanVien(ma);
//        if (nv != null) {
//            JOptionPane.showMessageDialog(this, "Mã đã tồn tại mời bạn nhập lại");
//            return false;
//        }
//        return true;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChucVu;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private pagination.Pagination pagination11;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private swing.table.Table tbNhanVien;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
