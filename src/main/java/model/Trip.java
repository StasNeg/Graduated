package model;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Trip.DELETE, query = "DELETE FROM Trip trip WHERE trip.id=:id"),
        @NamedQuery(name = Trip.ALL, query = "SELECT t FROM Trip t JOIN fetch t.product Join Fetch t.truck"),
        @NamedQuery(name = Trip.GET_BY_ID, query = "SELECT temp FROM Trip t join t.temperatures temp " +
                "WHERE t.id=:id and t.truck.name LIKE CONCAT('%',:name,'%')")}

)

@Entity
@Access(AccessType.FIELD)
@Table(name = "trips")
public class Trip extends AbstractBaseEntity {
    public static final String DELETE = "DELETE_TRIP";
    public static final String ALL = "ALL_TRIP";
    public static final String GET_BY_ID = "GET_TRIP_BY_ID";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truck")
    @BatchSize(size = 200)
    private Truck truck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product")
    @BatchSize(size = 200)
    private Product product;


    @NotNull
    @Column(name = "trip_date", nullable = false)
    private LocalDateTime tripDate;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    private List<AverageTemperature> temperatures;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    private List<WarningTemperature> warnTemperatures;

    public Trip() {
    }

    public Trip(Integer id, Truck truck, Product product, LocalDateTime tripDate) {
        super(id);
        this.truck = truck;
        this.product = product;
        this.tripDate = tripDate;
    }

    public Trip(Integer id, Truck truck, Product product, LocalDateTime tripDate, List<AverageTemperature> temperatures, List<WarningTemperature> warnTemperatures) {
        super(id);
        this.truck = truck;
        this.product = product;
        this.tripDate = tripDate;
        this.temperatures = temperatures;
        this.warnTemperatures = warnTemperatures;
    }

    public Trip(Truck truck, Product product, LocalDateTime tripDate, List<AverageTemperature> temperatures, List<WarningTemperature> warnTemperatures) {
        this.truck = truck;
        this.product = product;
        this.tripDate = tripDate;
        this.temperatures = temperatures;
        this.warnTemperatures = warnTemperatures;
    }

    public Trip(Truck truck, Product product, LocalDateTime tripDate) {
        this.truck = truck;
        this.product = product;
        this.tripDate = tripDate;
    }


    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck idTruck) {
        this.truck = idTruck;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product idProduct) {
        this.product = idProduct;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public List<AverageTemperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<AverageTemperature> temperatures) {
        this.temperatures = temperatures;
    }

    public List<WarningTemperature> getWarnTemperatures() {
        return warnTemperatures;
    }

    public void setWarnTemperatures(List<WarningTemperature> warnTemperatures) {
        this.warnTemperatures = warnTemperatures;
    }

    @Override
    public String toString() {
        return super.toString()+ "Trip{" +
//                "truck=" + truck +
//                ", product=" + product +
                ", tripDate=" + tripDate +
                "} " ;
    }
}
