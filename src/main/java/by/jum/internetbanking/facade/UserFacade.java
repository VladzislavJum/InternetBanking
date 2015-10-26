package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.form.RegistrationUserForm;

import java.util.List;

public interface UserFacade {
    void registerUser(RegistrationUserForm registrationUserForm);

    UserDTO getUserByID(long userID);

    List<UserDTO> getUserList();

    List<CardDTO> getUserCardList(String login);

    List<BankAccountDTO> getUserAccountList(String login);

}
