/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import model.ChatLieu;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class ChatLieuRepository {
    Session ses = HibernateConfig.getFACTORY().openSession();

    public List<ChatLieu> getAll() {
        Query q = ses.createQuery("FROM ChatLieu");
        List<ChatLieu> list = q.getResultList();
        return list;
    }

    public boolean add(ChatLieu cl) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.saveOrUpdate(cl);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ChatLieu cl, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE ChatLieu cl SET cl.maCL=:ma,cl.tenCL=:ten,cl.ngaySua=:ngaySua,cl.trangThai=:trangThai WHERE cl.id=:id");
            q.setParameter("ma", cl.getMaCL());
            q.setParameter("ten", cl.getTenCL());
            q.setParameter("ngaySua", cl.getNgaySua());
            q.setParameter("trangThai", cl.getTrangThai());
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(ChatLieu cl, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("DELETE FROM ChatLieu cl WHERE cl.id=:id");
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
