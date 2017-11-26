package model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static model.Truck.DELETE;

@NamedQueries({
        @NamedQuery(name = DELETE, query = "DELETE FROM Truck u WHERE u.id=:id"),
        @NamedQuery(name = Truck.ALL, query = "SELECT t FROM Truck t")}
        )

@Entity
@Access(AccessType.FIELD)
@Table(name = "trucks")
public class Truck extends AbstractBaseEntity {
    public static final String DELETE = "DELETE";
    public static final String ALL = "ALL";

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;


    public Truck() {
    }

    public Truck(Integer id) {
        super(id);
    }

    public Truck(String name) {
        this.name = name;
    }

    public Truck(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
