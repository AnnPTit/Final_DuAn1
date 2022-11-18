/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author ADMIN
 */
public interface IKhachHangService {

    ArrayList<KhachHang> getAll();

    String add(KhachHang khachHang);

    String delete(KhachHang khachHang);

    KhachHang update(KhachHang khachHang);
}
