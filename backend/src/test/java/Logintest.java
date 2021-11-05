import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import revature.project2.Data.GameDAOImp;
import revature.project2.Data.UserDAOImp;
import revature.project2.Model.Game;
import revature.project2.Model.Users;
import revature.project2.Service.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Logintest {
    private UserDAOImp userDAOImp = new UserDAOImp();
    private UserServiceImpl userService = new UserServiceImpl();
    private GameDAOImp gameDAOImp = new GameDAOImp();

    @Test
    public void login() {
        Users user = userDAOImp.logIn("test@email.com", "pass");
        assertNotNull(user);
    }

    @Test
    public void getAllByUserService() {
        Users user = new Users();
        user.setUserId(1);
        List<Game> game = userService.getUserGames(user);
        assertNotNull(game.size());

        System.out.println(game);

    }

    @Test
    public void createGametest() throws ParseException {
        Users test = new Users("email", "username", "firstname", "lastname", "role", "Password");

        String date = "2021/11/1";
        Date startDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);

        String date2 = "2021/11/2";
        Date endDate = new SimpleDateFormat("yyyy/MM/dd").parse(date2);
        Game Gametest = new Game("test", "test", false, true, startDate, endDate, "test", test);

        assertEquals(gameDAOImp.createGame(Gametest), Gametest);
        gameDAOImp.deleteGame(Gametest);

    }
}

