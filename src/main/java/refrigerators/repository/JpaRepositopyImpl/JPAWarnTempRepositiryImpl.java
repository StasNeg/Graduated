package refrigerators.repository.JpaRepositopyImpl;


import refrigerators.model.WarningTemperature;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import refrigerators.repository.DAO.AbstractDaoImpl;
import refrigerators.repository.WarnTempRepository;
import refrigerators.util.NotFoundException;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JPAWarnTempRepositiryImpl extends AbstractDaoImpl<WarningTemperature> implements WarnTempRepository {

    public JPAWarnTempRepositiryImpl() {
        super(WarningTemperature.class);
    }

    @Override
    public List<WarningTemperature> getAll() {
        return em.createNamedQuery(WarningTemperature.ALL, WarningTemperature.class).getResultList();
    }

    @Override
    @Transactional
    public WarningTemperature save(WarningTemperature warn) {
        if (warn.isNew()) {
            em.persist(warn);
            return warn;
        } else {
            return em.merge(warn);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        WarningTemperature current = super.get(id);
        if(current == null) throw new NotFoundException("Warn Temperature with id " + id + " is not available");
        em.remove(current);
    }

    @Override
    public WarningTemperature get(Integer id) {
        WarningTemperature current = super.get(id);
        if(current==null) throw new NotFoundException("Warn Temperature with id " + id + " is not available");
        return current;
    }
}
