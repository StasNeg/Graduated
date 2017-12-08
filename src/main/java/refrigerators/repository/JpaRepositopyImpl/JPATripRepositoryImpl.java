package refrigerators.repository.JpaRepositopyImpl;

import org.springframework.beans.factory.annotation.Autowired;
import refrigerators.model.AverageTemperature;
import refrigerators.model.Product;
import refrigerators.model.Trip;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import refrigerators.model.Truck;
import refrigerators.repository.DAO.AbstractDaoImpl;
import refrigerators.repository.ProductRepository;
import refrigerators.repository.TripRepository;
import refrigerators.repository.TruckRepository;
import refrigerators.util.NotFoundException;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JPATripRepositoryImpl extends AbstractDaoImpl<Trip> implements TripRepository {

    @Autowired
    private TruckRepository truckRepository;
    @Autowired
    private ProductRepository productRepository;

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
                .executeUpdate() == 0) throw new NotFoundException("Trip with id " + id + " is not available");
    }

    @Override
    public List<AverageTemperature> getByIdandNameTrack(int id, String name) {
        Query query = em.createNamedQuery(Trip.GET_BY_ID).setParameter("id", id).setParameter("name", name);
        return query.getResultList();
    }


    @Transactional
    public void save(int productId, int truckId){
        Product product = productRepository.get(productId);
        Truck truck = truckRepository.get(truckId);
        if(product==null || truck== null) return;
        save(new Trip(truck,product, LocalDateTime.now()));
    }

    @Override
    public List<Trip> getAll() {
        return em.createNamedQuery(Trip.ALL, Trip.class).getResultList();
    }
}