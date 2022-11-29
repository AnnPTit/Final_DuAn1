package service;

import customModel.HoaDonDoanhThu;
import customModel.HoaDonThanhToan;
import customModel.ThongKeThang;
import java.math.BigDecimal;
import java.util.Date;
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

    List<HoaDonDoanhThu> getDoanhSo(boolean  isDESC);

    List<HoaDonThanhToan> getHoaDonThanhToan();
    
    BigDecimal doanhThuTheoNam();

    BigDecimal doanhThuTheoThang();
    
    BigDecimal doanhThuHomNay();
    
    List<HoaDonThanhToan> filterDate(String start, String end);
    
    List<ThongKeThang> getThongKeThang();
}

// IHDCTService
