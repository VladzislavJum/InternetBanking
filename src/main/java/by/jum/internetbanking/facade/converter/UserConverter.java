package by.jum.internetbanking.facade.converter;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.form.RegistrationUserForm;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserID(user.getUserID());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setSurname(user.getSurname());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassportNumber(user.getPassportNumber());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
//        userDTO.setUserRole(user.getRole());

        return userDTO;
    }

    public User convertToUser(UserDTO userDTO) {
        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setSurname(user.getSurname());
        user.setLastName(userDTO.getLastName());
        user.setPassportNumber(userDTO.getPassportNumber());
        user.setLogin(userDTO.getLogin());
        user.setPassportNumber(userDTO.getPassword());

        return user;
    }


    public User convertUserFormToUser(RegistrationUserForm registrationUserForm) {
        User user = new User();
        user.setFirstName(registrationUserForm.getFirstName());
        user.setSurname(registrationUserForm.getSurname());
        user.setLastName(registrationUserForm.getLastName());
        user.setPassportNumber(registrationUserForm.getPassportNumber());
        user.setPassword(registrationUserForm.getPassword());
        user.setLogin(registrationUserForm.getLogin());

        return user;
    }
}
