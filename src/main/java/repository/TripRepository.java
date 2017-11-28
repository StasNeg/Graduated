package repository;

import model.Trip;
import model.Truck;

import java.util.List;

public interface TripRepository {
    List<Trip> getAll();

    Trip get(Integer id);

    void delete(Integer id);

    Trip save(Trip truck);

    List getByIdandNameTrack(int id, String name);



}
