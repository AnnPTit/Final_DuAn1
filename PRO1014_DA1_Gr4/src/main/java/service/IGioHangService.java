/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.GioHang;

/**
 *
 * @author ADMIN
 */
public interface IGioHangService {
     List<GioHang> getAll();
     GioHang getGioHangByKH(int idKH);
     String updateGioHang(GioHang gioHang);
}
