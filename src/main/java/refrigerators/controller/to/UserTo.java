package refrigerators.controller.to;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import refrigerators.model.user.Role;
import refrigerators.model.user.User;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

public class UserTo  implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    @Size(min = 5, max = 32, message = "length must between 5 and 32 characters")
    private String password;
    public UserTo() {
    }
    @NotBlank
    private Set<Role> roles;

    public UserTo(Integer id, String name, String email, String password) {
        this.id =id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public UserTo(Integer id, String name, String email, String password, Set<Role> roles) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static User createNewFromTo(UserTo newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), Role.ROLE_USER);
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getEmail(), user.getPassword(),user.getRoles());
    }

    public static boolean assureIdConsistent(UserTo userTo, Integer id) {
        return  userTo.getId().equals(id);
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }

    public static User fromTo(UserTo userTo) {
        return new User(userTo.getId(), userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.ROLE_USER);
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
