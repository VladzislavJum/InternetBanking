package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.CorporationDAO;
import by.jum.internetbanking.entity.Corporation;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class CorporationDAOImplTest {

    private final static Logger LOGGER = Logger.getLogger(CorporationDAOImplTest.class);


    private Corporation corporation;

    @Autowired
    private CorporationDAO dao;

    @Before
    public void setUp() throws Exception {
        corporation = new Corporation();
        corporation.setName("TestCorp");
        dao.save(corporation);
    }

    @Test
    public void testSave() throws Exception {
        LOGGER.info("Save Corporation: corporations is " + dao.getByID(corporation.getCorporationID()));
    }

    @Test
    public void testUpdate() throws Exception {
        LOGGER.info("Corporation Name before: " + corporation.getName());
        corporation.setName("New Name");
        dao.update(corporation);
        LOGGER.info("Corporation Name after update: " + dao.getByID(corporation.getCorporationID()).getName());
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(corporation);
        LOGGER.info("Delete corporation: corporation is " + dao.getByID(corporation.getCorporationID()));
    }

    @Test
    public void testDeleteByID() throws Exception {
        dao.deleteByID(corporation.getCorporationID());
        LOGGER.info("DeleteByID corporation: corporation is " + dao.getByID(corporation.getCorporationID()));

    }

    @Test
    public void testGetByID() throws Exception {
        LOGGER.info("GetByID corporation: corporation is " + dao.getByID(corporation.getCorporationID()));

    }

    @Test
    public void testGetByName() throws Exception {
        LOGGER.info("GetByName TestCorp corporation: corporation is " + dao.getByName("TestCorp"));
    }
}