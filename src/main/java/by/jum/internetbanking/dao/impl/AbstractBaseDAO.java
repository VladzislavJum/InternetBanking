package by.jum.internetbanking.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractBaseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected void save(Object object) {
        sessionFactory.getCurrentSession().save(object);
    }

    protected void delete(Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    protected void update(Object object) {
        sessionFactory.getCurrentSession().update(object);
    }

    public Object getByID(Class c, Long id) {
        return getSessionFactory().getCurrentSession().get(c, id);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
