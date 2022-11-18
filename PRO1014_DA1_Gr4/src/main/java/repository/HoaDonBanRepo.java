/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import model.ChiTietSanPham;
import model.HoaDonBan;

import model.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author T450s
 */
public class HoaDonBanRepo {

    public ArrayList<HoaDonBan> getAll() {
        Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession();
        Query q = se.createQuery("From HoaDonBan c where c.trangThai =: trangthai order by c.id desc");
        q.setParameter("trangthai", 1);
        ArrayList<HoaDonBan> ds = (ArrayList<HoaDonBan>) q.getResultList();
        return ds;
    }

    public Boolean add(HoaDonBan hdb) {
        try ( Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = se.beginTransaction();
            se.save(hdb);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void sua(HoaDonBan hdb, Integer id) {
        try ( Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = se.beginTransaction();
            String hql = "Update HoaDonBan hd set hd.nhanVien.id= :idNv,hd.khachHang.id= :idKh,hd.maHDB =:mahdb, hd.khuyenMai.id =:idkm ,"
                    + "hd.nguoiNhan =:nguoiNhan,hd.ngayThanhToan= :ngayThanhToan,hd.sdt =:sdt, hd.diaChi =:diaChi, hd.trangThai =:trangThai"
                    + " where hd.id = :id";
            Query q = se.createQuery(hql);
            q.setParameter("id", id);
            q.setParameter("idKh", hdb.getKhachHang().getId());
            q.setParameter("idNv", hdb.getNhanVien().getId());
            q.setParameter("ngayThanhToan", hdb.getNgayThanhToan(), TemporalType.DATE);
            q.setParameter("mahdb", hdb.getMaHDB());
            q.setParameter("idkm", hdb.getKhuyenMai().getId());
            q.setParameter("nguoiNhan", hdb.getNguoiNhan());
            q.setParameter("sdt", hdb.getSdt());
            q.setParameter("diaChi", hdb.getDiaChi());
            q.setParameter("trangThai", hdb.getTrangThai());
            q.executeUpdate();
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean suaKH(HoaDonBan hdb) {
        try ( Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = se.beginTransaction();
            String hql = "Update HoaDonBan hd set hd.khachHang.id= :idKh"
                    + " where hd.id = :id";
            Query q = se.createQuery(hql);
            q.setParameter("id", hdb.getId());
            q.setParameter("idKh", hdb.getKhachHang().getId());
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void dele(int id) {
        try ( Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = se.beginTransaction();
            String hql = "Update HoaDonBan hd set hd.trangThai =:trangThai"
                    + " where hd.id = :id";
            Query q = se.createQuery(hql);
            q.setParameter("id", id);
            q.setParameter("trangThai", 1);
            q.executeUpdate();
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ========================================================================================================================================

    public Boolean addHoaDonChiTiet(HoaDonChiTiet hdct) {
        try ( Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = se.beginTransaction();
            se.save(hdct);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateTrangThaiHoaDon(int id, int trangThai) {
        Transaction transision = null;
        Integer check = 0;
        try ( Session session = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            transision = session.beginTransaction();
            Query query = session.createQuery("UPDATE HoaDonBan SET  TrangThai = :trangthai where Id = :id");
            query.setParameter("trangthai", trangThai);
            query.setParameter("id", id);
            check = query.executeUpdate();
            transision.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        HoaDonChiTiet h = new HoaDonChiTiet();
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setId(3);
        HoaDonBan hdb = new HoaDonBan();
        hdb.setId(1);
        h.setChiTietSanPham(chiTietSanPham);
        h.setHoaDonBan(hdb);

        new HoaDonBanRepo().addHoaDonChiTiet(h);
    }
}
