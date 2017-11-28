package testData;


import model.Truck;

import static model.AbstractBaseEntity.START_SEQ;


public class TruckTestData {
    public static final int FIRST_ID = START_SEQ;
    public static final int Second_ID = START_SEQ + 1;

    public static final Truck FIRST = new Truck( FIRST_ID, "FIRST");
    public static final Truck SECOND = new Truck( Second_ID, "SECOND");

}
