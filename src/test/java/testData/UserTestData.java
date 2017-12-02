package testData;


import matcher.BeanMatcher;
import refrigerators.model.user.Role;
import refrigerators.model.user.User;

import java.util.Objects;

import static refrigerators.model.AbstractBaseEntity.START_SEQ;


public class UserTestData {
    public static final Integer USER_ID = START_SEQ;
    public static final Integer ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "password", Role.ROLE_ADMIN);

    public static final BeanMatcher<User> MATCHER = new BeanMatcher<>(
            (expected, actual) -> expected == actual ||
                    (
                            Objects.equals(expected.getPassword(), actual.getPassword())
                             &&Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                            && Objects.equals(expected.getEmail(), actual.getEmail())
                            && Objects.equals(expected.getRoles(), actual.getRoles())
                    )
    );
}
