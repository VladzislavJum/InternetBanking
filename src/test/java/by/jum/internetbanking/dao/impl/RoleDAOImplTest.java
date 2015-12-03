package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.RoleDAO;
import by.jum.internetbanking.entity.Role;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:testDatabase.xml"})
@Transactional
public class RoleDAOImplTest {

    private final static Logger LOGGER = Logger.getLogger(RoleDAOImplTest.class);

    @Autowired
    private RoleDAO roleDAO;

    private Role role;

    @Before
    public void setUp() throws Exception {
        role = new Role();
        role.setRoleUser("ROLE_ANON");
        roleDAO.save(role);
    }

    @Test
    public void testDelete() throws Exception {
        roleDAO.delete(role);
        LOGGER.info("Delete role: role is " + roleDAO.getById(role.getRoleID()));
    }

    @Test
    public void testGetById() throws Exception {
        LOGGER.info("GetByID role: role is " + roleDAO.getById(role.getRoleID()));
    }

    @Test
    public void testSave() throws Exception {
        LOGGER.info("Save role: role is " + roleDAO.getById(role.getRoleID()));
    }
}