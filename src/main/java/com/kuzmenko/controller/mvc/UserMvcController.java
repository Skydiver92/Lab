package com.kuzmenko.controller.mvc;

import com.kuzmenko.dto.converter.UserDTOConverter;
import com.kuzmenko.service.UserService;
import com.kuzmenko.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ITRex Group
 */

@Controller
public class UserMvcController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @Autowired
    private UserValidator userValidator;

//    @Autowired
//    private SecurityService securityService;

//    @Autowired
//    private AuthenticationManager authenticationManager;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/perform_login", method = RequestMethod.POST)
    public String performLogin(HttpServletRequest request) {

//        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (authHeader != null && !authHeader.isEmpty() && authHeader.startsWith(Constants.BASIC_AUTH)) {
//            String encodedHeader = authHeader.split(" ")[1];
//            byte[] headerDecoded = Base64.getDecoder().decode(encodedHeader);
//            String decodedHeader = new String(headerDecoded, StandardCharsets.UTF_8);
//        String email = decodedHeader.split(":")[0];
//        String password = decodedHeader.split(":")[1];
//        securityService.autoLogin(email,password);
//
//        }

        return "hello";
//
    }

    @RequestMapping(value = "/perform_logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            request.getSession().invalidate();
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAll() {
        //List<User> users = userService.getAll();

        return new ModelAndView("hello");
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homepage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }


//    @GetMapping("{id}")
//    public ResponseEntity<UserDTO> getBYId(@PathVariable Integer id) {
//        return new ResponseEntity<>(userDTOConverter.toUserDTO(userService.getById(id)), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<MessageDTO> create(@RequestBody CreateUserDTO createUserDTO) {
//        User user = userDTOConverter.fromCreateUserDTO(createUserDTO);
//        userService.create(user);
//        return new ResponseEntity<>(MessageDTO.builder().email(user.getEmail())
//                .message(ResponseMessage.USER_CREATED.getMessage()).build(), HttpStatus.CREATED);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<MessageDTO> update(@RequestBody UserDTO newUser, @PathVariable Integer id) {
//        userService.update(userDTOConverter.fromUserDTO(newUser), id);
//        return new ResponseEntity<>(MessageDTO.builder().email(newUser.getEmail())
//                .message(ResponseMessage.USER_UPDATED.getMessage()).build(), HttpStatus.OK);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id) {
//        String email = userService.getById(id).getEmail();
//        userService.deleteById(id);
//        return new ResponseEntity<>(MessageDTO.builder().email(email)
//                .message(ResponseMessage.USER_DELETED.getMessage()).build(), HttpStatus.OK);
//    }

}
