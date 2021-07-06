package goldenoaks.data;

import goldenoaks.business.Checkout;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class CheckoutDb {

    public static void checkoutBook(Checkout checkout) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(checkout);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
       

    //TODO: Add code to check out a book.
    }

    public static List<Checkout> selectCheckedOutBooks() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String query = "SELECT i from Checkout i"
                + "LIMIT 15";
        TypedQuery<Checkout> tQuery = em.createQuery(query, Checkout.class);
        List<Checkout> cList;
        try {
            cList = tQuery.getResultList();
            if (cList == null || cList.isEmpty())
                cList = null;
        } finally {
            em.close();
        }
        
    //TODO: Add code to select all checked out books.
        
        return cList;
    }

    public static void checkinBook(long checkoutNumber) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        
    }
}
