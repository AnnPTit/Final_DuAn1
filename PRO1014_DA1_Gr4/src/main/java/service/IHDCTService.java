package service;

import customModel.HoaDonDoanhThu;
import customModel.HoaDonThanhToan;
import java.math.BigDecimal;
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
    
    List<HoaDonDoanhThu> getSoLuongDown();
    
    List<HoaDonDoanhThu> getSoLuongUp();
    
    List<HoaDonThanhToan> getHoaDonThanhToan();
    
    BigDecimal doanhThuTheoNam();

    BigDecimal doanhThuTheoThang();
    
    BigDecimal doanhThuHomNay();
}

// IHDCTService
