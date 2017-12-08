package refrigerators.controller.to;


import java.io.Serializable;

public class WarnTo implements Serializable{
    private int id;
    private int temperature;
    private Long timeStamp;
    public WarnTo(int id, int temperature, Long timeStamp) {
        super();
        this.id = id;
        this.temperature = temperature;
        this.timeStamp = timeStamp;
    }

    public WarnTo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "TempTo [id=" + id + ", temperature=" + temperature + ", timeStamp=" + timeStamp + "]";
    }

}