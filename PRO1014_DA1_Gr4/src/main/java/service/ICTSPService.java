package service;

import model.ChiTietSanPham;
import java.util.List;
import model.ChatLieu;
import model.DanhMuc;
import model.Mau;
import model.NSX;

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

    public void updateSoLuongCTSP(String maCTSP, int so);

    public List<ChiTietSanPham> getChiTietSanPhamByComBoBox(DanhMuc isdanhMuc, ChatLieu isChatLieu, Mau isMau, NSX isNsx);

    public ChiTietSanPham getAllByID(int id);
}
