/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import model.NSX;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class NSXRepository {
    Session ses = HibernateConfig.getFACTORY().openSession();

    public List<NSX> getAll() {
        Query q = ses.createQuery("FROM NSX");
        List<NSX> list = q.getResultList();
        return list;
    }

    public boolean add(NSX nsx) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.saveOrUpdate(nsx);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(NSX nsx, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE NSX nsx SET nsx.maNSX=:ma,nsx.tenNSX=:ten,nsx.ngaySua=:ngaySua,nsx.trangThai=:trangThai WHERE nsx.id=:id");
            q.setParameter("ma", nsx.getMaNSX());
            q.setParameter("ten", nsx.getTenNSX());
            q.setParameter("ngaySua", nsx.getNgaySua());
            q.setParameter("trangThai", nsx.getTrangThai());
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(NSX nsx, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("DELETE FROM NSX nsx WHERE nsx.id=:id");
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
