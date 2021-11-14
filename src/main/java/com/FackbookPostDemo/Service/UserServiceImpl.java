package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.UserRegistrationForm;
import com.FackbookPostDemo.Repository.UserRepository;
import com.FackbookPostDemo.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserRegistrationForm save(UserRegistrationDto registrationDto) {
        UserRegistrationForm user = new UserRegistrationForm(registrationDto.getName(), registrationDto.getEmail(), registrationDto.getArea(), registrationDto.getAddress(), registrationDto.getDob(), registrationDto.getPhone(),
                passwordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserRegistrationForm userRegistrationForm = userRepository.findByEmail(username);
        if (userRegistrationForm == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(userRegistrationForm.getEmail(), userRegistrationForm.getPassword(), new ArrayList<>());
    }

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