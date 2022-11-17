/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.KhachHang;
import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
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

    List<KhachHang> list = new ArrayList<>();

    public List<KhachHang> getAll() {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("From KhachHang");
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        List<KhachHang> list = q.getResultList();
        return list;
    }

    public boolean add(KhachHang kh) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.saveOrUpdate(kh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KhachHang kh, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE KhachHang kh SET kh.ma=:ma,kh.ten=:ten,"
                    + "kh.gioiTinh=:gioiTinh,kh.sdt=:sdt,kh.diaChi=:diaChi,kh.email=:email WHERE kh.id=:id");
            q.setParameter("ma", kh.getMa());
            q.setParameter("ten", kh.getTen());
            q.setParameter("gioiTinh", kh.getGioiTinh());
            q.setParameter("sdt", kh.getSdt());
            q.setParameter("diaChi", kh.getDiaChi());
            q.setParameter("email", kh.getEmail());
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTrangThai(Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE KhachHang kh SET kh.trangThai = 1 WHERE kh.id=:id");
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
