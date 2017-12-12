package refrigerators.repository;

import refrigerators.model.AverageTemperature;

import java.time.LocalDateTime;
import java.util.List;

public interface AverageTempRepository {
    List<AverageTemperature> getAll();

    AverageTemperature get(Integer id);

    void delete(Integer id);

    AverageTemperature save(AverageTemperature average);


    List getByCountWarningBetween(LocalDateTime start, LocalDateTime end);
}
