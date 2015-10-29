package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.facade.converter.UserConverter;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import by.jum.internetbanking.service.RoleService;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userFacade")
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private Converter accountListToDTOListConverter;

    public void registerUser(RegistrationUserForm registrationUserForm) {
        User user = userConverter.convertUserFormToUser(registrationUserForm);
        user.setRole(roleService.getRoleById(1L));
        userService.registerUser(user);
    }

    public UserDTO getUserByID(long userID) {
        return userConverter.convertUserToDTO(userService.getUserByID(userID));
    }

    public List<UserDTO> getUserList() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userService.getUserList();
        userList.forEach(user -> userDTOList.add(userConverter.convertUserToDTO(user)));

        return userDTOList;
    }

    @Override
    public List<BankAccountDTO> getUserAccountList(String login) {
        return (List<BankAccountDTO>) accountListToDTOListConverter.convert(userService.getUserAccountList(login));
    }

    @Override
    public User getUserByUserName(String login) {
        return userService.getByUserName(login);
    }

}