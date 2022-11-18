/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.KhachHang;
import repository.KhachHangRepository;
import service.IKhachHangService;

/**
 *
 * @author ADMIN
 */
public class KhachHangImpl implements IKhachHangService{
     private KhachHangRepository khachHangRepository;

    public KhachHangImpl() {
        khachHangRepository = new KhachHangRepository();
    }

    @Override
    public ArrayList<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public String add(KhachHang khachHang) {
        if (khachHangRepository.add(khachHang) == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(KhachHang khachHang) {
      return  "cc";
    }

    @Override
    public KhachHang update(KhachHang khachHang) {
        return khachHangRepository.update(khachHang);
    }
}
