/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import model.KhuyenMai;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author T450s
 */
public class KhuyenMaiRepo {

    public ArrayList<KhuyenMai> getAll() {
        Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession();
        Query q = se.createQuery("From KhuyenMai");
        ArrayList<KhuyenMai> ds = (ArrayList<KhuyenMai>) q.getResultList();
        return ds;
    }

    public void insert(KhuyenMai km) {
        try ( Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = se.beginTransaction();
            Integer rowSucc = (Integer) se.save(km);
            tran.commit();
            System.out.println("So ban da duoc ghi" + rowSucc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dele(int id) {
        try ( Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = se.beginTransaction();
            String hql = "Delete KhuyenMai km where km.id= :id";
            Query q = se.createQuery(hql);
            q.setParameter("id", id);
            int suc = q.executeUpdate();
            tran.commit();
            System.out.println("So ban da duoc ghi thanh cong" + suc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(KhuyenMai km, int id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try ( Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = se.beginTransaction();

            String hql = "Update KhuyenMai km set km.makm = :makm ,km.tenkm = :tenkm, km.ngayTao = :ngayTao , km.phantramgiam = :phantramgiam, km.minhoadon= :minhoadon, km.ngayhethan = :ngayHethan , km.ghichu= :ghichu, km.trangthai= :trangthai where km.id= :id";
            Query q = se.createQuery(hql);

            q.setParameter("makm", km.getMakm());
            q.setParameter("tenkm", km.getTenkm());
            q.setParameter("ngayTao", km.getNgayTao(), TemporalType.DATE);
            q.setParameter("phantramgiam", km.getPhantramgiam());
            q.setParameter("minhoadon", km.getMinhoadon());
            q.setParameter("ngayHethan", km.getNgayhethan(), TemporalType.DATE);
            q.setParameter("ghichu", km.getGhichu());
            q.setParameter("trangthai", km.getTrangthai());
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<KhuyenMai> getAllKhuyenMaiMap(double minHoaDon) {
        Session se = hibernateConfig.HibernateConfig.getFACTORY().openSession();
        Query q = se.createQuery("From KhuyenMai where MinHoaDon < : min");
        q.setParameter("min", (minHoaDon + 1));
        ArrayList<KhuyenMai> ds = (ArrayList<KhuyenMai>) q.getResultList();
        return ds;
    }

    public static void main(String[] args) {
        List<KhuyenMai> list = new KhuyenMaiRepo().getAllKhuyenMaiMap(1000);
        System.out.println(list);
    }

}