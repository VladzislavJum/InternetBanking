package by.jum.internetbanking.facade.converter.user;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOToUserConverter implements Converter<UserDTO, User> {
    @Override
    public User convert(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setSurname(user.getSurname());
        user.setPatronymic(userDTO.getPatronymic());
        user.setPassportNumber(userDTO.getPassportNumber());
        user.setLogin(userDTO.getLogin());
        user.setPassportNumber(userDTO.getPassword());
        return user;
    }
}
