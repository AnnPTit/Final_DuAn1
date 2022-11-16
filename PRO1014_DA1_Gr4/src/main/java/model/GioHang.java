package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Laptop
 */
@Entity
@Table(name = "GioHang")
public class GioHang implements Serializable {

  //  private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    
    @OneToMany(mappedBy = "gioHang")
    private List<GioHangChiTiet> listGhct ;

    @Column(name = "MaGH")
    private String ma;

    @Column(name = "NgayTao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThanhToan;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public GioHang() {
    }

    public GioHang(Integer id, KhachHang khachHang, String ma, Date ngayTao, Date ngayThanhToan, Integer trangThai) {
        this.id = id;
        this.khachHang = khachHang;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public List<GioHangChiTiet> getListGhct() {
        return listGhct;
    }

    public void setListGhct(List<GioHangChiTiet> listGhct) {
        this.listGhct = listGhct;
    }
    

    @Override
    public String toString() {
        return "GioHang{" + "id=" + id + ", khachHang=" + khachHang.getName() + ", listGhct=" + listGhct + ", ma=" + ma + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", trangThai=" + trangThai + '}';
    }
    

    public Object[] toDataRow() {
        return new Object[]{
            id, khachHang.getId(), ma, ngayTao, ngayThanhToan, trangThai
        };
    }
}
