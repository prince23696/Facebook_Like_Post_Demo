package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.UserRegistrationForm;

import java.util.List;

public interface UserService {

    public UserRegistrationForm saveUser(UserRegistrationForm userRegistrationForm);

    public List<UserRegistrationForm> getAllUsers();

    public UserRegistrationForm getUser(int id);

    public String deleteUser(int id);

    public String updateUser(int id, UserRegistrationForm userRegistrationForm);
}
