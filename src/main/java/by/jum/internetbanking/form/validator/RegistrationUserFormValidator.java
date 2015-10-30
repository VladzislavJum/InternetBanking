package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.form.user.RegistrationUserForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegistrationUserFormValidator implements Validator {

    private static final String NAME_PATTERN = "[a-zA-Z]+";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationUserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationUserForm userForm = (RegistrationUserForm) target;
        String firstname = userForm.getFirstname();
        String surname = userForm.getSurname();
        String patronymic = userForm.getPatronymic();
        checkName(firstname, errors, "firstname");
        checkName(surname, errors, "surname");
        checkName(patronymic, errors, "patronymic");
    }

    private void checkName(String name, Errors errors, String param) {
        if (!StringUtils.hasText(name)) {
            errors.rejectValue(param, "validation.label.emptyfield");
        } else if (name.length() > 20 || name.length() < 2) {
            errors.rejectValue(param, "validation.registration.namesize");
        } else {
            pattern = Pattern.compile(NAME_PATTERN);
            matcher = pattern.matcher(name);
            if (!matcher.matches()) {
                errors.rejectValue(param, "validation.registration.letters");
            }
        }
    }


}
