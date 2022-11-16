/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Laptop
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MaKH")
    private String code;

    @Column(name = "TenKH")
    private String name;

    @Column(name = "GioiTinh")
    private Boolean sex;

    @Column(name = "DiaChi")
    private String address;

    @Column(name = "SDT")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "TrangThai")
    private Integer status;

    @OneToOne(mappedBy = "khachHang", fetch = FetchType.EAGER)
    private GioHang gioHang ;



    public KhachHang(Integer id, String code, String name, Boolean sex, String address, String phone, String email, Integer status, GioHang gioHang) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.gioHang = gioHang;
    }

    public KhachHang() {
    }
    




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

  

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", code=" + code + ", name=" + name
                + ", sex=" + sex + ", address=" + address + ", phone=" + phone
                + ", email=" + email + ", status=" + status + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{id, code, name, sex == true ? "Male" : "Female",
            address, phone, email, status == 1 ? "Active" : "InActive"};
    }
}
