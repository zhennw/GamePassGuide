package revature.project2.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_email")
    private String email;
    @Column(name = "username")
    private String userName;
    @Column(name = "user_fname")
    private String userFname;
    @Column(name = "user_lname")
    private String userLname;
    @Column(name ="user_role")
    private String role;
    @Column(name = "user_password")
    private String userPassword;
    public Users()
    {
        super();
    }
    public Users(String email, String userName, String userFname, String userLname, String role, String userPassword) {
        this.email = email;
        this.userName = userName;
        this.userFname = userFname;
        this.userLname = userLname;
        this.role = role;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", userFname='" + userFname + '\'' +
                ", userLname='" + userLname + '\'' +
                ", role='" + role + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && Objects.equals(email, users.email) && Objects.equals(userName, users.userName) && Objects.equals(userFname, users.userFname) && Objects.equals(userLname, users.userLname) && Objects.equals(role, users.role) && Objects.equals(userPassword, users.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, userName, userFname, userLname, role, userPassword);
    }
}
