package refrigerators.controller.to;


import java.io.Serializable;

public class TempTo implements Serializable{
    private int idTrip;
    private double avgTemp;
    private Long timeStamp;
    public TempTo(int idTrip, double avgTemp, Long timeStamp) {
        super();
        this.idTrip = idTrip;
        this.avgTemp = avgTemp;
        this.timeStamp = timeStamp;
    }

    public TempTo(){}

    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "TempTo [idTrip=" + idTrip + ", avgTemp=" + avgTemp + ", timeStamp=" + timeStamp + "]";
    }

}