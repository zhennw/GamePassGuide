package revature.project2.Data;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import revature.project2.Model.Comment;
import revature.project2.Model.Game;
import revature.project2.Model.Users;
import revature.project2.Service.SessionService;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{
    private static SessionFactory sf = SessionService.getSessionFactory();

    @Override
    public Users logIn(String email, String password)
    {
        Session sess = sf.openSession();
        String hql = "from Users where user_email = :userEmailParam and user_password = :user_passwordParam";
        Query query = sess.createQuery(hql);
        query.setParameter("userEmailParam", email);
        query.setParameter("user_passwordParam", password);
        Users users =(Users) query.uniqueResult();

        if(users == null)
        {
            return null;
        }else
        {
            return users;
        }
    }

    @Override
    public List<Game> getAllGamesByUser(Users user) {
        Session sess = sf.openSession();

        String hql = "from Favorite fav where fav.user = :user";
        Query query = sess.createQuery(hql);
        query.setParameter("user", user);


        return query.list();
    }
    public List<Comment> getUserComments(Users user)
    {
        Session sess = sf.openSession();
        String hql = "from Personalnote person where person.user = :user";
        Query query = sess.createQuery(hql);
        query.setParameter("user", user);

        return query.list();
    }
    @Override
    public Users createUser(Users user) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        int id = (int) sess.save(user);
        user.setUserId(id);
        tx.commit();
        return user;
    }
}
