package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.facade.RoleFacade;
import by.jum.internetbanking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleFacadeImpl implements RoleFacade{

    @Autowired
    private RoleService roleService;

    @Override
    public String getRoleCurrentUser() {
        return roleService.getRoleCurrentUser();
    }
}
