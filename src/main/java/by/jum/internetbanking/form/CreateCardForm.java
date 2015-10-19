package by.jum.internetbanking.form;


import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;

public class CreateCardForm {
    private Integer pinCode;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    private UserDTO userDTO;

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }


}
