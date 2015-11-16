package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.form.user.RegistrationUserForm;

import java.util.List;

public interface UserFacade {
    void registerUser(RegistrationUserForm registrationUserForm);

    UserDTO getUserByID(long userID);

    List<UserDTO> getUserList();

    List<BankAccountDTO> getUserAccountList(long userID);

    List<PaymentHistoryDTO> getHistoryUserList(long userID);

    UserDTO getUserByUserName(String login);

    void deleteUserByID(long id);

    boolean isExistUserWithPassportNumber(String passportNumber);

    long getIDCurrentUser();

    void lockOrUnlockUser(long id);
}
