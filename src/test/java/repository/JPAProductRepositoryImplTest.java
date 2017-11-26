package repository;


import matcher.BeanMatcher;
import model.Product;
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

import static testData.ProductTestData.*;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JPAProductRepositoryImplTest {

    private static final BeanMatcher<Product> MATCHER = new BeanMatcher<>();

    @Autowired
    private ProductRepository repository;

    @Test
    public void testSave() throws Exception {
        Product product = new Product("SEVEN", 5,8);
        Product created = repository.save(product);
        product.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(PRODUCT1,PRODUCT2,PRODUCT3,PRODUCT4,PRODUCT5,PRODUCT6, product), repository.getAll());
    }

    @Test
    public void getAll() throws Exception {
        List<Product> all = repository.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(PRODUCT1,PRODUCT2,PRODUCT3,PRODUCT4,PRODUCT5,PRODUCT6), all);
    }

    @Test
    public void testDelete() throws Exception {
        repository.delete(FIRST_PRODUCT_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(PRODUCT2,PRODUCT3,PRODUCT4,PRODUCT5,PRODUCT6), repository.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        repository.delete(1);
    }

    @Test
    public void testGet() throws Exception {
        Product product = repository.get(FIRST_PRODUCT_ID);
        MATCHER.assertEquals(PRODUCT1, product);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        repository.get(1);
    }

    @Test
    public void testUpdate() throws Exception {
        Product updated = repository.get( FIRST_PRODUCT_ID+1);
        updated.setName("UpdatedName");
        repository.save(updated);
        MATCHER.assertEquals(updated, repository.get(FIRST_PRODUCT_ID+1));
    }
}