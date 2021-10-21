package com.FackbookPostDemo.Controller;

import com.FackbookPostDemo.Entity.UserRegistrationForm;
import com.FackbookPostDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public UserRegistrationForm saveUser(@Valid @ModelAttribute("user") UserRegistrationForm userRegistrationForm) {
        ModelAndView modelAndView=new ModelAndView("user");
        return userService.saveUser(userRegistrationForm);
        modelAndView.addObject("list",userService)
    }

    @GetMapping("/getAllUsers")
    public List<UserRegistrationForm> getUsers() {
        return userService.getAllUsers();
    }

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
