package revature.project2.Data;

import revature.project2.Model.Favorite;

public interface FavoriteDAO {

    public Favorite createFavorite(Favorite favorite);
    public Favorite deleteFavorite(Favorite favorite);
}
