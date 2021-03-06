package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.RoleDAO;
import by.jum.internetbanking.entity.Role;
import by.jum.internetbanking.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public void deleteRole(Role role) {
        roleDAO.delete(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        return roleDAO.getById(id);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDAO.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public String getRoleCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Iterator<GrantedAuthority> iterator = (Iterator<GrantedAuthority>) auth.getAuthorities().iterator();
        String role = iterator.next().getAuthority();
        LOGGER.info("Role Service: getRoleCurrentUser:" + role);
        return role;
    }
}
