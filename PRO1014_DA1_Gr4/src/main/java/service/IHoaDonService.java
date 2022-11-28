/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import customModel.SoLanMuaHang;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonBan;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KhuyenMai;

/**
 *
 * @author T450s
 */
public interface IHoaDonService {

    ArrayList<HoaDonBan> getListHoaDonBan();

    List<HoaDonBan> getListByTrangThai(int trangThai);

    List<KhachHang> getListKhach();

    // ArrayList<NhanVien> getListNv();
    ArrayList<KhuyenMai> getListKhuyenMai();

    String insert(HoaDonBan hd);

    void delete(int id);

    void update(HoaDonBan hd, int id);

    void updateKH(HoaDonBan hd);

    void addHoaDonChiTiet(HoaDonChiTiet hdct);

    void updateTrangThaiHoaDon(int id, int trangThai);

    void updateTrangThaiHoaDonChiTiet(int id, int trangThai);

   // List<HoaDonChiTiet> getHoaDonChiTietByIdHD(int idHD);

    void deleteHoaDonCT(int idCTSP);

    public void updateSoLuongHDCT(int idCTSP, int soLuong) ;
    
    Long getCountHoaDon();
    
    public List<SoLanMuaHang> getSoLanMuaHang();

    }
