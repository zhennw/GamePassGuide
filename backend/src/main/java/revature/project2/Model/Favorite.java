package revature.project2.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "favorite" , schema = "public")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fav_id")
    private int favId;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne()
    @JoinColumn(name = "game_id")
    private Game game;

    public Favorite()
    {
        super();
    }

    public int getFavId() {
        return favId;
    }

    public void setFavId(int favId) {
        this.favId = favId;
    }

    public Users user() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "favId=" + favId +
                ", user=" + user +
                ", game=" + game +
                '}';
    }
}
