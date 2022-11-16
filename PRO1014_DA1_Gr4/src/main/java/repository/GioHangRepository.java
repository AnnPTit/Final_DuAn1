/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.GioHang;
import model.KhachHang;
import org.hibernate.SQLQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Laptop
 */
public class GioHangRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

    public List<GioHang> getAll() {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query query = (Query) em.createQuery("From GioHang");
        query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        @SuppressWarnings("unchecked")
        List<GioHang> lst = query.getResultList();
        return lst;
    }

    public Boolean add(GioHang gioHang) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(gioHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Loi them gio hang");
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(GioHang gioHang) {
        Transaction transision = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transision = session.beginTransaction();
            Query query = session.createQuery("UPDATE GioHang SET NgayThanhToan =:ngaythanhtoan , TrangThai = :trangthai where IdKH = :idkh");
            query.setParameter("ngaythanhtoan", gioHang.getNgayThanhToan());
            query.setParameter("trangthai", gioHang.getTrangThai());
            query.setParameter("idkh", gioHang.getKhachHang().getId());
            check = query.executeUpdate();
            transision.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public GioHang getGioHangBKH(int idKH) {
        try {
            String sql = "SELECT * FROM GioHang WHERE IdKH = :id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(GioHang.class);
            query.setParameter("id", idKH);
            GioHang results = (GioHang) query.getSingleResult();
            // NhanVien results = (NhanVien) query.list();

            return results;

        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        GioHang list = new GioHangRepository().getGioHangBKH(20);
        System.out.println(list);
        list.setTrangThai(0);
        Date ngayThanhToan = new Date();
        list.setNgayThanhToan(ngayThanhToan);
      

        new GioHangRepository().update(list);

    }
}
