package revature.project2.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import revature.project2.Model.Favorite;
import revature.project2.Model.Game;
import revature.project2.Model.Review;
import revature.project2.Model.Users;
import revature.project2.Service.UserService;
import revature.project2.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Users user;
    @Autowired
    private Favorite favorite;
    @Autowired
    private Game game;

    @PostMapping("/login")
    public ResponseEntity <Users> login(@RequestBody Users users) throws NoSuchAlgorithmException {
        String email = users.getEmail();
        String password = users.getUserPassword();

        if(userService.login(email,password) != null){
            return new ResponseEntity<>(userService.login(email,password),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/user/games")
    public List<Game> getUserGames(@RequestParam(value = "user_id")int id){
//        Users user = new Users();
        user.setUserId(id);
        return userService.getUserGames(user);
    }

    @PostMapping("/register")
    public ResponseEntity <Users> register(@RequestBody Users users) throws NoSuchAlgorithmException {
        System.out.println(users);
        users.setRole("USER");
        return new ResponseEntity<>(userService.createUser(users), HttpStatus.CREATED);
    }

    @PostMapping("/user/favorites")
    public ResponseEntity<Favorite> addFavorite(@RequestParam(value = "Game", required = true)int gameId, @RequestParam(value = "User",required = true)int userId){
        user.setUserId(userId);
        game.setId(gameId);
        favorite.setUser(user);
        favorite.setGame(game);
        return new ResponseEntity<>(userService.addFavorite(favorite), HttpStatus.CREATED);
    }
   @DeleteMapping("/user/favorites")
   public ResponseEntity<Favorite> deleteFavorite(@RequestBody Favorite favorite){
       return new ResponseEntity<>(userService.deleteFavorite(favorite), HttpStatus.OK);
   }

   @GetMapping("/user/reviews")
   public List<Review>   getUserReview(@RequestBody Review review){
        return userService.getUserReview(review);
   }

   @PostMapping("/user/reviews")
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        return new ResponseEntity<>(userService.addReview(review), HttpStatus.CREATED);
   }

   @DeleteMapping("/user/reviews")
   public ResponseEntity<Review> deleteReview(@RequestBody Review review){
       return new ResponseEntity<>(userService.deleteReview(review), HttpStatus.OK);
   }


}
