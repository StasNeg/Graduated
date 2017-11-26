package repository.JpaRepositopyImpl;

import model.Truck;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.DAO.AbstractDaoImpl;
import repository.TruckRepository;
import util.NotFoundException;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JPATruckRepositoryImpl extends AbstractDaoImpl<Truck> implements TruckRepository {

    public JPATruckRepositoryImpl() {
        super(Truck.class);
    }

    @Override
    @Transactional
    public Truck save(Truck truck) {
        if (truck.isNew()) {
            em.persist(truck);
            return truck;
        } else {
            return em.merge(truck);
        }
    }
    @Override
    public Truck get(Integer id) {
        Truck getTruck = em.find(Truck.class, id);
        if (getTruck == null) throw new NotFoundException("User with id " + id + " is not available");
        return getTruck;
    }


    @Override
    @Transactional
    public void delete(Integer id) {
        if (em.createNamedQuery(Truck.DELETE)
                .setParameter("id", id)
                .executeUpdate() == 0) throw new NotFoundException("User with id " + id + " is not available");
    }


    @Override
    public List<Truck> getAll() {
        return em.createNamedQuery(Truck.ALL, Truck.class).getResultList();
    }
}