package revature.project2.Data;

import revature.project2.Model.Comment;

public interface CommentDAO {
    public Comment addComment(Comment comment);
    public Comment deleteComment(Comment comment);
}
