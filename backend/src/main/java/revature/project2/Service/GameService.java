package revature.project2.Service;

import revature.project2.Model.Game;
import revature.project2.Model.Review;

import java.util.List;

public interface GameService {
    public List<Game> getAllGames();
    public List<Review> getReviewByGame(Review review);
}
