package repository;

import customModel.HoaDonDoanhThu;
import customModel.HoaDonThanhToan;
import hibernateConfig.HibernateConfig;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.ChiTietSanPham;
import model.HoaDonBan;
import model.HoaDonChiTiet;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.Transaction;

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
    public List<HoaDonChiTiet> getAllById(String id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("From HoaDonChiTiet where id =: id ");
        query.setParameter("id", id);
        @SuppressWarnings("unchecked")
        List<HoaDonChiTiet> ds = query.getResultList();
        return ds;
    }

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

    public List<HoaDonDoanhThu> getDoanhSo(boolean isDESC) {
        Transaction transaction = ses.beginTransaction();
        Query query = null;
        String sql = "SELECT ChiTietSP.MaCTSP,SanPham.TenSP,DanhMuc.TenDM,ChatLieu.TenCL,Mau.TenMau,NSX.TenNSX,SUM(SoLuong) AS SoLuongBanRa FROM HoaDonChiTiet\n"
                + "join ChiTietSP on HoaDonChiTiet.IdCTSP = ChiTietSP.ID\n"
                + "join SanPham on ChiTietSP.IdSP = SanPham.ID\n"
                + "join DanhMuc on ChiTietSP.IdDM = DanhMuc.ID\n"
                + "join ChatLieu on ChiTietSP.IdCL = ChatLieu.ID\n"
                + "join Mau on ChiTietSP.IdMau = Mau.ID\n"
                + "join NSX on ChiTietSP.IdNSX = NSX.Id\n"
                + "GROUP BY ChiTietSP.MaCTSP,SanPham.TenSP,DanhMuc.TenDM,ChatLieu.TenCL,Mau.TenMau,NSX.TenNSX ORDER BY SoLuongBanRa ";
        if (isDESC == true) {
            sql = sql + " DESC";
        } else {
            sql = sql + "ASC";
        }

        try {

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

    public List<HoaDonThanhToan> getHoaDonThanhToan() {
        Transaction transaction = ses.beginTransaction();
        Query query = null;

        try {
            String sql = "SELECT HoaDon.NgayThanhToan,SUM(SoLuong*DonGia) AS DoanhThu,COUNT(DISTINCT HoaDon.ID) AS SoHoaDonDaThanhToan\n"
                    + "FROM HoaDonChiTiet  join HoaDon on HoaDonChiTiet.IdHD = HoaDon.Id GROUP BY HoaDon.NgayThanhToan";
            query = ses.createSQLQuery(sql);
            List<HoaDonThanhToan> listHdThanhToan = new ArrayList<>();
            List<Object[]> rows = query.getResultList();
            for (Object[] row : rows) {
                HoaDonThanhToan hoaDonThanhToan = new HoaDonThanhToan();
                hoaDonThanhToan.setNgayThanhToan((Date) row[0]);
                hoaDonThanhToan.setDoanhThu(BigDecimal.valueOf(Double.valueOf(row[1].toString())));
                hoaDonThanhToan.setHoaDonThanhToan(Integer.valueOf(row[2].toString()));
                listHdThanhToan.add(hoaDonThanhToan);
            }

            transaction.commit();
            return listHdThanhToan;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cc");
            return null;
        }
    }

    public List<HoaDonThanhToan> filterDate(Date start, Date end) {
        Transaction transaction = ses.beginTransaction();
        Query query = null;

        try {
            String sql = "SELECT HoaDon.NgayThanhToan,SUM(SoLuong*DonGia) AS DoanhThu,COUNT(DISTINCT HoaDon.ID) AS SoHoaDonDaThanhToan\n"
                    + "FROM HoaDonChiTiet join HoaDon on HoaDonChiTiet.IdHD = HoaDon.Id\n"
                    + "WHERE NgayThanhToan BETWEEN NgayThanhToan = start AND NgayThanhToan = end GROUP BY HoaDon.NgayThanhToan";
            query = ses.createSQLQuery(sql);
            query = query.setParameter("start", start);
            query = query.setParameter("end", end);
            List<HoaDonThanhToan> listHdThanhToan = new ArrayList<>();
            List<Object[]> rows = query.getResultList();
            for (Object[] row : rows) {
                HoaDonThanhToan hoaDonThanhToan = new HoaDonThanhToan();
                hoaDonThanhToan.setNgayThanhToan((Date) row[0]);
                hoaDonThanhToan.setDoanhThu(BigDecimal.valueOf(Double.valueOf(row[1].toString())));
                hoaDonThanhToan.setHoaDonThanhToan(Integer.valueOf(row[2].toString()));
                listHdThanhToan.add(hoaDonThanhToan);
            }

            transaction.commit();
            return listHdThanhToan;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cc");
            return null;
        }
    }

    public BigDecimal doanhThuTheoNam() {
        BigDecimal result = null;
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT SUM(hdct.soLuong * hdct.donGia) FROM HoaDonChiTiet hdct WHERE YEAR(hdct.hoaDonBan.ngayThanhToan)= YEAR(GETDATE())");

            result = (BigDecimal) query.getResultList().get(0);
            transaction.commit();
        }
        return result;
    }

    public BigDecimal doanhThuTheoThang() {
        BigDecimal result = null;
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT SUM(hdct.soLuong * hdct.donGia) FROM HoaDonChiTiet hdct WHERE MONTH(hdct.hoaDonBan.ngayThanhToan)= MONTH(GETDATE())");
            result = (BigDecimal) query.getResultList().get(0);
            transaction.commit();
        }

        return result;
    }

    public BigDecimal doanhThuHomNay() {
        BigDecimal result = null;
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT SUM(hdct.soLuong * hdct.donGia) FROM HoaDonChiTiet hdct WHERE DAY(hdct.hoaDonBan.ngayThanhToan)= DAY(GETDATE())");
            result = (BigDecimal) query.getResultList().get(0);
            transaction.commit();
        }
        return result;
    }

//    public static void main(String[] args) {
//        List<HoaDonDoanhThu> list = new HDChiTietRepository().filterDate();
//        System.out.println();
//    }

}
