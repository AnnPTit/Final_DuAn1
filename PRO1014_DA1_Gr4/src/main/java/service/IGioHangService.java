/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.GioHang;
import model.GioHangChiTiet;

/**
 *
 * @author ADMIN
 */
public interface IGioHangService {

    List<GioHang> getAll();

    GioHang getGioHangByKH(int idKH);

    String updateGioHang(GioHang gioHang);

    void addGHCT(GioHangChiTiet ghct);

    List<GioHangChiTiet> getGioHangChiTiet(int idGH);

    Boolean updateTrangThaiGHCT(int idGH, int trangThai);

    String deleteGhct(GioHangChiTiet ghct);

    void updateSoLuongGioHang(int id, int soLuong);
}
