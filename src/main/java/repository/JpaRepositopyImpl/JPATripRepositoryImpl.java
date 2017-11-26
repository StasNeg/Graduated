package repository.JpaRepositopyImpl;

import model.Trip;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.DAO.AbstractDaoImpl;
import repository.TripRepository;
import util.NotFoundException;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JPATripRepositoryImpl extends AbstractDaoImpl<Trip> implements TripRepository {

    public JPATripRepositoryImpl() {
        super(Trip.class);
    }

    @Override
    @Transactional
    public Trip save(Trip trip) {
        if (trip.isNew()) {
            em.persist(trip);
            return trip;
        } else {
            return em.merge(trip);
        }
    }
    @Override
    public Trip get(Integer id) {
        Trip getTrip = em.find(Trip.class, id);
        if (getTrip == null) throw new NotFoundException("Trip with id " + id + " is not available");
        return getTrip;
    }


    @Override
    @Transactional
    public void delete(Integer id) {
        if (em.createNamedQuery(Trip.DELETE)
                .setParameter("id", id)
                .executeUpdate() == 0) throw new NotFoundException("User with id " + id + " is not available");
    }


    @Override
    public List<Trip> getAll() {
        return em.createNamedQuery(Trip.ALL, Trip.class).getResultList();
    }
}