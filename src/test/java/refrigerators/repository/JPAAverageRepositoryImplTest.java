package refrigerators.repository;


import matcher.BeanMatcher;
import refrigerators.model.AverageTemperature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import refrigerators.util.NotFoundException;

import java.util.Arrays;
import java.util.List;

import static testData.AverageRepositoryTestData.*;
import static testData.TripTestData.TRIP2;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JPAAverageRepositoryImplTest {

    private static final BeanMatcher<AverageTemperature> MATCHER = new BeanMatcher<>();

    @Autowired
    private AverageTempRepository repository;

    @Test
    public void testSave() throws Exception {
        AverageTemperature temperature = new AverageTemperature(TRIP2, 5.8,DATE_TIME);
        AverageTemperature created = repository.save(temperature);
        temperature.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(AVERAGE1, AVERAGE2, AVERAGE3, AVERAGE4, temperature), repository.getAll());
    }

    @Test
    public void getAll() throws Exception {
        List<AverageTemperature> all = repository.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(AVERAGE1, AVERAGE2, AVERAGE3, AVERAGE4), all);
    }

    @Test
    public void testDelete() throws Exception {
        repository.delete(FIRST_AVERAGE_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(AVERAGE2, AVERAGE3, AVERAGE4), repository.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        repository.delete(1);
    }

    @Test
    public void testGet() throws Exception {
        AverageTemperature temperature = repository.get(FIRST_AVERAGE_ID + 1);
        MATCHER.assertEquals(AVERAGE2, temperature);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        repository.get(1);
    }

    @Test
    public void testUpdate() throws Exception {
        AverageTemperature updated = repository.get(FIRST_AVERAGE_ID + 1);
        updated.setAverageTemperature(100.);
        repository.save(updated);
        MATCHER.assertEquals(updated, repository.get(FIRST_AVERAGE_ID + 1));
    }
}