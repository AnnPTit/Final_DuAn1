package service;

import model.ChiTietSanPham;
import java.util.List;

/**
 *
 * @author fallinluv2003
 */
public interface ICTSPService {

    List<ChiTietSanPham> getAll();

    String add(ChiTietSanPham ctsp);

    String update(ChiTietSanPham ctsp, Integer id);

    String updateTrangThai(Integer id);

    List<ChiTietSanPham> getSumProduct();

    int getSoLuongSpByMaCTSP(String maCTSP);

    public void updateSoLuongCTSP(String maCTSP, int so) ;
}
