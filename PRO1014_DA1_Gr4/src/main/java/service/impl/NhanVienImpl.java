/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import model.NhanVien;
import repository.NhanVienRepository;
import service.INhanVienService;

/**
 *
 * @author ADMIN
 */
public class NhanVienImpl implements INhanVienService {

    private NhanVienRepository nhanVienRepository;

    public NhanVienImpl() {
        nhanVienRepository = new NhanVienRepository();
    }

    @Override
    public NhanVien getNhanVien(String maNV) {
        return nhanVienRepository.getNhanVien(maNV);
    }

}
