package revature.project2.Data;

import revature.project2.Model.Review;

import java.util.List;

public interface ReviewDAO {
    public List<Review> getReviewByUser(Review review);
    public List<Review> getReviewByGame(Review review);
    public Review createReview(Review review);
    public Review deleteReview(Review review);
}
