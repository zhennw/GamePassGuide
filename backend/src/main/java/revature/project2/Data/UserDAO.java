package revature.project2.Data;

import revature.project2.Model.Comment;
import revature.project2.Model.Game;
import revature.project2.Model.Users;

import java.util.List;

public interface UserDAO {
    public Users logIn(String email, String password);
    public List<Game> getAllGamesByUser(Users user);
    public List<Comment> getUserComments(Users user);
    public Users createUser(Users user);

}
