package refrigerators.repository;


import matcher.BeanMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import refrigerators.model.AverageTemperature;
import refrigerators.util.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static testData.AverageRepositoryTestData.*;
import static testData.TripTestData.TRIP2;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml",
//        "classpath:spring/spring-mvc.xml",
//        "classpath:spring/spring-security.xml",
})
@RunWith(SpringJUnit4ClassRunner.class)
//@Sql(config = @SqlConfig(encoding = "UTF-8"))
public class JPAWarnRepositoryImplTest {


    @Autowired
    private WarnTempRepository repository;

    @Test
    public void testGetNotFound() throws Exception {
        System.out.println("BETWEEN wil be 3 objects: " + repository.getByCountWarningBetween(21,
                LocalDateTime.of(2017, 11, 27, 13, 0),
                LocalDateTime.of(2017, 12, 27, 13, 0)).size());

        System.out.println("COUNT wil be 4 objects: " + repository.getByCountWarningBetween(0,
                null,
                null).size());
        System.out.println("FROM will be 3 objects: " + repository.getByCountWarningBetween(21,
                LocalDateTime.of(2017, 11, 27, 13, 0),
                null).size());
        System.out.println("DUE will be 0 objects: " + repository.getByCountWarningBetween(21,
                null,
                LocalDateTime.of(2017, 11, 27, 13, 0)).size());
    }


}