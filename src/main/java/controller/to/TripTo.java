package controller.to;


import model.Trip;

public class TripTo {
    private Integer idTrip;
    private Integer[] temperature;

    public TripTo(Integer idTrip, Integer[] temperature) {
        this.idTrip = idTrip;
        this.temperature = temperature;
    }

    public static TripTo fromTrip(Trip from){
        Integer[] temp = {from.getProduct().getMinTemperature(), from.getProduct().getMaxTemperature()};
        return new TripTo(from.getId(), temp);
    }

}
