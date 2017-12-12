package refrigerators.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = WarningTemperature.ALL, query = "SELECT w FROM WarningTemperature w"),
        @NamedQuery(name = WarningTemperature.GET_BY_COUNT_BEETWEN, query = "" +
                "SELECT new refrigerators.controller.to.WarnStatisticTo(p.name, truck.name, count(t.id), t.id) " +
                "FROM WarningTemperature w JOIN w.trip t Join t.product p Join t.truck truck " +
                "WHERE w.tripDate BETWEEN :startDate AND :endDate " +
                "GROUP BY t.id, p.name, truck.name HAVING COUNT(t.id)>=:countId"),
        @NamedQuery(name = WarningTemperature.GET_BY_COUNT_FROM, query = "" +
                "SELECT new refrigerators.controller.to.WarnStatisticTo(p.name, truck.name, count(t.id), t.id) " +
                "FROM WarningTemperature w JOIN w.trip t Join t.product p Join t.truck truck " +
                "WHERE w.tripDate >= :startDate " +
                "GROUP BY t.id, p.name, truck.name HAVING COUNT(t.id)>=:countId"),
        @NamedQuery(name = WarningTemperature.GET_BY_COUNT_DUE, query = "" +
                "SELECT new refrigerators.controller.to.WarnStatisticTo(p.name, truck.name, count(t.id), t.id) " +
                "FROM WarningTemperature w JOIN w.trip t Join t.product p Join t.truck truck " +
                "WHERE w.tripDate <= :endDate " +
                "GROUP BY t.id, p.name, truck.name HAVING COUNT(t.id)>=:countId"),
        @NamedQuery(name = WarningTemperature.GET_BY_COUNT, query = "" +
                "SELECT new refrigerators.controller.to.WarnStatisticTo(p.name, truck.name, count(t.id), t.id) " +
                "FROM WarningTemperature w JOIN w.trip t Join t.product p Join t.truck truck " +
                "GROUP BY t.id, p.name, truck.name HAVING COUNT(t.id)>=:countId"),

})
// SELECT warn.trip_date, count(id) as count, warn.exceed_temperature, warn.lower_temperature
// FROM warn WHERE trip_date>"2017-12-19" AND trip_date<"2017-12-22"
// GROUP BY id_trip HAVING COUNT(id)>=2

@Entity
@Access(AccessType.FIELD)
@Table(name = "warn")
public class WarningTemperature extends AbstractBaseEntity {

    public static final java.lang.String ALL = "WARN_ALL";
    public static final java.lang.String GET_BY_COUNT_BEETWEN = "GET_BY_COUNT_BEETWEN";
    public static final String GET_BY_COUNT_FROM = "GET_BY_COUNT_FROM";
    public static final String GET_BY_COUNT_DUE = "GET_BY_COUNT_DUE";
    public static final String GET_BY_COUNT = "GET_BY_COUNT";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Trip", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Trip trip;


    @Column(name = "exceed_temperature", nullable = false)
    private int exceedTemperature;


    @Column(name = "lower_temperature", nullable = false)
    private int lowerTemperature;

    @NotNull
    @Column(name = "trip_date", nullable = false)
    private LocalDateTime tripDate;
    public WarningTemperature() {
    }

    public WarningTemperature(Trip trip, int exceedTemperature, int lowerTemperature) {
        this.trip = trip;
        this.exceedTemperature = exceedTemperature;
        this.lowerTemperature = lowerTemperature;
    }

    public WarningTemperature(Integer id, Trip trip, int exceedTemperature, int lowerTemperature) {
        super(id);
        this.trip = trip;
        this.exceedTemperature = exceedTemperature;
        this.lowerTemperature = lowerTemperature;
    }

    public WarningTemperature(Trip trip, int exceedTemperature, int lowerTemperature, LocalDateTime tripDate) {
        this.trip = trip;
        this.exceedTemperature = exceedTemperature;
        this.lowerTemperature = lowerTemperature;
        this.tripDate = tripDate;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getExceedTemperature() {
        return exceedTemperature;
    }

    public void setExceedTemperature(int exceedTemperature) {
        this.exceedTemperature = exceedTemperature;
    }

    public int getLowerTemperature() {
        return lowerTemperature;
    }

    public void setLowerTemperature(int lowerTemperature) {
        this.lowerTemperature = lowerTemperature;
    }

    @Override
    public String toString() {
        return "WarningTemperature{" +
                "exceedTemperature=" + exceedTemperature +
                ", lowerTemperature=" + lowerTemperature +
                "} " + super.toString();
    }
}
