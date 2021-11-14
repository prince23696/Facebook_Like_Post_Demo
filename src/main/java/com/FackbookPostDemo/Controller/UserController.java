package com.FackbookPostDemo.Controller;

import com.FackbookPostDemo.Entity.UserRegistrationForm;
import com.FackbookPostDemo.Service.UserService;
import com.FackbookPostDemo.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

/*
    @PostMapping("/saveUser")
    public UserRegistrationForm saveUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        return userService.save(userRegistrationDto);
    }
*/
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    /*
        @PostMapping("/saveUser")
        public UserRegistrationForm saveUser(@Valid @RequestBody UserRegistrationForm userRegistrationForm) {
            return userService.saveUser(userRegistrationForm);
        }

        @GetMapping("/getAllUsers")
        public List<UserRegistrationForm> getUsers() {
            return userService.getAllUsers();
        }

    @PostMapping("/saveUser")
    public ModelAndView saveUser(@Valid @ModelAttribute("user") UserRegistrationForm userRegistrationForm) {
        ModelAndView mav = new ModelAndView("usersList");
        userService.saveUser(userRegistrationForm);
        List<UserRegistrationForm> userRegistrationFormList = userService.getAllUsers();
        mav.addObject("list", userRegistrationFormList);
        return mav;
    }

    @GetMapping("/getAllUsers")
    public ModelAndView getUsers() {
        ModelAndView mav = new ModelAndView("userList");
        List<UserRegistrationForm> list = userService.getAllUsers();
        mav.addObject("list", list);
        return mav;
    }
*/

    @GetMapping("/getUser/{id}")
    public UserRegistrationForm getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PutMapping("/updatePassword/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UserRegistrationForm userRegistrationForm) {
        return userService.updateUser(id, userRegistrationForm);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String updateUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}