package repository;


import matcher.BeanMatcher;
import model.Truck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.NotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static testData.TruckTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JPATruckRepositoryImplTest {

    private static final BeanMatcher<Truck> MATCHER = new BeanMatcher<>();

    @Autowired
    private TruckRepository repository;

    @Test
    public void testSave() throws Exception {
        Truck newTruck = new Truck("THIRD");
        Truck created = repository.save(newTruck);
        newTruck.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(FIRST,SECOND, newTruck), repository.getAll());
    }

    @Test
    public void getAll() throws Exception {
        List<Truck> all = repository.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(FIRST, SECOND), all);
    }

    @Test
    public void testDelete() throws Exception {
        repository.delete(FIRST_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(SECOND), repository.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        repository.delete(1);
    }

    @Test
    public void testGet() throws Exception {
        Truck truck = repository.get( FIRST_ID);
        MATCHER.assertEquals(FIRST, truck);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        repository.get(1);
    }



    @Test
    public void testUpdate() throws Exception {
        Truck updated = repository.get( FIRST_ID);
        updated.setName("UpdatedName");
        repository.save(updated);
        MATCHER.assertEquals(updated, repository.get(FIRST_ID));
    }
}