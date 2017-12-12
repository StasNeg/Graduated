package refrigerators.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = AverageTemperature.ALL, query = "SELECT a FROM AverageTemperature a"),
        @NamedQuery(name = AverageTemperature.GET_BEETWEN, query = "" +
                "SELECT  t.tripDate, p.name, AVG(a.averageTemperature), p.minTemperature, p.maxTemperature  " +
                "FROM AverageTemperature a JOIN a.trip t Join t.product p " +
                "WHERE a.tripDate BETWEEN :startDate AND :endDate "+
                "GROUP BY t.tripDate, t.id, p.name, p.minTemperature, p.maxTemperature"),
        @NamedQuery(name = AverageTemperature.GET_FROM, query = "" +
                "SELECT  t.tripDate, p.name, AVG(a.averageTemperature), p.minTemperature, p.maxTemperature  " +
                "FROM AverageTemperature a JOIN a.trip t Join t.product p  " +
                "WHERE a.tripDate >= :startDate "+
                "GROUP BY t.tripDate, t.id, p.name, p.minTemperature, p.maxTemperature"),
        @NamedQuery(name = AverageTemperature.GET_DUE, query = "" +
                "SELECT  t.tripDate, p.name, AVG(a.averageTemperature), p.minTemperature, p.maxTemperature  " +
                "FROM AverageTemperature a JOIN a.trip t Join t.product p " +
                "WHERE a.tripDate <= :endDate " +
                "GROUP BY t.tripDate, t.id, p.name, p.minTemperature, p.maxTemperature"),
        @NamedQuery(name = AverageTemperature.GET, query = "" +
                "SELECT  t.tripDate, p.name, AVG(a.averageTemperature), p.minTemperature, p.maxTemperature   " +
                "FROM AverageTemperature a JOIN a.trip t Join t.product p " +
                "GROUP BY t.tripDate, t.id, p.name, p.minTemperature, p.maxTemperature")
})

@Entity
@Access(AccessType.FIELD)
@Table(name = "averages")
public class AverageTemperature extends AbstractBaseEntity {

    public static final String ALL = "ALL_AVERAGE";
    public static final String GET_BEETWEN = "AVERAGE_BETWEEN";
    public static final String GET_FROM = "AVERAGE_FROM";
    public static final String GET_DUE = "AVERAGE_DUE";
    public static final java.lang.String GET = "AVERAGE_GET";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Trip", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Trip trip;

    @NotNull
    @Column(name = "averageTemperature", nullable = false)
    private Double averageTemperature;

    @NotNull
    @Column(name = "trip_date", nullable = false)
    private LocalDateTime tripDate;

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public AverageTemperature() {
    }

    public AverageTemperature(Trip trip, Double averageTemperature, LocalDateTime tripDate) {
        this.trip = trip;
        this.averageTemperature = averageTemperature;
        this.tripDate = tripDate;
    }

    public AverageTemperature(Integer id, Trip trip, Double averageTemperature, LocalDateTime tripDate) {
        super(id);
        this.trip = trip;
        this.averageTemperature = averageTemperature;
        this.tripDate = tripDate;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    public String toString() {
        return "AverageTemperature{" +
                ", averageTemperature=" + averageTemperature +
                ", tripDate=" + tripDate +
                "} " + super.toString();
    }
}
