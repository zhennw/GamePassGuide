package revature.project2.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revature.project2.Data.GameDAO;
import revature.project2.Data.ReviewDAO;
import revature.project2.Data.ReviewDAOImp;
import revature.project2.Model.Game;
import revature.project2.Model.Review;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDAO gameDao;

    private ReviewDAO reviewDAO = new ReviewDAOImp();

    @Override
    public List<Game> getAllGames() {
        return gameDao.GetAllGames();
    }

    @Override
    public List<Review> getReviewByGame(Review review) {
        System.out.println(review);
        return reviewDAO.getReviewByGame(review);
    }
}
