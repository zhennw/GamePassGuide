package revature.project2.Data;

import revature.project2.Controllers.GameController;
import revature.project2.Controllers.UserController;
import revature.project2.Model.Game;
import revature.project2.Model.Users;
import revature.project2.Service.Passwordhash;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException, NoSuchProviderException {

//        Users user;
//        UserDAOImp userDAOImp = new UserDAOImp();
          Passwordhash p = new Passwordhash();
//        user = userDAOImp.logIn("test@email.com", "pass");
//        System.out.println(user);
        String password = "hello";


        String securePassword = p.hash(password);
        System.out.println(securePassword);

//        List<Game> gameList;
//        UserDAOImp getall = new UserDAOImp();
//        gameList = getall.getAllGamesByUser(user);
//        System.out.println(gameList);
//
//        GameDAOImp gameDAOImp = new GameDAOImp();
//
        Users test = new Users("test@email.com", "username", "firstname", "lastname", "role", "pass");
        UserController userController = new UserController();
        userController.login(test);
////        userDAOImp.createUser(test);
//
//        String date = "2021/11/1";
//        Date startDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
//
//        String date2 = "2021/11/2";
//        Date endDate = new SimpleDateFormat("yyyy/MM/dd").parse(date2);
//        Game Gametest = new Game("test", "test", false, true, startDate, endDate , "test",user);
//
//        gameDAOImp.createGame(Gametest);
//        Game bestgame = gameDAOImp.getGame("test");
//        gameDAOImp.deleteGame(bestgame);
//        System.out.println("complete");
        GameController gameController = new GameController();
        gameController.getAllGames();

    }
}
