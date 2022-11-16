/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import model.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepository {

    Session session = HibernateConfig.getFACTORY().openSession();
    List<NhanVien> list = new ArrayList<>();

    public List<NhanVien> getList() {
        Query query = session.createQuery("From NhanVien");
        list = query.getResultList();
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

    public static void main(String[] args) {
        List<NhanVien> list = new NhanVienRepository().getList();
        System.out.println(list);
    }
}
