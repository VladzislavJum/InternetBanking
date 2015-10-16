package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.form.RegistrationUserForm;

public interface UserFacade {
    void registerUser(RegistrationUserForm registrationUserForm);

    UserDTO getUserByID(long userID);

}
