/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.GioHang;
import model.GioHangChiTiet;
import repository.GioHangRepository;
import service.IGioHangService;

/**
 *
 * @author ADMIN
 */
public class GioHangImpl implements IGioHangService {

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

    @Override
    public void addGHCT(GioHangChiTiet ghct) {
        if (gioHangRepository.addGioHangCt(ghct) == true) {
            System.out.println("Thành công");
        } else {
            System.out.println("Thất bại");
        }
    }

    @Override
    public List<GioHangChiTiet> getGioHangChiTiet(int idGH) {
        return gioHangRepository.getGioHangChiTietByGiHang(idGH);
    }

    @Override
    public Boolean updateTrangThaiGHCT(int idGH, int trangThai) {
        if (gioHangRepository.updateTrangThaiGhCT(idGH, trangThai) == true) {
            System.out.println("Update trạng thái giỏ hàng thành công :" + idGH);
            return  true;
        } else {
            System.out.println("Update giỏ hàng thất bại : " + idGH);
            return  false;
        }
    }

    @Override
    public String deleteGhct(GioHangChiTiet ghct) {
        if (gioHangRepository.deleteGioHangChiTiet(ghct) == true) {
            return "Xóa Thành công !";
        } else {
            return "Xóa thất bại !";
        }
    }

    @Override
    public void updateSoLuongGioHang(int id, int soLuong) {
        if (gioHangRepository.updateSoLuongGhCt(id, soLuong) == true) {
            System.out.println("Cập nhật số lượng giỏ hàng thành công" + soLuong);
        } else {
            System.out.println("Cập nhật thất bại " + soLuong);
        }
    }
}
