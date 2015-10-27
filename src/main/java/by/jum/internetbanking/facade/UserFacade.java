package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.form.RegistrationUserForm;

import java.util.List;

public interface UserFacade {
    void registerUser(RegistrationUserForm registrationUserForm);

    UserDTO getUserByID(long userID);

    List<UserDTO> getUserList();

    List<BankAccountDTO> getUserAccountList(String login);

    User getUserByUserName(String login);


}
