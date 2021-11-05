package revature.project2.Data;

import revature.project2.Model.Game;

import java.util.List;

public interface GameDAO {
    public List<Game> GetAllGames();
    public Game createGame(Game game);
    public Game deleteGame(Game game);
    public Game getGame(String name);
}
