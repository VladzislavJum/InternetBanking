package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.facade.converter.UserConverter;
import by.jum.internetbanking.form.RegistrationUserForm;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    public void registerUser(RegistrationUserForm registrationUserForm) {
        User user = new User();
        user.setFirstName(registrationUserForm.getFirstName());
        user.setSurname(registrationUserForm.getSurname());
        user.setSecondName(registrationUserForm.getSecondName());
        user.setPassportNumber(registrationUserForm.getPassportNumber());

        userService.registerUser(user);
    }

    public UserDTO getUserByID(long userID) {
        User user = userService.getUserByID(userID);
        
        return userConverter.convert(user);
    }

}