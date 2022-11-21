/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import model.SanPham;
import repository.SanPhamRepository;
import service.SanPhamService;
import java.util.List;


/**
 *
 * @author HP
 */
public class SanPhamImp implements SanPhamService{
    
    private SanPhamRepository spRepo = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return spRepo.getAll();
    }

    @Override
    public String add(SanPham sp) {
        if(spRepo.add(sp)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(SanPham sp, Integer id) {
        if(spRepo.update(sp, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String updateTrangThai(Integer id) {
        if(spRepo.updateTrangThai(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
}
