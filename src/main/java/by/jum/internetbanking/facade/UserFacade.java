package by.jum.internetbanking.facade;

import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.form.RegistrationUserForm;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    @Autowired
    private UserService userService;
    public void registerUser(RegistrationUserForm registrationUserForm){
        User user = new User();
        user.setFirstName(registrationUserForm.getFirstName());
        user.setSurname(registrationUserForm.getSurname());
        user.setSecondName(registrationUserForm.getSecondName());
        user.setPassportNumber(registrationUserForm.getPassportNumber());

        userService.registerUser(user);
    }

}
