package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Trip.DELETE, query = "DELETE FROM Trip trip WHERE trip.id=:id"),
        @NamedQuery(name = Trip.ALL, query = "SELECT t FROM Trip t")}
)

@Entity
@Access(AccessType.FIELD)
@Table(name = "trips")
public class Trip extends AbstractBaseEntity {
    public static final String DELETE = "DELETE_TRIP";
    public static final String ALL = "ALL_TRIP";


    @OneToOne @MapsId
    @NotNull
//    Column(name = "id_Truck", nullable = false)
    private Truck idTruck;

    @OneToOne @MapsId
    @NotNull
//    @Column(name = "id_Products", nullable = false)
    private Product idProduct;


    @NotNull
    @Column(name = "trip_date", nullable = false)
    private LocalDateTime tripDate;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    private List<AverageTemperature> temperatures;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    private List<WarningTemperature> warnTemperatures;

    public Trip() {
    }

    public Trip(Integer id, Truck idTruck, Product idProduct, LocalDateTime tripDate, List<AverageTemperature> temperatures, List<WarningTemperature> warnTemperatures) {
        super(id);
        this.idTruck = idTruck;
        this.idProduct = idProduct;
        this.tripDate = tripDate;
        this.temperatures = temperatures;
        this.warnTemperatures = warnTemperatures;
    }

    public Trip(Truck idTruck, Product idProduct, LocalDateTime tripDate, List<AverageTemperature> temperatures, List<WarningTemperature> warnTemperatures) {
        this.idTruck = idTruck;
        this.idProduct = idProduct;
        this.tripDate = tripDate;
        this.temperatures = temperatures;
        this.warnTemperatures = warnTemperatures;
    }

    public Trip(Truck idTruck, Product idProduct, LocalDateTime tripDate) {
        this.idTruck = idTruck;
        this.idProduct = idProduct;
        this.tripDate = tripDate;
    }


    public Truck getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(Truck idTruck) {
        this.idTruck = idTruck;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
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
        return "Trip{" +
                "idTruck=" + idTruck +
                ", idProduct=" + idProduct +
                ", tripDate=" + tripDate +
                '}';
    }
}
