package refrigerators.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = WarningTemperature.ALL, query = "SELECT w FROM WarningTemperature w"),
})


@Entity
@Access(AccessType.FIELD)
@Table(name = "warn")
public class WarningTemperature extends AbstractBaseEntity {

    public static final java.lang.String ALL = "WARN_ALL";
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
