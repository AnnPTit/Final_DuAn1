/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "GioHang")
public class GioHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    
    @OneToMany(mappedBy = "gioHang",fetch = FetchType.EAGER)
    private Set<GioHangChiTiet> listGhct ;
    
    @Column(name = "MaGH")
    private String maGH;

    @Column(name = "NgayTao")
    private String ngayTao;

    @Column(name = "NgayThanhToan")
    private String ngayThanhToan;
    @Column(name = "TrangThai")
    private Integer trangThai;

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

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Set<GioHangChiTiet> getListGhct() {
        return listGhct;
    }

    public void setListGhct(Set<GioHangChiTiet> listGhct) {
        this.listGhct = listGhct;
    }

 
    

    @Override
    public String toString() {
        return "GioHang{" + "id=" + id + ", khachHang=" + khachHang + ", maGH=" + maGH + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", trangThai=" + trangThai + '}';
    }

    public GioHang() {
    }

    public GioHang(Integer id, KhachHang khachHang, String maGH, String ngayTao, String ngayThanhToan, Integer trangThai) {
        this.id = id;
        this.khachHang = khachHang;
        this.maGH = maGH;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }
    
    

}
