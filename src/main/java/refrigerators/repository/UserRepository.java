package refrigerators.repository;

import refrigerators.model.user.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User get(Integer id);

    void delete(Integer id);

    User save(User user);

    User getByEmail(String email);



}
