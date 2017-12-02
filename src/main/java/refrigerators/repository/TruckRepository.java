package refrigerators.repository;

import refrigerators.model.Truck;


import java.util.List;

public interface TruckRepository {
    List<Truck> getAll();

    Truck get(Integer id);

    void delete(Integer id);

    Truck save(Truck truck);





}
