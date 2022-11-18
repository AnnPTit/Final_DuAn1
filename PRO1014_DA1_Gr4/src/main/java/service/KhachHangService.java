/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author ADMIN
 */
public interface KhachHangService {
    public List<KhachHang> getAll();
    String add(KhachHang kh);
    String update(KhachHang kh, Integer id);
    String updateTrangThai(Integer id);
}
