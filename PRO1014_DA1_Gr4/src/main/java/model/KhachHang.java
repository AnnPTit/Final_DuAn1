/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MaKH")
    private String maKH;

    @Column(name = "TenKH")
    private String tenKH;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "SDT")
    private String sdt ; 
    
    @Column(name = "Email")
    private String email ; 
    
    @Column(name = "TrangThai")
    private Integer trangThai ; 
    
    @OneToOne(mappedBy = "khachHang")
    private GioHang gioHang ; 
    
    @OneToOne(mappedBy = "khachHang")
    private List<HoaDonBan> listhoaDonBan;

    public List<HoaDonBan> getListhoaDonBan() {
        return listhoaDonBan;
    }

    public void setListhoaDonBan(List<HoaDonBan> listhoaDonBan) {
        this.listhoaDonBan = listhoaDonBan;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email + ", trangThai=" + trangThai + ", gioHang=" + gioHang + '}';
    }
    
    
    
    

}
