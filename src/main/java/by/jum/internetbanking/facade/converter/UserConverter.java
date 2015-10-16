package by.jum.internetbanking.facade.converter;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDTO>{

    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName(user.getFirstName());
        userDTO.setSurname(user.getSurname());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setPassportNumber(user.getPassportNumber());
        
        return userDTO;
    }
}
