/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import model.Mau;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class MauRepository {
    Session ses = HibernateConfig.getFACTORY().openSession();

    public List<Mau> getAll() {
        Query q = ses.createQuery("FROM Mau");
        List<Mau> list = q.getResultList();
        return list;
    }

    public boolean add(Mau ms) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.saveOrUpdate(ms);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Mau ms, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE Mau ms SET ms.maMau=:ma,ms.tenMau=:ten,ms.ngaySua=:ngaySua,ms.trangThai=:trangThai WHERE ms.id=:id");
            q.setParameter("ma", ms.getMaMau());
            q.setParameter("ten", ms.getTenMau());
            q.setParameter("ngaySua", ms.getNgaySua());
            q.setParameter("trangThai", ms.getTrangThai());
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Mau ms, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("DELETE FROM Mau dm WHERE ms.id=:id");
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
