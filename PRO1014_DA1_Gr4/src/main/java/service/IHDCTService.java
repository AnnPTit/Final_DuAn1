package service;

import customModel.HoaDonDoanhThu;
import java.util.List;
import model.HoaDonChiTiet;

/**
 *
 * @author fallinluv2003
 */
public interface IHDCTService {

    public List<HoaDonChiTiet> getAll();

    public List<HoaDonChiTiet> getDoanhThu();

    public List<HoaDonChiTiet> getById(int id);
<<<<<<< HEAD
    
    public List<HoaDonChiTiet> getDoanhSo();
    
=======

    List<HoaDonDoanhThu> getDoanhSo();

>>>>>>> 9e5540919f0d5f85cf09e56774c477468378712d
}

// IHDCTService
