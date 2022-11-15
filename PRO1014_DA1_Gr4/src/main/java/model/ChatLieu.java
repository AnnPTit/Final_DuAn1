/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jdk.jfr.DataAmount;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "ChatLieu")
public class ChatLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MaCL")
    private String maCL;

    @Column(name = "TenCL")
    private String tenCL;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "NgayTao")
    private Date ngayTao;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @OneToMany(mappedBy = "chatLieu", fetch = FetchType.EAGER)
    private List<ChiTietSanPham> list = new ArrayList<>();

    public ChatLieu() {
    }

    public ChatLieu(Integer id, String maCL, String tenCL, Date ngayTao, Date ngaySua, Integer trangThai) {
        this.id = id;
        this.maCL = maCL;
        this.tenCL = tenCL;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaCL() {
        return maCL;
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public List<ChiTietSanPham> getList() {
        return list;
    }

    public void setList(List<ChiTietSanPham> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return tenCL;
    }

    public Object[] toDataRow() {
        return new Object[]{id, maCL, tenCL, ngayTao, ngaySua, trangThai == 1 ? "Đang kinh doanh" : "Nghỉ kinh doanh"};
    }

}
