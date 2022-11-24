package repository;

import hibernateConfig.HibernateConfig;
import model.ChatLieu;
import model.ChiTietSanPham;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public List<ChiTietSanPham> getSumProduct() {
        EntityManager em = ses.getEntityManagerFactory().createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        EntityTransaction entityTransaction = em.getTransaction();

        Query q = (Query) em.createQuery("SELECT SUM(soLuongTon) FROM ChiTietSanPham");
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        List<ChiTietSanPham> list = q.getResultList();
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

    public static void main(String[] args) {
        new CTSPRepository().updateSoLuongCTSP("CTSP1", 2);
    }

}
