package refrigerators.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import refrigerators.controller.to.FrontPostTo;
import refrigerators.controller.to.ProductTo;
import refrigerators.model.Product;
import refrigerators.repository.ProductRepository;

import java.util.Map;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping(path = PathConstants.GET_PRODUCT_ALL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo getAll() {
        return new FrontPostTo(true, repository.getAll());
    }

    @PostMapping(path = PathConstants.POST_PRODUCT_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo save(@RequestBody(required = false) ProductTo product) {

        repository.save(new Product(product.getId() == 0 ? null : product.getId(), product.getName(), product.getMinTemperature(), product.getMaxTemperature()));
        return new FrontPostTo(true, repository.getAll());
    }

    @PostMapping(path = PathConstants.POST_PRODUCT_GET_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo getById(@RequestBody(required = false) Map<String,Object> ss) {

        int id = (int)ss.get("id");
        return new FrontPostTo(true, repository.get(id));
    }
    @PostMapping(path = PathConstants.POST_PRODUCT_DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo delete(@RequestBody(required = false) Map<String,Object> ss) {

        int id = (int)ss.get("id");
        repository.delete(id);
        return new FrontPostTo(true, null);
    }
}
