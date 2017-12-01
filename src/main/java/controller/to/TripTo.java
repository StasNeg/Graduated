package controller.to;


import model.Trip;

public class TripTo {
    private Integer idTrip;
    private Integer tempMin;
    private Integer tempMax;

    public TripTo(Integer idTrip, Integer tempMin, Integer tempMax) {
        this.idTrip = idTrip;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public static TripTo fromTrip(Trip from){
        return new TripTo(from.getId(), from.getProduct().getMinTemperature(), from.getProduct().getMaxTemperature());
    }

}
