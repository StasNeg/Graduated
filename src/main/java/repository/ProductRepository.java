package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();

    Product get(Integer id);

    void delete(Integer id);

    Product save(Product product);





}
