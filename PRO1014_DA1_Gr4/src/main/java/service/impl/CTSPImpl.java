package service.impl;

import model.ChiTietSanPham;
import repository.CTSPRepository;
import java.util.List;
import service.ICTSPService;

/**
 *
 * @author fallinluv2003
 */
public class CTSPImpl implements ICTSPService {

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

    @Override
    public int getSoLuongSpByMaCTSP(String maCTSP) {
        return ctspRepo.getSoLuongSpByMaCTSP(maCTSP);
    }

    @Override
    public void updateSoLuongCTSP(String maCTSP, int so) {
        if (ctspRepo.updateSoLuongCTSP(maCTSP, so)) {
            System.out.println("Cap nhat so luong ton thanh cong");
        }else{
            System.out.println("Cap nhat that bai");
        }
    }

}
