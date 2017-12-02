package refrigerators.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import refrigerators.model.user.Role;
import refrigerators.model.user.User;
import refrigerators.util.NotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static testData.UserTestData.*;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JPAUserRepositoryImplTest {

    static {
        SLF4JBridgeHandler.install();
    }
    @Autowired
    private UserRepository repository;

    @Test
    public void testSave() throws Exception {
        User newUser = new User(null, "New", "new@gmail.com", "newPass",  Collections.singleton(Role.ROLE_USER));
        User created = repository.save(newUser);
        newUser.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(USER,ADMIN, newUser), repository.getAll());
    }

    @Test
    public void getAll() throws Exception {
        List<User> all = repository.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(USER, ADMIN), all);
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateMailSave() throws Exception {
        repository.save(new User(null, "Duplicate", "user@yandex.ru", "newPass", Role.ROLE_USER));
    }

    @Test
    public void testDelete() throws Exception {
        repository.delete(USER_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), repository.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        repository.delete(1);
    }

    @Test
    public void testGet() throws Exception {
        User user = repository.get(USER_ID);
        MATCHER.assertEquals(USER, user);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        repository.get(1);
    }

    @Test
    public void testGetByEmail() throws Exception {
        User user = repository.getByEmail("user@yandex.ru");
        MATCHER.assertEquals(USER, user);
    }

    @Test
    public void testUpdate() throws Exception {
        User updated = repository.get(USER_ID);
        updated.setName("UpdatedName");
        repository.save(updated);
        MATCHER.assertEquals(updated, repository.get(USER_ID));
    }
}