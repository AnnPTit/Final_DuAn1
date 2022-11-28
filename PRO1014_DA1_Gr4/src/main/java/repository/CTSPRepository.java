package repository;

import hibernateConfig.HibernateConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import model.ChatLieu;
import model.ChiTietSanPham;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.DanhMuc;
import model.Mau;
import model.NSX;
import static mssql.googlecode.concurrentlinkedhashmap.Weighers.list;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author fallinluv2003
 */
public class CTSPRepository {

    Session ses = HibernateConfig.getFACTORY().openSession();

    public List<ChiTietSanPham> getAll() {
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("From ChiTietSanPham WHERE trangThai =: trangThai and SoLuongTon > 0 ORDER BY ID DESC");
        q.setParameter("trangThai", 1);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        List<ChiTietSanPham> list = q.getResultList();
        return list;
    }

    public boolean add(ChiTietSanPham ctsp) {
        Transaction tran = null;
        try ( Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.save(ctsp);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ChiTietSanPham ctsp, Integer id) {
        Transaction tran = null;
        try ( Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE ChiTietSanPham ctsp SET ctsp.ma=:ma,ctsp.sanPham.id=:idSP,"
                    + "ctsp.nhaSanXuat.id=:idNSX,ctsp.danhMuc.id=:idDM,ctsp.chatLieu.id=:idCL,"
                    + "ctsp.mauSac.id=:idMS,ctsp.moTa=:moTa,ctsp.soLuongTon=:soLuongTon,"
                    + "ctsp.giaNhap=:giaNhap,ctsp.giaBan=:giaBan,ctsp.ngaySua=:ngaySua WHERE ctsp.id=:id");
            q.setParameter("ma", ctsp.getMa());
            q.setParameter("idSP", ctsp.getSanPham().getId());
            q.setParameter("idNSX", ctsp.getNhaSanXuat().getId());
            q.setParameter("idDM", ctsp.getDanhMuc().getId());
            q.setParameter("idCL", ctsp.getChatLieu().getId());
            q.setParameter("idMS", ctsp.getMauSac().getId());
            q.setParameter("moTa", ctsp.getMoTa());
            q.setParameter("soLuongTon", ctsp.getSoLuongTon());
            q.setParameter("giaNhap", ctsp.getGiaNhap());
            q.setParameter("giaBan", ctsp.getGiaBan());
            q.setParameter("ngaySua", ctsp.getNgaySua());
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
        try ( Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE ChiTietSanPham ctsp SET ctsp.trangThai = 0  WHERE ctsp.id=:id");
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Long getSumProduct() {
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("SELECT SUM(soLuongTon) FROM ChiTietSanPham");
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        Long list = (Long) q.getSingleResult();
        return list;
    }

    public int getSoLuongSpByMaCTSP(String maCTSP) {
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("SELECT soLuongTon FROM ChiTietSanPham where MaCTSP =:ma");
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
        q.setParameter("ma", maCTSP);

        int soLuong = (int) q.getSingleResult();
        return soLuong;
    }

    public Boolean updateSoLuongCTSP(String maCTSP, int so) {

        Transaction tran = null;
        try ( Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE ChiTietSanPham  SET soLuongTon  = soLuongTon - :so  WHERE MaCTSP =:ma");
            q.setParameter("ma", maCTSP);
            q.setParameter("so", so);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ChiTietSanPham> getChiTietSanPhamByComBoBox(DanhMuc isdanhMuc, ChatLieu isChatLieu, Mau isMau, NSX isNsx) {
        Transaction transaction = ses.beginTransaction();
        String sqlEx = null;
        Query query = null;
        String sql = "select \n"
                + "ChiTietSP.ID,\n"
                + "ChiTietSP.MaCTSP,\n"
                + "SanPham.TenSP,\n"
                + "DanhMuc.TenDM,\n"
                + "ChatLieu.TenCL ,\n"
                + "Mau.TenMau,\n"
                + "NSX.TenNSX,\n"
                + "ChiTietSP.SoluongTon,\n"
                + "ChiTietSP.GiaNhap,\n"
                + "ChiTietSP.GiaBan,\n"
                + "ChiTietSP.MoTa,\n"
                + "ChiTietSP.NgayTao,\n"
                + "ChiTietSP.NgaySua,\n"
                + "ChiTietSP.TrangThai\n"
                + "from ChiTietSP join SanPham on SanPham.ID = ChiTietSP.IdSP\n"
                + "join DanhMuc on DanhMuc.ID =ChiTietSP.IdDM\n"
                + "join ChatLieu on ChatLieu.ID = ChiTietSP.IdCL\n"
                + "join Mau on Mau.ID = ChiTietSP.IdMau\n"
                + "join NSX on NSX.ID = ChiTietSP.IdNSX where 1=1 ";
        // Query queryx = query;
        if (isdanhMuc != null) {
            sql = sql + " and DanhMuc.ID =:iddm ";
        }
        if (isChatLieu != null) {
            sql = sql + " and ChatLieu.ID =:idcl";
        }
        if (isMau != null) {
            sql = sql + " and Mau.ID =:idmau";
        }
        if (isNsx != null) {
            sql = sql + " and NSX.ID =:idnsx";
        }
        
        query = ses.createSQLQuery(sql);
        if (isdanhMuc != null) {
            query = query.setParameter("iddm", isdanhMuc.getId());
        }
        if (isChatLieu != null) {
            query = query.setParameter("idcl", isChatLieu.getId());
        }
        if (isMau != null) {
            query = query.setParameter("idmau", isMau.getId());
        }
        if (isNsx != null) {
            query = query.setParameter("idnsx", isNsx.getId());
        }

        try {
            List<Object[]> rows = query.getResultList();
            List<ChiTietSanPham> list = new ArrayList<>();
            for (Object[] row : rows) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setId(Integer.parseInt(row[0].toString()));
                ctsp.setMa(row[1].toString());
                list.add(ctsp);
            }
            transaction.commit();
            return list;

        } catch (Exception e) {
            System.out.println("cc");
            return null;
        }
    }

    public ChiTietSanPham getAllByID(int id) {
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("From ChiTietSanPham WHERE ID=:id and trangThai =: trangThai and SoLuongTon > 0 ORDER BY ID DESC");
        q.setParameter("id", id);
        q.setParameter("trangThai", 1);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        ChiTietSanPham ctsp = (ChiTietSanPham) q.getSingleResult();
        return ctsp;
    }
    
    public Long getProduct() {
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("SELECT COUNT(Id) FROM ChiTietSanPham ctsp WHERE ctsp.trangThai =: trangThai");
        q.setParameter("trangThai", 1);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        Long list = (Long) q.getSingleResult();
        return list;
    }
    
    public Long getNonProduct() {
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("SELECT COUNT(Id) FROM ChiTietSanPham ctsp WHERE ctsp.trangThai =: trangThai");
        q.setParameter("trangThai", 0);
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        Long list = (Long) q.getSingleResult();
        return list;
    }
    
    public Long getOutProduct() {
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("SELECT COUNT(Id) FROM ChiTietSanPham ctsp WHERE ctsp.trangThai = 1 AND ctsp.soLuongTon < 10");
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        Long list = (Long) q.getSingleResult();
        return list;
    }

    public static void main(String[] args) {
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setId(10);
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setId(4);
        Mau m = new Mau();
        m.setId(4);
        NSX nsx = new NSX();
        nsx.setId(3);
        List<ChiTietSanPham> list = new CTSPRepository().getChiTietSanPhamByComBoBox(danhMuc, chatLieu, null, null);
        List<ChiTietSanPham> list1 = new ArrayList<>();
        for (ChiTietSanPham chiTietSanPham : list) {
            System.out.println(chiTietSanPham.getId());
            ChiTietSanPham ctsp = new CTSPRepository().getAllByID(chiTietSanPham.getId());
            list1.add(ctsp);
        }
        for (ChiTietSanPham chiTietSanPham : list1) {
            System.out.println(chiTietSanPham.getChatLieu().toString());
        }
    }

}
