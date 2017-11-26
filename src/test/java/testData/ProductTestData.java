package testData;

import model.Product;

import static testData.TruckTestData.FIRST_ID;

/**
 * Created by Stanislav on 26.11.2017.
 */
public class ProductTestData {
    public static final int FIRST_PRODUCT_ID = FIRST_ID+2;
    public static final Product PRODUCT1 = new Product( FIRST_PRODUCT_ID,"FIRST",-12,-7);
    public static final Product PRODUCT2 = new Product( FIRST_PRODUCT_ID+1,"SECOND",-18,-12);
    public static final Product PRODUCT3 = new Product( FIRST_PRODUCT_ID+2,"THIRD",-18,-12);
    public static final Product PRODUCT4 = new Product( FIRST_PRODUCT_ID+3,"FORTH",-5,-3);
    public static final Product PRODUCT5 = new Product( FIRST_PRODUCT_ID+4,"FIFTH",2,8);
    public static final Product PRODUCT6 = new Product( FIRST_PRODUCT_ID+5,"SIXTH",8,17);

}
