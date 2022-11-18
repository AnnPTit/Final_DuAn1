/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.KhachHang;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Laptop
 */
public class KhachHangRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<KhachHang> getAll() {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        //  Query q = (Query) em.createQuery("From SanPham");
        Query query = (Query) em.createQuery("From KhachHang where TrangThai =: trangthai order by ID desc");
        query.setParameter("trangthai", 1);
        @SuppressWarnings("unchecked")
        ArrayList<KhachHang> list = new ArrayList<>();
        list = (ArrayList<KhachHang>) query.getResultList();
        return list;
    }

    public Boolean add(KhachHang khachHang) {
        Transaction transision = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transision = session.beginTransaction();
            check = (Integer) session.save(khachHang);
            transision.commit();
            return check > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//    public Integer delete(KhachHang khachHang) {
//        Transaction transision = null;
//        Integer check = 0;
//        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
//            transision = session.beginTransaction();
//            Query query = session.createQuery("DELETE FROM KhachHang WHERE MaKH = :code");
//            query.setParameter("code", khachHang.getCode());
//            check = query.executeUpdate();
//            transision.commit();
//            return check;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return 0;
//    }
    public KhachHang update(KhachHang khachHang) {
        Transaction transision = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transision = session.beginTransaction();
            Query query = session.createQuery("""
                                              UPDATE KhachHang SET TenKH = :name, GioiTinh = :sex,
                                              DiaChi = :address, SDT = :phone, Email = :email,
                                              TrangThai = :status WHERE MaKH = :code """);
            query.setParameter("name", khachHang.getTenKH());
            query.setParameter("sex", khachHang.getGioiTinh());
            query.setParameter("address", khachHang.getDiaChi());
            query.setParameter("phone", khachHang.getSdt());
            query.setParameter("email", khachHang.getEmail());
            query.setParameter("status", khachHang.getTrangThai());
            query.setParameter("code", khachHang.getMaKH());
            check = query.executeUpdate();
            transision.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return khachHang;
    }

    public static void main(String[] args) {
        ArrayList<KhachHang> lst = new KhachHangRepository().getAll();
        System.out.println(lst);
    }
}
