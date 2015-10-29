package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.form.user.RegistrationUserForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationUserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationUserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationUserForm userForm = (RegistrationUserForm) target;
        String firstname = userForm.getFirstname();
        checkName(firstname, errors);
    }

    private void checkName(String firstname, Errors errors) {

    }


}
