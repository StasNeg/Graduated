package model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.FIELD)
@Table(name = "warn")
public class WarningTemperature extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Trip", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Trip trip;

    @NotNull
    @Column(name = "exceed_temperature", nullable = false)
    private int exceedTemperature;

    @NotNull
    @Column(name = "lower_temperature", nullable = false)
    private int lowerTemperature;

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
}
