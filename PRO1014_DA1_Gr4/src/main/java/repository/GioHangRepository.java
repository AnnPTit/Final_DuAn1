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
import model.ChiTietSanPham;
import model.GioHang;
import model.GioHangChiTiet;
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
    //=============================================================================================================================================================================

    public Boolean addGioHangCt(GioHangChiTiet ghct) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ghct);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Loi them gio hang chi tiet");
            e.printStackTrace();
            return false;
        }
    }

//    public List<GioHangChiTiet> getGioHangChiTiet() {
//        EntityManager em = session.getEntityManagerFactory().createEntityManager();
//        em.getEntityManagerFactory().getCache().evictAll();
//        EntityTransaction entityTransaction = em.getTransaction();
//
//        Query query = (Query) em.createQuery("From GioHangChiTiet where  TrangThai = 1 ");
//        //  query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
//        //  query.setParameter("idgh", idGH);
//
//        List<GioHangChiTiet> listghTiet = query.getResultList();
//        return listghTiet;
//    }

    public List<GioHangChiTiet> getGioHangChiTietByGiHang(int idGH) {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query query = (Query) em.createQuery("From GioHangChiTiet where IdGH =:idgh and TrangThai = 1 ");
        //  query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
        query.setParameter("idgh", idGH);

        List<GioHangChiTiet> listghTiet = query.getResultList();
        return listghTiet;
    }

    public Boolean updateTrangThaiGhCT(int idGH, int trangThai) {
        Transaction transision = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transision = session.beginTransaction();
            Query query = session.createQuery("UPDATE GioHangChiTiet set TrangThai =:trangthai WHERE IdGH =:id ");
            query.setParameter("id", idGH);
            query.setParameter("trangthai", trangThai);
            check = query.executeUpdate();
            transision.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Boolean updateSoLuongGhCt(int id, int soLuong) {
        Transaction transision = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transision = session.beginTransaction();
            Query query = session.createQuery("UPDATE GioHangChiTiet set SoLuong =:soLuong WHERE ID =:id ");
            query.setParameter("id", id);
            query.setParameter("soLuong", soLuong);
            check = query.executeUpdate();
            transision.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteGioHangChiTiet(GioHangChiTiet ghct) {
        Transaction transision = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transision = session.beginTransaction();
            Query query = session.createQuery("DELETE GioHangChiTiet WHERE ID =: id");
            query.setParameter("id", ghct.getId());

            check = query.executeUpdate();
            transision.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
//        GioHang gioHang = new GioHang();
//        gioHang.setId(25);
//        ChiTietSanPham ctsp = new ChiTietSanPham();
//        ctsp.setId(3);
//        GioHangChiTiet ghct = new GioHangChiTiet();
//        ghct.setGioHang(gioHang);
//        ghct.setChiTietSanPham(ctsp);
//
//        new GioHangRepository().addGioHangCt(ghct);

    }
}
