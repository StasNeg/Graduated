package refrigerators.controller.to;

import java.io.Serializable;

public class WarnStatisticTo implements Serializable {
    private String nameTruck;
    private String nameProduct;
    private long countsWarn;
    private int idTrip;

    public WarnStatisticTo() {

    }

    public WarnStatisticTo(String nameTruck, String nameProduct, long countsWarn, int idTrip) {

        this.nameTruck = nameTruck;
        this.nameProduct = nameProduct;
        this.countsWarn = countsWarn;
        this.idTrip = idTrip;
    }

    public String getNameTruck() {
        return nameTruck;
    }

    public void setNameTruck(String nameTruck) {
        this.nameTruck = nameTruck;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public long getCountsWarn() {
        return countsWarn;
    }

    public void setCountsWarn(int countsWarn) {
        this.countsWarn = countsWarn;
    }

    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    @Override
    public String toString() {
        return "WarnStatisticTo{" +
                "nameTruck='" + nameTruck + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", countsWarn=" + countsWarn +
                ", idTrip=" + idTrip +
                '}';
    }
}
