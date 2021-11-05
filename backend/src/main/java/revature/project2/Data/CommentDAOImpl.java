package revature.project2.Data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import revature.project2.Model.Comment;
import revature.project2.Service.SessionService;

public class CommentDAOImpl implements  CommentDAO{
    private static SessionFactory sf = SessionService.getSessionFactory();

    public CommentDAOImpl() {
        super();
    }

    @Override
    public Comment addComment(Comment comment) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        int id = (int) sess.save(comment);
        comment.setCommentId(id);
        tx.commit();
        return comment;
    }

    @Override
    public Comment deleteComment(Comment comment) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        sess.delete(comment);
        tx.commit();
        return comment;
    }
}
