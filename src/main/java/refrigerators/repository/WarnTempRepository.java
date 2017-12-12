package refrigerators.repository;

import refrigerators.controller.to.WarnStatisticTo;
import refrigerators.model.WarningTemperature;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface WarnTempRepository {
    List<WarningTemperature> getAll();

    WarningTemperature get(Integer id);

    void delete(Integer id);

    WarningTemperature save(WarningTemperature warn);


    List<WarnStatisticTo> getByCountWarningBetween(int count, LocalDateTime start, LocalDateTime end);
}
