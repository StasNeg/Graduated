package repository;


import matcher.BeanMatcher;
import model.AverageTemperature;
import model.Trip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.NotFoundException;

import java.util.Arrays;
import java.util.List;

import static testData.ProductTestData.PRODUCT2;
import static testData.ProductTestData.PRODUCT5;
import static testData.TripTestData.*;
import static testData.TruckTestData.FIRST;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JPATripRepositoryImplTest {

    private static final BeanMatcher<Trip> MATCHER = new BeanMatcher<>();

    @Autowired
    private TripRepository repository;


    @Test
    public void testSave() throws Exception {
        Trip newTrip = new Trip(FIRST, PRODUCT2, DATE_TIME);
        Trip created = repository.save(newTrip);
        newTrip.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(TRIP1, TRIP2, TRIP3, TRIP4, newTrip), repository.getAll());
    }

    @Test
    public void getAll() throws Exception {
        List<Trip> all = repository.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(TRIP1, TRIP2, TRIP3, TRIP4), all);
    }

    @Test
    public void testDelete() throws Exception {
        repository.delete(FIRST_TRIP_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(TRIP2, TRIP3, TRIP4), repository.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        repository.delete(1);
    }

    @Test
    public void testGet() throws Exception {
        Trip trip = repository.get(FIRST_TRIP_ID);
        MATCHER.assertEquals(TRIP1, trip);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        repository.get(1);
    }

    @Test
    public void testUpdate() throws Exception {
        Trip updated = repository.get(FIRST_TRIP_ID + 1);
        updated.setProduct(PRODUCT5);
        repository.save(updated);
        MATCHER.assertEquals(updated, repository.get(FIRST_TRIP_ID + 1));
    }

    @Test
    public void testGetByIdAndName() throws Exception {
        List<AverageTemperature> list =repository.getByIdandNameTrack(FIRST_TRIP_ID+1,"SEC");
        System.out.println(list);
    }
}