package by.jum.internetbanking.controllers.admin;


import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import by.jum.internetbanking.form.validator.RegistrationUserFormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class RegistrationController {

    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);

    @Autowired
    private Validator registrationUserFormValidator;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/signupform", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new RegistrationUserForm());
        return "/admin/createUser";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerUser(@ModelAttribute("userForm") RegistrationUserForm registrationUserForm,
                               final BindingResult result) {
        registrationUserFormValidator.validate(registrationUserForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation registration error");
            return "admin/createUser";
        }
        userFacade.registerUser(registrationUserForm);
        return "redirect:/admin/users";
    }
}
