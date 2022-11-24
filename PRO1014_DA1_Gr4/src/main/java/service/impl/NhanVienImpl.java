/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.NhanVien;
import repository.NhanVienRepository;
import service.INhanVienService;

/**
 *
 * @author ADMIN
 */
public class NhanVienImpl implements INhanVienService {

    private NhanVienRepository nvRepo = new NhanVienRepository();

    public NhanVienImpl() {
    }
    
    
    @Override
    public List<NhanVien> getAll() {
        return nvRepo.getAll();
    }

    @Override
    public NhanVien getNhanVien(String maNV) {
        return nvRepo.getNhanVien(maNV);
    }

    @Override
    public String add(NhanVien nv) {
        if(nvRepo.add(nv)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(NhanVien nv, Integer id) {
        if(nvRepo.update(nv, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String updateTrangThai(Integer id) {
        if(nvRepo.updateTrangThai(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

}
