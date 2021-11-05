package revature.project2.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;
    @Column(name = "review_rating")
    private int reviewRating;
    @Column(name = "review_body")
    private String reviewBody;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne()
    @JoinColumn(name ="game_id")
    private Game game;
    public Review()
    {
        super();
    }
    public Review(int reviewRating, String reviewBody, Users userId, Game game) {
        this.reviewRating = reviewRating;
        this.reviewBody = reviewBody;
        this.user = userId;
        this.game = game;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
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

    public void setGame(Game gameId) {
        this.game = gameId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewRating=" + reviewRating +
                ", reviewBody='" + reviewBody + '\'' +
                ", userId=" + user +
                ", GameId=" + game +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId && reviewRating == review.reviewRating && user == review.user && game == review.game && Objects.equals(reviewBody, review.reviewBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, reviewRating, reviewBody, user, game);
    }
}
