package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.RoleDAO;
import by.jum.internetbanking.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends AbstractBaseDAO implements RoleDAO {
    @Override
    public void delete(Role role) {
        super.delete(role);
    }

    @Override
    public Role getById(Long id) {
        return (Role) super.getByID(Role.class, id);
    }

    @Override
    public void save(Role role) {
        super.save(role);
    }
}
