package service;

import model.ChiTietSanPham;
import java.util.List;

/**
 *
 * @author fallinluv2003
 */
public interface CTSPService {
    public List<ChiTietSanPham> getAll();
    String add(ChiTietSanPham ctsp);
    String update(ChiTietSanPham ctsp, Integer id);
    String delete(ChiTietSanPham ctsp, Integer id);
}