/*
package com.labskeleton.kuzmenko.controller.mvc;

import com.labskeleton.kuzmenko.dto.converter.UserDTOConverter;
import com.labskeleton.kuzmenko.exception.ApiException;
import com.labskeleton.kuzmenko.exception.BindingHasErrorsException;
import com.labskeleton.kuzmenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class MvcUserController {

    private static final String RESTORATION_LINK = "/users/restore/%s";

    private static final String PAGE_ATTRIBUTE = "page";
    private static final String RESTORE_PWD_ATTRIBUTE = "mvcRestorePasswordDTO";
    private static final String MSG_FIELD_ATTRIBUTE = "messageField";
    private static final String MSG_FIELD_INPUT_VALUE = "Please, input your email";
    private static final String BTN_TXT_ATTRIBUTE = "buttonText";
    private static final String LINK_ATTRIBUTE = "link";
    private static final String LINK_TXT_VALUE = "Go to login page";
    private static final String BTN_TXT_SEND_LINK = "Send reset link";
    private static final String BTN_TXT_RESEND_LINK = "Resend link";


    @Autowired
    private UserService userService;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @Autowired
    private VerificationKeyService verificationKeyService;

    @RequestMapping
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN')")
    public ModelAndView listPageableUsers(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("users");
        Page<User> userPage = userService.find(pageable);
        modelAndView.addObject(PAGE_ATTRIBUTE, userPage.map(userDTOConverter::toDTO));
        UserDetailsService;
        SecurityContextHolder
        return modelAndView;
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    @PreAuthorize("permitAll()")
    public ModelAndView forgotPasswordPage() {
        ModelAndView modelAndView = new ModelAndView("forgotPassword");
        modelAndView.addObject(MSG_FIELD_ATTRIBUTE, MSG_FIELD_INPUT_VALUE);
        modelAndView.addObject(BTN_TXT_ATTRIBUTE, BTN_TXT_SEND_LINK);
        return modelAndView;
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    @PreAuthorize("permitAll()")
    public ModelAndView sendResetPassword(@RequestParam(value = "email") String email) {
        try {
            userService.sendPasswordRestoreKey(email, RESTORATION_LINK);
            ModelAndView modelAndView = new ModelAndView("forgotPassword");
            modelAndView.addObject(MSG_FIELD_ATTRIBUTE, NotificationDTO.Message.EMAIL_CHECK_MSG.getValue());
            modelAndView.addObject(BTN_TXT_ATTRIBUTE, BTN_TXT_RESEND_LINK);
            return modelAndView;
        } catch (ApiException e) {
            Map<String, String> label2error = new HashMap<>();
            label2error.put(MSG_FIELD_ATTRIBUTE, e.getMessage());
            label2error.put(BTN_TXT_ATTRIBUTE, BTN_TXT_SEND_LINK);
            throw new UnbindInvalidDataException(e.getMessage(), "forgotPassword", label2error);
        }
    }

    @RequestMapping(value = "/restore/{key:.+}", method = RequestMethod.GET)
    @PreAuthorize("permitAll()")
    public ModelAndView showUpdatePassword(@PathVariable("key") String key) {
        if (verificationKeyService.isResetPasswordKeyExpired(key)) {
            Map<String, String> label2error = new HashMap<>();
            label2error.put(MSG_FIELD_ATTRIBUTE, ApiException.Message.INVALID_RESET_PWD_KEY.getText());
            throw new UnbindInvalidDataException(ApiException.Message.INVALID_RESET_PWD_KEY.getText(), "error", label2error);
        }
        MvcRestorePasswordDTO restorePasswordDTO = new MvcRestorePasswordDTO();
        restorePasswordDTO.setRestoreToken(key);
        ModelAndView modelAndView = new ModelAndView("resetPassword");
        modelAndView.addObject(RESTORE_PWD_ATTRIBUTE, restorePasswordDTO);
        return modelAndView;
    }

    @RequestMapping("/reset")
    @PreAuthorize("permitAll()")
    public ModelAndView resetPassword(@Valid MvcRestorePasswordDTO restorePasswordDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingHasErrorsException(bindingResult, BindingHasErrorsException.Message.BINDING_ERR_MSG_TEXT.getText(), "resetPassword");
        }
        try {
            userService.restorePassword(restorePasswordDTO.getRestoreToken(), restorePasswordDTO.getNewPassword(), restorePasswordDTO.getConfirmPassword());
            ModelAndView modelAndView = new ModelAndView("success");
            modelAndView.addObject(MSG_FIELD_ATTRIBUTE, NotificationDTO.Message.SUCCESS_RESET_PWD_MSG.getValue());
            modelAndView.addObject(LINK_ATTRIBUTE, LINK_TXT_VALUE);
            return modelAndView;
        } catch (ApiException e) {
            Map<String, String> label2error = new HashMap<>();
            label2error.put(MSG_FIELD_ATTRIBUTE, e.getMessage());
            throw new BindingProcessErrorException(bindingResult, e.getMessage(), "resetPassword", Collections.EMPTY_MAP, label2error);
        }
    }
}
*/
