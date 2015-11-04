package by.jum.internetbanking.facade.converter.user;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserListToDTOListConverter implements Converter<List<User>, List<UserDTO>>{
    @Autowired
    private Converter<User, UserDTO> userToDTOConverter;
    @Override
    public List<UserDTO> convert(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        userList.forEach(user -> userDTOList.add(userToDTOConverter.convert(user)));
        return userDTOList;
    }
}
