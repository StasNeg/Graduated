package refrigerators.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = Product.DELETE, query = "DELETE FROM Product p WHERE p.id=:id"),
        @NamedQuery(name = Product.ALL, query = "SELECT u FROM Product u"),
})


@Entity
@Access(AccessType.FIELD)
@Table(name = "products",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "" +
                "products_unique_name_idx")})
public class Product extends AbstractBaseEntity {

    public static final String DELETE = "DELETE_PRODUCT";
    public static final String ALL = "ALL_PRODUCT";

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "min_temperature", nullable = false)
    private Integer minTemperature;

    @Column(name = "max_temperature", nullable = false)
    @NotNull
    private Integer maxTemperature;

    public Product() {
    }

    public Product(Integer id, String name, Integer minTemperature, Integer maxTemperature) {
        super(id);
        this.name = name;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public Product(String name, Integer minTemperature, Integer maxTemperature) {
        this.name = name;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

}
