package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.form.user.RegistrationUserForm;

import java.util.List;

public interface UserFacade {
    void registerUser(RegistrationUserForm registrationUserForm);

    UserDTO getUserByID(long userID);

    List<UserDTO> getUserList();

    List<BankAccountDTO> getUserAccountList(long userID);

    UserDTO getUserByUserName(String login);

    void deleteUserByID(long id);

    boolean isExistUserWithPassportNumber(String passportNumber);

    long getIDCurrentUser();

    void lockOrUnlockUser(long id);
}
