package revature.project2.Model;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    int commentId;
    @Column(name = "comment_body")
    String textbody;
    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;
    @ManyToOne
    @JoinColumn(name = "game_id")
    Game game;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getTextbody() {
        return textbody;
    }

    public void setTextbody(String textbody) {
        this.textbody = textbody;
    }

    public Users getUser() {
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
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", textbody='" + textbody + '\'' +
                ", user=" + user +
                '}';
    }
}
