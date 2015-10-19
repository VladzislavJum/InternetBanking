package by.jum.internetbanking.facade.converter;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter{

    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName(user.getFirstName());
        userDTO.setSurname(user.getSurname());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setPassportNumber(user.getPassportNumber());
        
        return userDTO;
    }

    public User convertToUser(UserDTO userDTO){
        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setSurname(user.getSurname());
        user.setSecondName(userDTO.getSecondName());
        user.setPassportNumber(userDTO.getPassportNumber());

        return user;
    }
}
