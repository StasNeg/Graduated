package repository.JpaRepositopyImpl;


import model.AverageTemperature;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.AverageTempRepository;
import repository.DAO.AbstractDaoImpl;
import util.NotFoundException;

import java.util.List;
@Repository
@Transactional(readOnly = true)
public class JPAAwerageTempRepositiryImpl extends AbstractDaoImpl<AverageTemperature> implements AverageTempRepository {

    public JPAAwerageTempRepositiryImpl() {
        super(AverageTemperature.class);
    }

    @Override
    public List<AverageTemperature> getAll() {
        return em.createNamedQuery(AverageTemperature.ALL, AverageTemperature.class).getResultList();
    }

    @Override
    @Transactional
    public AverageTemperature save(AverageTemperature average) {
        if (average.isNew()) {
            em.persist(average);
            return average;
        } else {
            return em.merge(average);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        AverageTemperature current = super.get(id);
        if(current == null) throw new NotFoundException("Average Temperature with id " + id + " is not available");
        em.remove(current);
    }

    @Override
    public AverageTemperature get(Integer id) {
        AverageTemperature current = super.get(id);
        if(current==null) throw new NotFoundException("Average Temperature with id " + id + " is not available");
        return current;
    }
}
