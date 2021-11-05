package revature.project2.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Component
@Entity
@Table(name = "game", schema ="public")
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int id;
    @Column(name = "game_title" )
    private String title;
    @Column(name = "game_genre")
    private String genre;
    @Column(name = "isxbox")
    private boolean isXbox;
    @Column(name = "ispc")
    private boolean isPc;
    @Column(name = "available_start")
    private Date availableDate;
    @Column(name = "available_end")
    private Date availableEnd;
    @Column(name = "image_url")
    private String imageUrl;
//    @ManyToOne()
//    @JoinColumn(name = "user_id")
//    private Users user;
    public Game()
    {
        super();
    }
    public Game(String gameName, String gameGenre, boolean isXbox, boolean isPc, Date availableStart, Date availableEnd, String imageURL ,Users user) {
        this.title = gameName;
        this.genre = gameGenre;
        this.isXbox = isXbox;
        this.isPc = isPc;
        this.availableDate = availableStart;
        this.availableEnd = availableEnd;
        this.imageUrl = imageURL;
//        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isXbox() {
        return isXbox;
    }

    public void setXbox(boolean xbox) {
        isXbox = xbox;
    }

    public boolean isPc() {
        return isPc;
    }

    public void setPc(boolean pc) {
        isPc = pc;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public Date getAvailableEnd() {
        return availableEnd;
    }

    public void setAvailableEnd(Date availableEnd) {
        this.availableEnd = availableEnd;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

//    public Users getUser() {
//        return user;
//    }
//
//    public void setUser(Users user) {
//        this.user = user;
//    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && isXbox == game.isXbox && isPc == game.isPc && Objects.equals(title, game.title) && Objects.equals(genre, game.genre) && Objects.equals(availableDate, game.availableDate) && Objects.equals(availableEnd, game.availableEnd) && Objects.equals(imageUrl, game.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, isXbox, isPc, availableDate, availableEnd, imageUrl);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", isXbox=" + isXbox +
                ", isPc=" + isPc +
                ", availableDate=" + availableDate +
                ", availableEnd=" + availableEnd +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
