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

    private static final String NAME_PATTERN = "[a-zA-Z]+";
    private static final String PASSPORT_NUMBER_LOGIN_PASS_PATTERN = "[a-zA-Z0-9]+";

    @Autowired
    private UserFacade userFacade;

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
        checkPassword(userForm.getPassword(), errors, "password");
    }

    private void checkName(String name, Errors errors, String param) {
        if (StringUtils.isEmpty(name)) {
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
        if (StringUtils.isEmpty(passportNumber)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (passportNumber.length() > 15 || passportNumber.length() < 8) {
            errors.rejectValue(param, "registration.label.error.passportnumbersize");
        } else {
            pattern = Pattern.compile(PASSPORT_NUMBER_LOGIN_PASS_PATTERN);
            matcher = pattern.matcher(passportNumber);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
            } else if (userFacade.isExistUserWithPassportNumber(passportNumber)) {
                errors.rejectValue(param, "registration.label.error.passportnumberexist");

            }
        }
    }

    private void checkUserLogin(String userLogin, Errors errors, String param) {
        if (StringUtils.isEmpty(userLogin)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (userLogin.length() > 15 || userLogin.length() < 4) {
            errors.rejectValue(param, "common.label.error.loginsize");
        } else {
            pattern = Pattern.compile(PASSPORT_NUMBER_LOGIN_PASS_PATTERN);
            matcher = pattern.matcher(userLogin);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
            } else if (userFacade.getUserByUserName(userLogin) != null) {
                errors.rejectValue(param, "registration.label.error.loginexist");
            }
        }
    }

    private void checkPassword(String password, Errors errors, String param) {
        if (StringUtils.isEmpty(password)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (password.length() > 10 || password.length() < 4) {
            errors.rejectValue(param, "registration.label.error.passwordsize");
        } else {
            pattern = Pattern.compile(PASSPORT_NUMBER_LOGIN_PASS_PATTERN);
            matcher = pattern.matcher(password);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
            }
        }
    }
}
