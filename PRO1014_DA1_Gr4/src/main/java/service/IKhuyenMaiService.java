/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai;

/**
 *
 * @author T450s
 */
public interface IKhuyenMaiService {

    ArrayList<KhuyenMai> getList();

    void add(KhuyenMai km);

    void remove(int id);

    void update(KhuyenMai km, int id);

    List<KhuyenMai> getKhuyenMaiMap(double minHoDon);

    KhuyenMai getKhuyenMaiByMa(String maKM);

    ArrayList<KhuyenMai> getAllByTrangT(int tt);
}
