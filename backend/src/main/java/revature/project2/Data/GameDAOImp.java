package revature.project2.Data;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import revature.project2.Model.Game;
import revature.project2.Service.SessionService;

import java.util.List;

@Repository
public class GameDAOImp implements GameDAO{
    private static SessionFactory sf = SessionService.getSessionFactory();

    @Override
    public List<Game> GetAllGames()
    {
        Session sess = sf.openSession();

        Query query = sess.createQuery("from Game");

        return query.list();
    }

    @Override
    public Game createGame(Game game) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        int id = (int) sess.save(game);
        game.setId(id);
        tx.commit();
        return game;
    }

    @Override
    public Game getGame(String name) {
        Session sess = sf.openSession();
        Criteria criteria = sess.createCriteria(Game.class).add(Restrictions.eq("gameTitle",name));
        return (Game) criteria.list().get(0);
    }

    @Override
    public Game deleteGame(Game game) {
        System.out.println(game.toString());
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        sess.delete(game);
        tx.commit();        
        return game;
    }


}
