/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.KhachHang;
import hibernateConfig.HibernateConfig;
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

    public List<KhachHang> getAll() {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query query = (Query) em.createQuery("From KhachHang where TrangThai =: trangthai order by ID desc");
        query.setParameter("trangthai", 1);
        query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        @SuppressWarnings("unchecked")
        List<KhachHang> list = query.getResultList();
        return list;
    }
    
    public List<KhachHang> getAllKhachHang() {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query query = (Query) em.createQuery("From KhachHang ");
        
        query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        @SuppressWarnings("unchecked")
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public List<KhachHang> getAllByTrangThai(int trangThai) {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("From KhachHang where trangThai =: trangthai");
        q.setParameter("trangthai", 1);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
        List<KhachHang> list = q.getResultList();
        return list;
    }

    public boolean add(KhachHang kh) {
        Transaction tran = null;
        try ( Session ses = HibernateConfig.getFACTORY().openSession()) {
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
        try ( Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE KhachHang kh SET kh.maKH=:ma,kh.tenKH=:ten,kh.gioiTinh=:gioiTinh,"
                    + "kh.diaChi=:diaChi,kh.sdt=:sdt,kh.email=:email WHERE kh.id=:id");
            q.setParameter("ma", kh.getMaKH());
            q.setParameter("ten", kh.getTenKH());
            q.setParameter("gioiTinh", kh.getGioiTinh());
            q.setParameter("diaChi", kh.getDiaChi());
            q.setParameter("sdt", kh.getSdt());
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
        try ( Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE KhachHang kh SET kh.trangThai = 0 WHERE kh.id=:id");
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public KhachHang getKhachHangByMa(String ma) {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("From KhachHang where MaKH =: ma");
        q.setParameter("ma", ma);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
        List<KhachHang> list = q.getResultList();
        KhachHang khachHang = (KhachHang) q.getSingleResult();
        return khachHang;
    }

    public List<KhachHang> getSumCustomer() {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query query = (Query) em.createQuery("SELECT COUNT(id) FROM KhachHang");
        query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        @SuppressWarnings("unchecked")
        List<KhachHang> list = query.getResultList();
        return list;

    }
}
