package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
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
    private Converter<RegistrationUserForm, User> formToUserConverter;

    @Autowired
    private Converter<List<BankAccount>, List<BankAccountDTO>> accountListToDTOListConverter;

    @Autowired
    private Converter<User, UserDTO> userToDTOConverter;

    public void registerUser(RegistrationUserForm registrationUserForm) {
        User user = formToUserConverter.convert(registrationUserForm);
        user.setRole(roleService.getRoleById(1L));
        userService.registerUser(user);
    }

    public UserDTO getUserByID(long userID) {
        return userToDTOConverter.convert(userService.getUserByID(userID));
    }

    public List<UserDTO> getUserList() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userService.getUserList();
        userList.forEach(user -> userDTOList.add(userToDTOConverter.convert(user)));

        return userDTOList;
    }

    @Override
    public List<BankAccountDTO> getUserAccountList(String login) {
        return accountListToDTOListConverter.convert(userService.getUserAccountList(login));
    }

    @Override
    public User getUserByUserName(String login) {
        return userService.getByUserName(login);
    }

}