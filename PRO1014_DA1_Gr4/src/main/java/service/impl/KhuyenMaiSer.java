/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai;
import repository.KhuyenMaiRepo;
import service.IKhuyenMaiService;

/**
 *
 * @author T450s
 */
public class KhuyenMaiSer implements IKhuyenMaiService {

    private KhuyenMaiRepo kmr = new KhuyenMaiRepo();

    @Override
    public ArrayList<KhuyenMai> getList() {
        return kmr.getAll();
    }

    @Override
    public void add(KhuyenMai km) {
        kmr.insert(km);
    }

    @Override
    public void remove(int id) {
        kmr.dele(id);
    }

    @Override
    public void update(KhuyenMai km, int id) {
        kmr.update(km, id);
    }

    @Override
    public List<KhuyenMai> getKhuyenMaiMap(double minHoDon) {
        return kmr.getAllKhuyenMaiMap(minHoDon);
    }

    @Override
    public KhuyenMai getKhuyenMaiByMa(String maKM) {
        return kmr.getKhuyenMaiByMa(maKM);
    }

}
