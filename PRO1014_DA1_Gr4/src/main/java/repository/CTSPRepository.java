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

        Query q = (Query) em.createQuery("From ChiTietSanPham");
        q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        List<ChiTietSanPham> list = q.getResultList();
        return list;
    }

    public boolean add(ChiTietSanPham ctsp) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
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
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("UPDATE ChiTietSanPham ctsp SET ctsp.ma=:ma,ctsp.sanPham.id=:idSP,"
                    + "ctsp.nhaSanXuat.id=:idNSX,ctsp.danhMuc.id=:idDM,ctsp.chatLieu.id=:idCL,"
                    + "ctsp.mauSac.id=:idMS,ctsp.moTa=:moTa,ctsp.soLuongTon=:soLuongTon,"
                    + "ctsp.giaNhap=:giaNhap,ctsp.giaBan=:giaBan,ctsp.ngaySua=:ngaySua,"
                    + "ctsp.trangThai=:trangThai WHERE ctsp.id=:id");
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
            q.setParameter("trangThai", ctsp.getTrangThai());
            q.setParameter("id", id);
            q.executeUpdate();
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(ChiTietSanPham ctsp, Integer id) {
        Transaction tran = null;
        try (Session ses = HibernateConfig.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            Query q = ses.createQuery("DELETE FROM ChiTietSanPham ctsp WHERE ctsp.id=:id");
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
