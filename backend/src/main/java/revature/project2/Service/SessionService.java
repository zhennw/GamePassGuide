package revature.project2.Service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import revature.project2.Model.Favorite;
import revature.project2.Model.Game;
import revature.project2.Model.Review;
import revature.project2.Model.Users;


public class SessionService {
    private static SessionFactory sf;

    static {
        Configuration configuration = new Configuration()
                .addPackage("revature.project2.Data")
                .addAnnotatedClass(Game.class)
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Favorite.class)
                .configure();
        String url = System.getenv("posturl");
        String username = System.getenv("postuser");
        String password = System.getenv("postpass");
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        ServiceRegistry serviceRegistery =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();



        sf = configuration.buildSessionFactory(serviceRegistery);


    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

}
