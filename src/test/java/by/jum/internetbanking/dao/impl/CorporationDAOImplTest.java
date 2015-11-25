package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.CorporationDAO;
import by.jum.internetbanking.entity.Corporation;
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

    private Corporation corporation;

    @Autowired
    private CorporationDAO dao;

    @Before
    public void setUp() throws Exception {
        corporation = new Corporation();
        corporation.setName("TestCorp");
//        corporation.setAccountNumber("789456");
    }

    @Test
    public void testSave() throws Exception {
        dao.save(corporation);
    }

    @Test
    public void testUpdate() throws Exception {
        dao.save(corporation);
//        corporation.setAccountNumber("new");
        dao.update(corporation);
    }

    @Test
    public void testDelete() throws Exception {
        dao.save(corporation);
        dao.delete(corporation);
    }

    @Test
    public void testDeleteByID() throws Exception {
        dao.save(corporation);
        dao.deleteByID(corporation.getCorporationID());
    }

    @Test
    public void testGetByID() throws Exception {
        dao.save(corporation);
        dao.getByID(corporation.getCorporationID());
    }

    @Test
    public void testGetByName() throws Exception {

    }
}