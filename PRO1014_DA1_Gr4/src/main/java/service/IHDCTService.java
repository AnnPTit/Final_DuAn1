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

    List<HoaDonDoanhThu> getDoanhSo();

}

// IHDCTService
