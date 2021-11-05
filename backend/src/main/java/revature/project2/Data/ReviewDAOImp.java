package revature.project2.Data;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import revature.project2.Model.Review;
import revature.project2.Service.SessionService;

import java.util.List;

public class ReviewDAOImp implements ReviewDAO {
    private static SessionFactory sf = SessionService.getSessionFactory();

    @Override
    public List<Review> getReviewByUser(Review review) {
        Session sess = sf.openSession();

        String hql = "from Review rev where rev.user = :user";
        Query query = sess.createQuery(hql);
        query.setParameter("user", review.getUser());

        return query.list();
    }


    @Override
    public List<Review> getReviewByGame(Review review) {
        Session sess = sf.openSession();

        String hql = "from Review rev where rev.game = :game";
        Query query = sess.createQuery(hql);
        query.setParameter("game", review.getGame());

        return query.list();
    }

    @Override
    public Review createReview(Review review) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        int id = (int) sess.save(review);
        review.setReviewId(id);
        tx.commit();
        return review;
    }

    @Override
    public Review deleteReview(Review review) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        sess.delete(review);
        tx.commit();
        return review;
    }
}
