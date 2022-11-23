package service.impl;

import model.ChiTietSanPham;
import repository.CTSPRepository;
import service.CTSPService;
import java.util.List;

/**
 *
 * @author fallinluv2003
 */
public class CTSPImpl implements CTSPService {

    private CTSPRepository ctspRepo = new CTSPRepository();

    @Override
    public List<ChiTietSanPham> getAll() {
        return ctspRepo.getAll();
    }

    @Override
    public String add(ChiTietSanPham ctsp) {
        if (ctspRepo.add(ctsp)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChiTietSanPham ctsp, Integer id) {
        if (ctspRepo.update(ctsp, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String updateTrangThai(Integer id) {
        if (ctspRepo.updateTrangThai(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<ChiTietSanPham> getSumProduct() {
        return ctspRepo.getSumProduct();
    }
    
}
