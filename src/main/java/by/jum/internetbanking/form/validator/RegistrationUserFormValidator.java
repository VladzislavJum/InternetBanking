package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegistrationUserFormValidator implements Validator {

    @Autowired
    private UserFacade userFacade;

    private static final String NAME_PATTERN = "[a-zA-Z]+";
    private static final String PASSPORT_NUMBER_LOGIN_PATTERN = "[a-zA-Z0-9]+";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationUserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationUserForm userForm = (RegistrationUserForm) target;
        checkName(userForm.getFirstname(), errors, "firstname");
        checkName(userForm.getSurname(), errors, "surname");
        checkName(userForm.getPatronymic(), errors, "patronymic");
        checkPassportNumber(userForm.getPassportNumber(), errors, "passportNumber");
        checkUserLogin(userForm.getLogin(), errors, "login");
    }

    private void checkName(String name, Errors errors, String param) {
        if (!StringUtils.hasText(name)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (name.length() > 20 || name.length() < 2) {
            errors.rejectValue(param, "registration.label.error.namesize");
        } else {
            pattern = Pattern.compile(NAME_PATTERN);
            matcher = pattern.matcher(name);
            if (!matcher.matches()) {
                errors.rejectValue(param, "registration.label.error.letters");
            }
        }
    }

    private void checkPassportNumber(String passportNumber, Errors errors, String param) {
        if (!StringUtils.hasText(passportNumber)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (passportNumber.length() > 15 || passportNumber.length() < 8) {
            errors.rejectValue(param, "registration.label.error.passportnumbersize");
        } else {
            pattern = Pattern.compile(PASSPORT_NUMBER_LOGIN_PATTERN);
            matcher = pattern.matcher(passportNumber);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
            }
        }
    }

    private void checkUserLogin(String userLogin, Errors errors, String parap) {
        if (!StringUtils.hasText(userLogin)) {
            errors.rejectValue(parap, "common.label.error.emptyfield");
        } else if (userLogin.length() > 15 || userLogin.length() < 4) {
            errors.rejectValue(parap, "common.label.error.loginsize");
        } else {
            pattern = Pattern.compile(PASSPORT_NUMBER_LOGIN_PATTERN);
            matcher = pattern.matcher(userLogin);
            if (!matcher.matches()) {
                errors.rejectValue(parap, "common.label.error.numericletters");
            } else if (userFacade.getUserByUserName(userLogin) != null) {
                errors.rejectValue(parap, "registration.label.error.userexist");
            }
        }

    }



}
