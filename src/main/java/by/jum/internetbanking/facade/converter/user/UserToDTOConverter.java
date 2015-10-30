package by.jum.internetbanking.facade.converter.user;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToDTOConverter implements Converter<User, UserDTO>{
    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(user.getUserID());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setSurname(user.getSurname());
        userDTO.setPatronymic(user.getPatronymic());
        userDTO.setPassportNumber(user.getPassportNumber());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
