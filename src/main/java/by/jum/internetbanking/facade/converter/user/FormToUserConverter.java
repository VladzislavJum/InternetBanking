package by.jum.internetbanking.facade.converter.user;

import by.jum.internetbanking.entity.Role;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FormToUserConverter implements Converter<RegistrationUserForm, User> {

    private static final long ID_USER_ROLE = 1L;

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
        Role role = new Role();
        role.setRoleID(ID_USER_ROLE);
        user.setRole(role);
        return user;
    }
}
