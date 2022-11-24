package service.impl;

import java.util.List;
import model.HoaDonChiTiet;
import repository.HDChiTietRepository;
import service.IHDCTService;

/**
 *
 * @author fallinluv2003
 */
public class HDCTImpl implements IHDCTService {

    private HDChiTietRepository hdctRepo = new HDChiTietRepository();

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hdctRepo.getAll();
    }

    @Override
    public List<HoaDonChiTiet> getDoanhThu() {
        return hdctRepo.getDoanhThu();
    }

    @Override
    public List<HoaDonChiTiet> getById(int id) {
        return hdctRepo.getById(id);
    }

    // HDCTImpl
}
