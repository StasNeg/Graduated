package refrigerators.repository.JpaRepositopyImpl;

import refrigerators.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import refrigerators.repository.DAO.AbstractDaoImpl;
import refrigerators.repository.ProductRepository;
import refrigerators.util.NotFoundException;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JPAProductRepositoryImpl extends AbstractDaoImpl<Product> implements ProductRepository {

    public JPAProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        if (product.isNew()) {
            em.persist(product);
            return product;
        } else {
            return em.merge(product);
        }
    }
    @Override
    public Product get(Integer id) {
        Product product = em.find(Product.class, id);
        if (product == null) throw new NotFoundException("Product with id " + id + " is not available");
        return product;
    }


    @Override
    @Transactional
    public void delete(Integer id) {
        if (em.createNamedQuery(Product.DELETE)
                .setParameter("id", id)
                .executeUpdate() == 0) throw new NotFoundException("Product with id " + id + " is not available");
    }


    @Override
    public List<Product> getAll() {
        return em.createNamedQuery(Product.ALL, Product.class).getResultList();
    }
}