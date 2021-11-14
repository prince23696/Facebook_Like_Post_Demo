package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.UserRegistrationForm;
import com.FackbookPostDemo.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public UserRegistrationForm save(UserRegistrationDto registrationDto);

    public UserRegistrationForm saveUser(UserRegistrationForm userRegistrationForm);

    public List<UserRegistrationForm> getAllUsers();

    public UserRegistrationForm getUser(int id);

    public String deleteUser(int id);

    public String updateUser(int id, UserRegistrationForm userRegistrationForm);
}