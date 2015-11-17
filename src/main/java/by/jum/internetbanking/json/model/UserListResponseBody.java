package by.jum.internetbanking.json.model;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.json.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class UserListResponseBody {
    @JsonView(Views.Public.class)
    private List<UserDTO> userDTOList;

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }
}
