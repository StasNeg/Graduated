package refrigerators.controller.to;

import java.io.Serializable;

public class ProductTo implements Serializable {
    private int id;
    private int minTemperature;
    private int maxTemperature;
    private String name;

    public ProductTo() {
    }

    public ProductTo(int id, int minTemperature, int maxTemperature, String name) {
        this.id = id;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
