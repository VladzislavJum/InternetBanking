package by.jum.internetbanking.dto;

import by.jum.internetbanking.entity.User;

public class CardDTO {
    private Integer pinCode;
    private UserDTO userDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Integer getPinCode() {
        return pinCode;
    }


    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}
