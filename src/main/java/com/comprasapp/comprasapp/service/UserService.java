package com.comprasapp.comprasapp.service;

import com.comprasapp.comprasapp.model.User;
import com.comprasapp.comprasapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username){
        if (isEmail(username)){
            return this.userRepository.findByEmail(username);
        } else if (isPhoneNumber(username)) {
            return this.userRepository.findByPhone(username);
        }else{
            throw new IllegalArgumentException("Invalid email or phone number");
        }
    }



    private boolean isEmail(String input) {
        return input.contains("@");
    }

    private boolean isPhoneNumber(String input) {
        //check if the number is mobile or phone (spain)
        Pattern pattern = Pattern.compile("^(\\+34|0034|34)?[6789]\\d{8}$");
        return pattern.matcher(input).matches();
    }

}
