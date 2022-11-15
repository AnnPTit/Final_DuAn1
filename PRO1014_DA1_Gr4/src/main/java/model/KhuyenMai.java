/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MaKM")
    private String maKM;

    @Column(name = "TenKM")
    private String tenKM;

    @Column(name = "NgayTao")
    private String ngayTao;

    @Column(name = "PhanTramGiam")
    private Integer phanTramGiam;

    @Column(name = "MinHoaDon")
    private BigDecimal minHoaDon;

    @Column(name = "NgayHetHan")
    private String ngayHetHan;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;
    
    @OneToMany(mappedBy = "khuyenMai",fetch = FetchType.EAGER)
    private List<HoaDonBan> listhHoaDonBan; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(Integer phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public BigDecimal getMinHoaDon() {
        return minHoaDon;
    }

    public void setMinHoaDon(BigDecimal minHoaDon) {
        this.minHoaDon = minHoaDon;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public List<HoaDonBan> getListhHoaDonBan() {
        return listhHoaDonBan;
    }

    public void setListhHoaDonBan(List<HoaDonBan> listhHoaDonBan) {
        this.listhHoaDonBan = listhHoaDonBan;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "id=" + id + ", maKM=" + maKM + ", tenKM=" + tenKM + ", ngayTao=" + ngayTao + ", phanTramGiam=" + phanTramGiam + ", minHoaDon=" + minHoaDon + ", ngayHetHan=" + ngayHetHan + ", ghiChu=" + ghiChu + ", trangThai=" + trangThai + ", listhHoaDonBan=" + listhHoaDonBan + '}';
    }

    public KhuyenMai() {
    }

    public KhuyenMai(Integer id, String maKM, String tenKM, String ngayTao, Integer phanTramGiam, BigDecimal minHoaDon, String ngayHetHan, String ghiChu, Integer trangThai, List<HoaDonBan> listhHoaDonBan) {
        this.id = id;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayTao = ngayTao;
        this.phanTramGiam = phanTramGiam;
        this.minHoaDon = minHoaDon;
        this.ngayHetHan = ngayHetHan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.listhHoaDonBan = listhHoaDonBan;
    }
        
    
}
