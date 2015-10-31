package by.jum.internetbanking.facade.converter.user;

import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FormToUserConverter implements Converter<RegistrationUserForm, User> {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User convert(RegistrationUserForm registrationUserForm) {
        User user = new User();
        user.setFirstname(registrationUserForm.getFirstname());
        user.setSurname(registrationUserForm.getSurname());
        user.setPatronymic(registrationUserForm.getPatronymic());
        user.setPassportNumber(registrationUserForm.getPassportNumber());
        user.setPassword(passwordEncoder.encode(registrationUserForm.getPassword()));
        user.setLogin(registrationUserForm.getLogin());
        return user;
    }
}
