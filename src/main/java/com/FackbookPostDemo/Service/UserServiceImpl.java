package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.UserRegistrationForm;
import com.FackbookPostDemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserRegistrationForm saveUser(UserRegistrationForm userRegistrationForm) {
        return userRepository.save(userRegistrationForm);
    }

    @Override
    public List<UserRegistrationForm> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserRegistrationForm getUser(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User Deleted From Database id :-" + id;
    }

    @Override
    public String updateUser(int id, UserRegistrationForm userRegistrationForm) {
        UserRegistrationForm userRegistrationForm1 = userRepository.findById(id).get();
        userRegistrationForm1.setPassword(userRegistrationForm.getPassword());
        userRepository.save(userRegistrationForm1);
        return "Password updated Successfully";
    }
}
