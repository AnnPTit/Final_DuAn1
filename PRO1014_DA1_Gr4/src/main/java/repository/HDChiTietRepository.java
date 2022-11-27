package repository;

import customModel.HoaDonDoanhThu;
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
<<<<<<< HEAD
import org.hibernate.query.NativeQuery;
=======
import org.hibernate.Transaction;
>>>>>>> 9e5540919f0d5f85cf09e56774c477468378712d

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
<<<<<<< HEAD

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
=======

    public List<HoaDonDoanhThu> getDoanhSo() {
        Transaction transaction = ses.beginTransaction();
        Query query = null;
>>>>>>> 9e5540919f0d5f85cf09e56774c477468378712d

        try {
            String sql = "SELECT ChiTietSP.MaCTSP,SanPham.TenSP,DanhMuc.TenDM,ChatLieu.TenCL,Mau.TenMau,NSX.TenNSX,SUM(SoLuong) AS SoLuongBanRa FROM HoaDonChiTiet\n"
                    + "join ChiTietSP on HoaDonChiTiet.IdCTSP = ChiTietSP.ID\n"
                    + "join SanPham on ChiTietSP.IdSP = SanPham.ID\n"
                    + "join DanhMuc on ChiTietSP.IdDM = DanhMuc.ID\n"
                    + "join ChatLieu on ChiTietSP.IdCL = ChatLieu.ID\n"
                    + "join Mau on ChiTietSP.IdMau = Mau.ID\n"
                    + "join NSX on ChiTietSP.IdNSX = NSX.Id\n"
                    + "GROUP BY ChiTietSP.MaCTSP,SanPham.TenSP,DanhMuc.TenDM,ChatLieu.TenCL,Mau.TenMau,NSX.TenNSX\n"
                    + "ORDER BY SoLuongBanRa DESC";
            query = ses.createSQLQuery(sql);
            List<HoaDonDoanhThu> listHdDoanhThu = new ArrayList<>();
            List<Object[]> rows = query.getResultList();
            for (Object[] row : rows) {
                HoaDonDoanhThu hoaDonDoanhThu = new HoaDonDoanhThu();
                hoaDonDoanhThu.setMaCTSP(row[0].toString());
                hoaDonDoanhThu.setTenSP(row[1].toString());
                hoaDonDoanhThu.setTenDm(row[2].toString());
                hoaDonDoanhThu.setTenCL(row[3].toString());
                hoaDonDoanhThu.setTenMau(row[4].toString());
                hoaDonDoanhThu.setTenNSX(row[5].toString());
                hoaDonDoanhThu.setSoLuongBanRa(Integer.valueOf(row[6].toString()));
                listHdDoanhThu.add(hoaDonDoanhThu);
            }

            transaction.commit();
            return listHdDoanhThu;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cc");
            return null;
        }
    }
<<<<<<< HEAD
    
//    public List<HoaDonChiTiet> getHoaDonThanhToan() {
//        
//    }
=======
>>>>>>> 9e5540919f0d5f85cf09e56774c477468378712d

    public static void main(String[] args) {
        List<HoaDonDoanhThu> list = new HDChiTietRepository().getDoanhSo();
        System.out.println(list);
    }

}
