package by.jum.internetbanking.dao;


import by.jum.internetbanking.entity.Role;

public interface RoleDAO {
    void delete(Role role);

    Role getById(Long id);

    void save(Role role);
}
