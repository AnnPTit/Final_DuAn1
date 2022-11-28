package repository;

import customModel.HoaDonDoanhThu;
import customModel.HoaDonThanhToan;
import hibernateConfig.HibernateConfig;
import java.math.BigDecimal;
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

    public List<HoaDonDoanhThu> getDoanhSo() {
        Transaction transaction = ses.beginTransaction();
        Query query = null;

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

    public List<HoaDonThanhToan> getHoaDonThanhToan() {
        Transaction transaction = ses.beginTransaction();
        Query query = null;

        try {
            String sql = "SELECT HoaDon.NgayThanhToan,SUM(SoLuong*DonGia) AS DoanhThu,COUNT(HoaDonChiTiet.Id) AS SoHoaDonDaThanhToan\n"
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
    
    public BigDecimal doanhThuTheoNam() {
        BigDecimal result = null;
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT SUM(hdct.soLuong * hdct.donGia) FROM HoaDonChiTiet hdct GROUP BY DATEPART(YYYY,hdct.hoaDonBan.ngayThanhToan)");

            result = (BigDecimal) query.getResultList().get(0);
            transaction.commit();
        }
        return result;
    }

    public BigDecimal doanhThuTheoTungThang() {
        BigDecimal result = null;
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT SUM(hdct.soLuong * hdct.donGia) FROM HoaDonChiTiet hdct GROUP BY DATEPART(MM,hdct.hoaDonBan.ngayThanhToan)");

            result = (BigDecimal) query.getResultList().get(0);
            transaction.commit();
        }
        return result;
    }

    public static void main(String[] args) {
        BigDecimal list = new HDChiTietRepository().doanhThuTheoNam();
        System.out.println(list);
    }

}
