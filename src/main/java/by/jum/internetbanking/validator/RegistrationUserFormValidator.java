package by.jum.internetbanking.validator;

import by.jum.internetbanking.form.user.RegistrationUserForm;
import by.jum.internetbanking.service.UserService;
import by.jum.internetbanking.util.ValidationConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegistrationUserFormValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(RegistrationUserFormValidator.class);

    @Autowired
    private UserService userService;

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
            LOGGER.info(param + " empty error");
        } else if (name.length() > 20 || name.length() < 2) {
            errors.rejectValue(param, "registration.label.error.namesize");
            LOGGER.info(param + " size error");
        } else {
            pattern = Pattern.compile(ValidationConstants.NAME_PATTERN.getPattern());
            matcher = pattern.matcher(name);
            if (!matcher.matches()) {
                errors.rejectValue(param, "registration.label.error.letters");
                LOGGER.info(param + " content error");
            }
        }
    }

    private void checkPassportNumber(String passportNumber, Errors errors, String param) {
        if (StringUtils.isEmpty(passportNumber)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (passportNumber.length() > 15 || passportNumber.length() < 8) {
            errors.rejectValue(param, "registration.label.error.passportnumbersize");
            LOGGER.info(param + " size error");
        } else {
            pattern = Pattern.compile(ValidationConstants.PASSPORT_NUMBER_LOGIN_PASS_PATTERN.getPattern());
            matcher = pattern.matcher(passportNumber);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
                LOGGER.info(param + " content error");
            } else if (userService.isExistUserWithPassportNumber(passportNumber)) {
                errors.rejectValue(param, "registration.label.error.passportnumberexist");
                LOGGER.info(param + " already exist error");
            }
        }
    }

    private void checkUserLogin(String userLogin, Errors errors, String param) {
        if (StringUtils.isEmpty(userLogin)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (userLogin.length() > 15 || userLogin.length() < 4) {
            errors.rejectValue(param, "common.label.error.loginsize");
            LOGGER.info(param + " size error");
        } else {
            pattern = Pattern.compile(ValidationConstants.PASSPORT_NUMBER_LOGIN_PASS_PATTERN.getPattern());
            matcher = pattern.matcher(userLogin);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
                LOGGER.info(param + " content error");
            } else if (userService.getByUserName(userLogin) != null) {
                errors.rejectValue(param, "registration.label.error.loginexist");
                LOGGER.info(param + " already exist error");
            }
        }
    }

    private void checkPassword(String password, Errors errors, String param) {
        if (StringUtils.isEmpty(password)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (password.length() > 10 || password.length() < 4) {
            errors.rejectValue(param, "registration.label.error.passwordsize");
            LOGGER.info(param + " size error");
        } else {
            pattern = Pattern.compile(ValidationConstants.PASSPORT_NUMBER_LOGIN_PASS_PATTERN.getPattern());
            matcher = pattern.matcher(password);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
                LOGGER.info(param + " content error");
            }
        }
    }
}
