/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import model.Mau;
import repository.MauRepository;
import service.MauSacService;
import java.util.List;

/**
 *
 * @author HP
 */
public class MauSacImpl implements MauSacService{
    
    private MauRepository msRepo = new MauRepository();

    @Override
    public List<Mau> getAll() {
        return msRepo.getAll();
    }

    @Override
    public String add(Mau ms) {
        if(msRepo.add(ms)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Mau ms, Integer id) {
        if(msRepo.update(ms, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(Mau ms, Integer id) {
        if(msRepo.delete(ms, id)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
}
