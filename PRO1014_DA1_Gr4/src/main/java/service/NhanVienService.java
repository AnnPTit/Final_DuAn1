/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.NhanVien;

/**
 *
 * @author ADMIN
 */
public interface NhanVienService {
    public List<NhanVien> getAll();
    NhanVien getNhanVien(String maNV );
    String add(NhanVien nv);
    String update(NhanVien nv, Integer id);
    String updateTrangThai(Integer id);
}
