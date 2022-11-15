/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdHDB")
    private HoaDonBan hoaDonBan;

    @ManyToOne
    @JoinColumn(name = "IdSpct")
    private ChiTietSanPham chiTietSanPham;
    
    @Column(name = "SoLuong")
    private Integer soLuong ; 
    
     @Column(name = "TrangThai")
    private Integer trangThai ; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HoaDonBan getHoaDonBan() {
        return hoaDonBan;
    }

    public void setHoaDonBan(HoaDonBan hoaDonBan) {
        this.hoaDonBan = hoaDonBan;
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

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "id=" + id + ", hoaDonBan=" + hoaDonBan + ", chiTietSanPham=" + chiTietSanPham + ", soLuong=" + soLuong + ", trangThai=" + trangThai + '}';
    }

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer id, HoaDonBan hoaDonBan, ChiTietSanPham chiTietSanPham, Integer soLuong, Integer trangThai) {
        this.id = id;
        this.hoaDonBan = hoaDonBan;
        this.chiTietSanPham = chiTietSanPham;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }
     
     
    
    

}
