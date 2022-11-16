/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import model.DanhMuc;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class DanhMucRepository {
    Session ses = HibernateConfig.getFACTORY().openSession();

    public List<DanhMuc> getAll() {
        Query q = ses.createQuery("FROM DanhMuc");
        List<DanhMuc> list = q.getResultList();
        return list;
    }

    public boolean add(DanhMuc dm) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.saveOrUpdate(dm);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(DanhMuc dm, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE DanhMuc dm SET dm.maDM=:ma,dm.tenDM=:ten,dm.ngaySua=:ngaySua,dm.trangThai=:trangThai WHERE dm.id=:id");
            q.setParameter("ma", dm.getMaDM());
            q.setParameter("ten", dm.getTenDM());
            q.setParameter("ngaySua", dm.getNgaySua());
            q.setParameter("trangThai", dm.getTrangThai());
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(DanhMuc dm, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("DELETE FROM DanhMuc dm WHERE dm.id=:id");
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public DanhMuc getById(int id) {
        DanhMuc danhMuc = null;
        try {
            Query q = ses.createQuery("SELECT dm FROM DanhMuc dm WHERE dm.id=:id");
            q.setParameter("id", id);
            danhMuc = (DanhMuc) q.getSingleResult();
        } catch (Exception e) {
        }
        return danhMuc;
    }
}
