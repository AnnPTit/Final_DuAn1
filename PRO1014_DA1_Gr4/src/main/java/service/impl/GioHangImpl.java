/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.GioHang;
import repository.GioHangRepository;
import service.IGioHangService;

/**
 *
 * @author ADMIN
 */
public class GioHangImpl implements IGioHangService{
     private final GioHangRepository gioHangRepository;

    public GioHangImpl() {
        this.gioHangRepository = new GioHangRepository();
    }

    

    @Override
    public List<GioHang> getAll() {
        return gioHangRepository.getAll();
    }

    @Override
    public GioHang getGioHangByKH(int idKH) {
        return gioHangRepository.getGioHangBKH(idKH);
    }

    @Override
    public String updateGioHang(GioHang gioHang) {
        if (gioHangRepository.update(gioHang) == true) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
}
