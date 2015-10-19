package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.facade.converter.UserConverter;
import by.jum.internetbanking.form.RegistrationUserForm;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userFacade")
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    public void registerUser(UserDTO userDTO) {
       userService.registerUser(userConverter.convertToUser(userDTO));
    }

    public UserDTO getUserByID(long userID) {
        return userConverter.convertToUserDTO(userService.getUserByID(userID));
    }

    public List<UserDTO> getUserList(){
        List<UserDTO> userDTOList = new ArrayList<>();

        List<User> userList = userService.getUserList();
        userList.forEach(user -> userDTOList.add(userConverter.convertToUserDTO(user)));

        return userDTOList;
    }

}