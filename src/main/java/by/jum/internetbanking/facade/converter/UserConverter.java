package by.jum.internetbanking.facade.converter;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.form.RegistrationUserForm;
import by.jum.internetbanking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter{

    @Autowired
    private RoleService roleService;


    public UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserID(user.getUserID());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setSurname(user.getSurname());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setPassportNumber(user.getPassportNumber());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
//        userDTO.setUserRole(user.getRole());
        
        return userDTO;
    }

    public User convertToUser(UserDTO userDTO){
        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setSurname(user.getSurname());
        user.setSecondName(userDTO.getSecondName());
        user.setPassportNumber(userDTO.getPassportNumber());
        user.setLogin(userDTO.getLogin());
        user.setPassportNumber(userDTO.getPassword());

        return user;
    }


    public User convertUserFormToUser(RegistrationUserForm registrationUserForm){
        User user = new User();
        user.setFirstName(registrationUserForm.getFirstName());
        user.setSurname(registrationUserForm.getSurname());
        user.setSecondName(registrationUserForm.getSecondName());
        user.setPassportNumber(registrationUserForm.getPassportNumber());
        user.setPassword(registrationUserForm.getPassword());
        user.setLogin(registrationUserForm.getLogin());

        return user;
    }
}
