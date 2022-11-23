/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HoaDonBan;
import model.HoaDonChiTiet;
import model.KhachHang;
import repository.KhachHangRepository;
import model.KhuyenMai;
import model.NhanVien;
import repository.HoaDonBanRepo;
import repository.KhuyenMaiRepo;

import service.IHoaDonService;

/**
 *
 * @author T450s
 */
public class HoaDonBanSer implements IHoaDonService {

    HoaDonBanRepo hdr = new HoaDonBanRepo();
    KhachHangRepository kh = new KhachHangRepository();
    KhuyenMaiRepo kmr = new KhuyenMaiRepo();

    @Override
    public ArrayList<HoaDonBan> getListHoaDonBan() {
        return hdr.getAll();
    }

    @Override
    public List<KhachHang> getListKhach() {
        return kh.getAll();
    }

//    @Override
//    public ArrayList<NhanVien> getListNv() {
//        return nvr.getAll();
//    }
    @Override
    public ArrayList<KhuyenMai> getListKhuyenMai() {
        return kmr.getAll();
    }

    @Override
    public String insert(HoaDonBan hd) {
        if (hdr.add(hd) == true) {
            return "Thêm thành công Mã :" + hd.getMaHDB();
        } else {
            return "Thất bại";
        }
    }

    @Override
    public void delete(int id) {
        this.hdr.dele(id);
    }

    @Override
    public void update(HoaDonBan hd, int id) {
        this.hdr.sua(hd, id);
    }
//=============================================================================================================================================

    @Override
    public void addHoaDonChiTiet(HoaDonChiTiet hdct) {
        if (hdr.addHoaDonChiTiet(hdct) == true) {
            System.out.println("Thêm hóa đơn chi tiết thành công");
        } else {
            System.out.println("Thêm Thất bại");
        }
    }

    @Override
    public void updateTrangThaiHoaDon(int id, int trangThai) {
        if (hdr.updateTrangThaiHoaDon(id, trangThai) == true) {
            System.out.println("Cập nhật trạng thái hóa đơn thành công : " + id);
        } else {
            System.out.println("Cập nhật Thất bại" + id);
        }
    }

    @Override
    public void updateKH(HoaDonBan hd) {
        if (hdr.suaKH(hd) == true) {
            System.out.println("Cập nhật trạng thái hóa đơn thành công : ");
        } else {
            System.out.println("Cập nhật Thất bại");
        }
    }

    @Override
    public void updateTrangThaiHoaDonChiTiet(int id, int trangThai) {
        if (hdr.updateTrangThaiHoaDonChiTiet(id, trangThai) == true) {
            System.out.println("Cập nhật trạng thái hóa đơn chi tiet thành công : " + id);
        } else {
            System.out.println("Cập nhật Thất bại" + id);
        }
    }

    @Override
    public List<HoaDonChiTiet> getHoaDonChiTietByIdHD(int idHD) {
        return hdr.getHoaDonChiTietByIDHd(idHD);
    }

    @Override
    public List<HoaDonBan> getListByTrangThai(int trangThai) {
        return hdr.getAllByTrangThai(trangThai);
    }

    @Override
    public void deleteHoaDonCT(int idCTSP) {
        if (hdr.deleteHoaDonChitiet(idCTSP) == true) {
            System.out.println("Xoa hoa don chi tiet thanh cong ");
        } else {
            System.out.println("Thất bại");
        }
    }

    @Override
    public void updateSoLuongHDCT(int idCTSP, int soLuong) {
        if (hdr.updateSoLuongHDCT(idCTSP,soLuong) == true) {
            System.out.println("Cap nhat so luong  hoa don chi tiet thanh cong ");
        } else {
            System.out.println("Thất bại");
        }
    }
}
