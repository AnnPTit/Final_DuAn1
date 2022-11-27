package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.ChiTietSanPham;
import model.HoaDonChiTiet;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author fallinluv2003
 */
public class HDChiTietRepository {

    Session ses = HibernateConfig.getFACTORY().openSession();

    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> list = new ArrayList<>();
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("FROM HoaDonChiTiet WHERE trangThai =: trangThai ORDER BY soLuong DESC");
        q.setParameter("trangThai", 2);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        list = q.getResultList();
        return list;
    }

//    
    public List<HoaDonChiTiet> getDoanhThu() {
        List<HoaDonChiTiet> list = new ArrayList<>();
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("SELECT SUM(hdct.soLuong * hdct.chiTietSanPham.giaBan) FROM HoaDonChiTiet hdct WHERE");
        q.setParameter("trangThai", 2);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        list = q.getResultList();
        return list;
    }

    public List<HoaDonChiTiet> getById(int id) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("FROM HoaDonChiTiet WHERE IdHD =: id");
        q.setParameter("id", id);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
        list = q.getResultList();
        return list;
    }

    public List<HoaDonChiTiet> getDoanhSo() {
        List<HoaDonChiTiet> list = new ArrayList<>();
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        NativeQuery q = ses.createNativeQuery("SELECT ChiTietSP.MaCTSP,SanPham.TenSP,SUM(SoLuong) AS SoLuongBanRa FROM HoaDonChiTiet\n"
                + "join ChiTietSP on HoaDonChiTiet.IdCTSP = ChiTietSP.ID\n"
                + "join SanPham on ChiTietSP.IdSP = SanPham.ID\n"
                + "GROUP BY ChiTietSP.MaCTSP,SanPham.TenSP\n"
                + "ORDER BY SoLuongBanRa DESC");
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        list = q.getResultList();
        return list;
    }
    
//    public List<HoaDonChiTiet> getHoaDonThanhToan() {
//        
//    }

    public static void main(String[] args) {
        List<HoaDonChiTiet> list = new HDChiTietRepository().getById(98);
        System.out.println(list);
    }

    // Them HDCT Repo
    // ABc
}
