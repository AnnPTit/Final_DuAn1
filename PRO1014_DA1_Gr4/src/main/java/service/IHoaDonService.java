/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.HoaDonBan;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KhuyenMai;
import model.NhanVien;

/**
 *
 * @author T450s
 */
public interface IHoaDonService {

    ArrayList<HoaDonBan> getListHoaDonBan();

    ArrayList<KhachHang> getListKhach();

    // ArrayList<NhanVien> getListNv();
    ArrayList<KhuyenMai> getListKhuyenMai();

    String insert(HoaDonBan hd);

    void delete(int id);

    void update(HoaDonBan hd, int id);

    void updateKH(HoaDonBan hd);

    void addHoaDonChiTiet(HoaDonChiTiet hdct);

    void updateTrangThaiHoaDon(int id, int trangThai);

}
