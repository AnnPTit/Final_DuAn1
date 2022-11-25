/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import model.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepository {

    Session session = HibernateConfig.getFACTORY().openSession();
    List<NhanVien> list = new ArrayList<>();

    public List<NhanVien> getAll() {
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("From NhanVien WHERE trangThai =: trangThai ORDER BY ID DESC");
        q.setParameter("trangThai", 1);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        List<NhanVien> list = q.getResultList();
        return list;
    }

    public NhanVien getNhanVien(String maNv) {
        try {
            String sql = "SELECT * FROM NhanVien WHERE maNV = :ma";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(NhanVien.class);
            query.setParameter("ma", maNv);
            NhanVien results = (NhanVien) query.getSingleResult();
            // NhanVien results = (NhanVien) query.list();
            if (results == null) {
                return null;
            }
            return results;

        } catch (Exception e) {
            //            System.out.println("lỗi lấy nhân viên");
            //            e.printStackTrace();
            return null;
        }

    }

    public boolean add(NhanVien nv) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.saveOrUpdate(nv);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(NhanVien nv, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE NhanVien nv SET nv.maNV=:ma,nv.tenNV=:ten,"
                    + "nv.chucVu.id=:idCV,nv.ngaySinh=:ngaySinh,nv.gioiTinh=:gioiTinh,"
                    + "nv.diaChi=:diaChi,nv.sdt=:sdt,nv.email=:email,nv.pass=:pass WHERE nv.id=:id");
            q.setParameter("ma", nv.getMaNV());
            q.setParameter("ten", nv.getTenNV());
            q.setParameter("idCV", nv.getChucVu().getId());
            q.setParameter("ngaySinh", nv.getNgaySinh());
            q.setParameter("gioiTinh", nv.getGioiTinh());
            q.setParameter("diaChi", nv.getDiaChi());
            q.setParameter("sdt", nv.getSdt());
            q.setParameter("email", nv.getEmail());
            q.setParameter("pass", nv.getPass());
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
            Query q = ses.createQuery("UPDATE NhanVien nv SET nv.trangThai = 0  WHERE nv.id=:id");
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updatePass(NhanVien nv) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE NhanVien nv SET nv.pass =: pass WHERE nv.maNV=:ma");
            q.setParameter("pass", nv.getPass());
            q.setParameter("ma", nv.getMaNV());
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        List<NhanVien> list = new NhanVienRepository().getAll();
        System.out.println(list);
    }
}
