package revature.project2.Controllers;


import revature.project2.Model.Game;
import revature.project2.Model.Review;
import revature.project2.Service.GameService;
import revature.project2.Service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public List<Game> getAllGames(){
         System.out.println(gameService.getAllGames());
        return  gameService.getAllGames();
    }

    @GetMapping("/games/reviews")
    public List<Review> getGameReviews(@RequestBody Review review){
        return  gameService.getReviewByGame(review);
    }
}
