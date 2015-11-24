package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.CorporationDAO;
import by.jum.internetbanking.entity.Corporation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public class CorporationDAOImpl extends AbstractBaseDAO implements CorporationDAO {

    private static final Logger LOGGER = Logger.getLogger(CorporationDAOImpl.class);

    private static final String GET_CORPORATION_BY_NAME_QUERY = "from by.jum.internetbanking.entity.Corporation c where c.name=:name";

    @Autowired
    private MessageSource messageSource;

    @Override
    public void save(Corporation corporation) {
        super.save(corporation);
    }

    @Override
    public void update(Corporation corporation) {
        super.update(corporation);
    }

    @Override
    public void delete(Corporation corporation) {
        super.delete(corporation);
    }

    @Override
    public void deleteByID(long id) {
        Corporation corporation = new Corporation();
        corporation.setCorporationID(id);
        delete(getSessionFactory().getCurrentSession().merge(corporation));
        LOGGER.info("DAO: Corporation Deleted: id " + id);
    }

    @Override
    public Corporation getByID(Long id) {
        return (Corporation) super.getByID(Corporation.class, id);
    }

    @Override
    public Corporation getByName(String name) {
        Corporation corporation = (Corporation) getSessionFactory().getCurrentSession().
                createQuery(GET_CORPORATION_BY_NAME_QUERY).setParameter("name", name).uniqueResult();
        LOGGER.info(messageSource.getMessage("print.getcorpbyname", new Object[]{name, corporation}, Locale.ENGLISH));
        return corporation;
    }
}
