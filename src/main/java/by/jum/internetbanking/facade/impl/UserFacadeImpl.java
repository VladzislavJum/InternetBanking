package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.Role;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    private final static long ID_USER_ROLE = 1L;

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<RegistrationUserForm, User> formToUserConverter;

    @Autowired
    private Converter<List<BankAccount>, List<BankAccountDTO>> accountListToDTOListConverter;

    @Autowired
    private Converter<User, UserDTO> userToDTOConverter;

    @Autowired
    private Converter<List<User>, List<UserDTO>> userListToDTOListConverter;

    public void registerUser(RegistrationUserForm registrationUserForm) {
        User user = formToUserConverter.convert(registrationUserForm);
        Role role = new Role();
        role.setRoleID(ID_USER_ROLE);
        user.setRole(role);
        userService.registerUser(user);
    }

    public UserDTO getUserByID(long userID) {
        return userToDTOConverter.convert(userService.getUserByID(userID));
    }

    public List<UserDTO> getUserList() {
        List<User> userList = userService.getUserList();
        return userListToDTOListConverter.convert(userList);
    }

    @Override
    public List<BankAccountDTO> getUserAccountList(long userID) {
        return accountListToDTOListConverter.convert(userService.getUserAccountList(userID));
    }

    @Override
    public UserDTO getUserByUserName(String login) {
        User user = userService.getByUserName(login);
        if (user != null) {
            return userToDTOConverter.convert(user);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUserByID(long userID) {
        userService.deleteById(userID);
    }

    @Override
    public boolean isExistUserWithPassportNumber(String passportNumber) {
        return userService.isExistUserWithPassportNumber(passportNumber);
    }

    @Override
    public long getIDCurrentUser() {
        return userService.getIDCurrentUser();
    }

    @Override
    public void lockOrUnlockUser(long id) {
        userService.lockOrUnlockUser(id);
    }
}