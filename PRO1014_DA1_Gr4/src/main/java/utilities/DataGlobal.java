/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import model.KhuyenMai;

/**
 *
 * @author ADMIN
 */
public class DataGlobal {

    public static double totalHoaDon;
    public static KhuyenMai khuyenMai;

    public static void clearKM() {
        khuyenMai = null;
    }

    public DataGlobal() {
        totalHoaDon = 0;
    }

    public static double getTotalHoaDon() {
        return totalHoaDon;
    }

    public static void setTotalHoaDon(double totalHoaDon) {
        DataGlobal.totalHoaDon = totalHoaDon;
    }

    public static KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public static void setKhuyenMai(KhuyenMai khuyenMai) {
        DataGlobal.khuyenMai = khuyenMai;
    }

   

}
