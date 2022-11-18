/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import javax.swing.JOptionPane;
import model.KhachHang;
import repository.KhachHangRepository;
import service.KhachHangService;

/**
 *
 * @author ADMIN
 */
public class KhachHangImpl implements KhachHangService {

    private KhachHangRepository khRepo = new KhachHangRepository();

    public KhachHangImpl() {
    }

    @Override
    public List<KhachHang> getAll() {
        return khRepo.getAll();
    }

    @Override
    public String add(KhachHang kh) {
        if(khRepo.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhachHang kh, Integer id) {
        if(khRepo.update(kh, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String updateTrangThai(Integer id) {
        if(khRepo.updateTrangThai(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

}