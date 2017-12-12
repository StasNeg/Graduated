package refrigerators.controller;

public class PathConstants {
    public static final String GET_TRIPS = "/trip";
    public static final String POST_WARNING_LOWER = "/lower";
    public static final String POST_WARNING_EXCEED = "/exceed";
    public static final String POST_AVER = "/avgtemp";
//    public static final String GET_TRIPS_AUTH = "/rest/all";


    //path to front
    //Users
    public static final String POST_AUTH = "/rest/auth";

    //Products
    public static final String POST_PRODUCT_UPDATE = "/rest/products/update";
    public static final String GET_PRODUCT_ALL = "/rest/products";
    public static final String POST_PRODUCT_DELETE = "/rest/products/delete";
    public static final String POST_PRODUCT_GET_BY_ID = "/rest/products/getprod";
    //Trucks
    public static final String GET_TRUCK_ALL  = "/rest/trucks";
    public static final String POST_TRUCK_UPDATE = "/rest/trucks/update";
    public static final String POST_TRUCK_DELETE = "/rest/trucks/delete";
    public static final String POST_TRUCK_GET_BY_ID = "/rest/trucks/gettruck";
    //Trips
    public static final String GET_TRIP_ALL  = "/rest/trips";
    public static final String POST_TRIP_UPDATE = "/rest//trips/update";
    //Statistic
    public static final String GET_ALL_WARNINGS_BY_IDTRIP_AND_DATE = "/rest/statistics/stat/countingWarnings";
    public static final String GET_ALL_AVERAGE_LIST = "/rest/statistics/stat/averageList";


}
