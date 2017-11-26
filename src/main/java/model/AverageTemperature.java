package model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = AverageTemperature.ALL, query = "SELECT a FROM AverageTemperature a"),
})

@Entity
@Access(AccessType.FIELD)
@Table(name = "averages")
public class AverageTemperature extends AbstractBaseEntity {

    public static final String ALL = "ALL";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Trip", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Trip trip;

    @NotNull
    @Column(name = "averageTemperature", nullable = false)
    private Double averageTemperature;

    public AverageTemperature() {
    }

    public AverageTemperature(Trip trip, Double averageTemperature) {
        this.trip = trip;
        this.averageTemperature = averageTemperature;
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
}
