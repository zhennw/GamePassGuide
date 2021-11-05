package revature.project2.Service;

import org.springframework.stereotype.Service;
import revature.project2.Model.Favorite;
import revature.project2.Model.Game;
import revature.project2.Model.Review;
import revature.project2.Model.Users;

import javax.jws.soap.SOAPBinding;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public interface UserService {
    public Users login(String email, String password) throws NoSuchAlgorithmException;
    public List<Game> getUserGames(Users user);
    public Users createUser(Users user) throws NoSuchAlgorithmException;
    public Favorite addFavorite(Favorite favorite);
    public Favorite deleteFavorite(Favorite favorite);
    public Review addReview(Review review);
    public Review deleteReview(Review review);
    public List<Review> getUserReview(Review review);
}
