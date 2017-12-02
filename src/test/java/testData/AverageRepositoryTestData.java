package testData;

import refrigerators.model.AverageTemperature;

import java.time.LocalDateTime;

import static testData.TripTestData.*;


public class AverageRepositoryTestData {
    public static final int FIRST_AVERAGE_ID = FIRST_TRIP_ID+4;
    public static final LocalDateTime DATE_TIME = LocalDateTime.of(2017,11,27,13,0);
    public static final AverageTemperature AVERAGE1 = new AverageTemperature(FIRST_AVERAGE_ID,TRIP1, -12.7, DATE_TIME);
    public static final AverageTemperature AVERAGE2 = new AverageTemperature(FIRST_AVERAGE_ID+1, TRIP1, -14.7, DATE_TIME);
    public static final AverageTemperature AVERAGE3 = new AverageTemperature(FIRST_AVERAGE_ID+2,TRIP2, -2.7, DATE_TIME);
    public static final AverageTemperature AVERAGE4 = new AverageTemperature(FIRST_AVERAGE_ID+3,TRIP2, 12.7, DATE_TIME);

}
