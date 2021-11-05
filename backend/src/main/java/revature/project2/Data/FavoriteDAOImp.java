package revature.project2.Data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import revature.project2.Model.Favorite;
import revature.project2.Service.SessionService;

public class FavoriteDAOImp implements  FavoriteDAO{
    private static SessionFactory sf = SessionService.getSessionFactory();

    @Override
    public Favorite createFavorite(Favorite favorite) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        int id = (int) sess.save(favorite);
        favorite.setFavId(id);
        tx.commit();
        return favorite;
    }

    @Override
    public Favorite deleteFavorite(Favorite favorite) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        sess.delete(favorite);
        tx.commit();
        return favorite;
    }
}
