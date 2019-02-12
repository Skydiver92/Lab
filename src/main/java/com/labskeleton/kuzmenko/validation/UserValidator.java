package com.labskeleton.kuzmenko.validation;

import com.labskeleton.kuzmenko.model.User;
import com.labskeleton.kuzmenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmpty(errors, "username", "Required");
        if (user.getEmail().length() < 4 || user.getEmail().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.getByEmail(user.getEmail()) != null) {
            errors.rejectValue("username", "Duplication.userForm.username");
        }

        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
    }
}
