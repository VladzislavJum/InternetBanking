package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import by.jum.internetbanking.service.BankAccountService;
import by.jum.internetbanking.service.PaymentHistoryService;
import by.jum.internetbanking.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = Logger.getLogger(UserFacadeImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BankAccountService accountService;

    @Autowired
    private PaymentHistoryService historyService;

    @Autowired
    private ConversionService conversionService;

    public void registerUser(RegistrationUserForm registrationUserForm) {
        User user = conversionService.convert(registrationUserForm, User.class);

        userService.registerUser(user);
        LOGGER.info("Facade: Registration User");
    }

    public UserDTO getUserByID(long userID) {
        LOGGER.info("Facade: getUser by ID");
        return conversionService.convert(userService.getUserByID(userID), UserDTO.class);
    }

    public List<UserDTO> getUserList() {
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDTO.class));
        List<UserDTO> userDTOList = (List<UserDTO>) conversionService.convert(userService.getUserList(), sourceType, targetType);
        Collections.reverse(userDTOList);
        return userDTOList;
    }

    @Override
    public List<BankAccountDTO> getUserAccountList(long userID) {
        if (userService.getUserByID(userID) != null) {
            TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BankAccount.class));
            TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BankAccountDTO.class));
            List<BankAccountDTO> accountDTOList = (List<BankAccountDTO>) conversionService.convert(accountService.getAccountsByUserId(userID), sourceType, targetType);
            Collections.sort(accountDTOList, (o1, o2) -> o1.getBankAccountID().compareTo(o2.getBankAccountID()));
            return accountDTOList;
        } else {
            return null;
        }
    }

    @Override
    public List<PaymentHistoryDTO> getHistoryUserList(long userID) {
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PaymentHistory.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PaymentHistoryDTO.class));
        List<PaymentHistoryDTO> historyDTOList = (List<PaymentHistoryDTO>) conversionService.convert(historyService.getPaymentHistoryByUserId(userID), sourceType, targetType);
        Collections.reverse(historyDTOList);
        return historyDTOList;
    }

    @Override
    public UserDTO getUserByUserName(String login) {
        LOGGER.info("Facade: getUser by Username");
        User user = userService.getByUserName(login);
        if (user != null) {
            return conversionService.convert(user, UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> findListUsersByLogin(String login) {
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDTO.class));
        List<UserDTO> userDTOList = (List<UserDTO>) conversionService.
                convert(userService.findListUsersByLogin(login), sourceType, targetType);
        return userDTOList;
    }

    @Override
    public void deleteUserByID(long userID) {
        LOGGER.info("Facade: Deleting User");
        userService.deleteById(userID);
    }

    @Override
    public boolean isExistUserWithPassportNumber(String passportNumber) {
        return userService.isExistUserWithPassportNumber(passportNumber);
    }

    @Override
    public long getIDCurrentUser() {
        LOGGER.info("Facade: getID Current User");
        return userService.getIDCurrentUser();
    }

    @Override
    public void lockOrUnlockUser(long id) {
        LOGGER.info("Facade: LockOrUnlock User");
        userService.lockOrUnlockUser(id);
    }
}