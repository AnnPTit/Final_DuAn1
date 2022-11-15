/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdGH", nullable = false)
    private GioHang gioHang;
    
    @ManyToOne
    @JoinColumn(name = "IdSpct", nullable = false)
    private ChiTietSanPham chiTietSanPham;
    
    @Column(name = "SoLuong")
    private Integer soLuong ; 
    
    @Column(name = "DonGia")
    private BigDecimal donGia ; 
    
    @Column(name = "TrangThai")
    private Integer trangThai ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(Integer id, GioHang gioHang, ChiTietSanPham chiTietSanPham, Integer soLuong, BigDecimal donGia, Integer trangThai) {
        this.id = id;
        this.gioHang = gioHang;
        this.chiTietSanPham = chiTietSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "GioHangChiTiet{" + "id=" + id + ", gioHang=" + gioHang + ", chiTietSanPham=" + chiTietSanPham + ", soLuong=" + soLuong + ", donGia=" + donGia + ", trangThai=" + trangThai + '}';
    }
    
    
}
