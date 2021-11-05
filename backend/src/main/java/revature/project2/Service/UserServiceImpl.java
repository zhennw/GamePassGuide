package revature.project2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import revature.project2.Data.*;
import revature.project2.Model.Favorite;
import revature.project2.Model.Game;
import revature.project2.Model.Review;
import revature.project2.Model.Users;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private EmailService emailService;
    private FavoriteDAO favoriteDAO = new FavoriteDAOImp();
    private ReviewDAOImp reviewDAO = new ReviewDAOImp();
    private Passwordhash passwordhash = new Passwordhash();

    @Override
    public Users login(String email, String password) throws NoSuchAlgorithmException {
        String hashpass = passwordhash.hash(password);
        return userDao.logIn(email,hashpass);
    }

    @Override
    public List<Game> getUserGames(Users user) {
        return userDao.getAllGamesByUser(user);
    }

    @Override
    public Users createUser(Users user) throws NoSuchAlgorithmException {
        String hashpass = user.getUserPassword();
        hashpass = passwordhash.hash(hashpass);
        user.setUserPassword(hashpass);
        return userDao.createUser(user);
    }

    @Override
    public Favorite addFavorite(Favorite favorite) {
        return favoriteDAO.createFavorite(favorite);
    }

    @Override
    public Favorite deleteFavorite(Favorite favorite) {
        return  favoriteDAO.deleteFavorite(favorite);
    }

    @Override
    public Review addReview(Review review) {
        return reviewDAO.createReview(review);
    }



    @Override
    public Review deleteReview(Review review) {
        return reviewDAO.deleteReview(review);
    }

    @Override
    public List<Review> getUserReview(Review review) {
        return reviewDAO.getReviewByUser(review);
    }
}
