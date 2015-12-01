package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.RoleDAO;
import by.jum.internetbanking.entity.Role;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends AbstractBaseDAO implements RoleDAO {

    private static final Logger LOGGER = Logger.getLogger(RoleDAOImpl.class);

    @Override
    public void delete(Role role) {
        super.delete(role);
        LOGGER.info("RoleDAO: Role deleted");
    }

    @Override
    public Role getById(Long id) {
        Role role = (Role) super.getByID(Role.class, id);
        LOGGER.info("RoleDAO getByID: role is " + role);
        return role;
    }

    @Override
    public void save(Role role) {
        super.save(role);
        LOGGER.info("RoleDAO save: role is " + role.getRoleUser());
    }
}
