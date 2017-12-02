package testData;


import refrigerators.model.Trip;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static testData.ProductTestData.*;
import static testData.TruckTestData.FIRST;
import static testData.TruckTestData.SECOND;

public class TripTestData {

    public static final int FIRST_TRIP_ID = FIRST_PRODUCT_ID+6;
    public static final LocalDateTime DATE_TIME = LocalDateTime.of(2017,11,27,13,0);
    public static final Trip TRIP1 = new Trip( FIRST_TRIP_ID, FIRST,PRODUCT1,DATE_TIME);
    public static final Trip TRIP2 = new Trip( FIRST_TRIP_ID+1, SECOND,PRODUCT2,DATE_TIME);
    public static final Trip TRIP3 = new Trip( FIRST_TRIP_ID+2, FIRST,PRODUCT3,DATE_TIME);
    public static final Trip TRIP4 = new Trip( FIRST_TRIP_ID+3, SECOND,PRODUCT4,DATE_TIME);
    public static final List<Trip> TRIPS = Arrays.asList(TRIP1,TRIP2,TRIP3,TRIP4);
}
