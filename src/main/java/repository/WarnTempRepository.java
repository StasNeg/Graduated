package repository;

import model.WarningTemperature;

import java.util.List;

public interface WarnTempRepository {
    List<WarningTemperature> getAll();

    WarningTemperature get(Integer id);

    void delete(Integer id);

    WarningTemperature save(WarningTemperature warn);


}
