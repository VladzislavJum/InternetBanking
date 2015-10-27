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
        userDTO.setFirstName(user.getFirstname());
        userDTO.setSurname(user.getSurname());
        userDTO.setLastname(user.getLastname());
        userDTO.setPassportNumber(user.getPassportNumber());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
//        userDTO.setUserRole(user.getRole());

        return userDTO;
    }

    public User convertToUser(UserDTO userDTO) {
        User user = new User();

        user.setFirstname(userDTO.getFirstName());
        user.setSurname(user.getSurname());
        user.setLastname(userDTO.getLastname());
        user.setPassportNumber(userDTO.getPassportNumber());
        user.setLogin(userDTO.getLogin());
        user.setPassportNumber(userDTO.getPassword());

        return user;
    }


    public User convertUserFormToUser(RegistrationUserForm registrationUserForm) {
        User user = new User();
        user.setFirstname(registrationUserForm.getFirstname());
        user.setSurname(registrationUserForm.getSurname());
        user.setLastname(registrationUserForm.getLastname());
        user.setPassportNumber(registrationUserForm.getPassportNumber());
        user.setPassword(registrationUserForm.getPassword());
        user.setLogin(registrationUserForm.getLogin());

        return user;
    }
}
