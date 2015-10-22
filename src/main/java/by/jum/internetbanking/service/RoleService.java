package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.Role;

public interface RoleService {
    void deleteRole(Role role);

    Role getRoleById(Long id);

    void saveRole(Role role);
}
