package repository;

import model.AverageTemperature;

import java.util.List;

public interface AverageTempRepository {
    List<AverageTemperature> getAll();

    AverageTemperature get(Integer id);

    void delete(Integer id);

    AverageTemperature save(AverageTemperature average);





}
